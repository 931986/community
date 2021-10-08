package com.example.spring_.commnity.Provide;


import com.alibaba.fastjson.JSON;
import com.example.spring_.commnity.dto.AccessTokenDTO;
import com.example.spring_.commnity.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static okhttp3.MediaType.*;

@Component
//ioc依赖注入获取对象
public class GithubProvider {
    //读取超时为60s
    private static final long READ_TIMEOUT = 60000;
    //写入超时为60s
    private static final long WRITE_TIMEOUT = 60000;
    //连接超时为60s
    private static final long CONNECT_TIMEOUT = 60000;


    OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
//第二步之后的数据处理 github post accesstoken
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(10000));// （单位：毫秒）
        System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(10000)); // （单位：毫秒）

//        老版本
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
//            Request request = new Request.Builder()
//                    .url("http://github.com/login/oauth/access_token")
//                    .post(body)
//                    .build();
//        新版本
        MediaType mediaType_=MediaType.Companion.parse("application/json;charset=utf-8");
        RequestBody stringBody=RequestBody.Companion.create(JSON.toJSONString(accessTokenDTO),mediaType_);
        Request request=new Request
                .Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(stringBody)
                .build();
//            所需信息id ,name,bio,
            try (Response response = client.newCall(request).execute()) {
                String Token=response.body().string();
                String string_=Token;
                String[] tokenstr=string_.split("&");
                String[]  temp=tokenstr[0].split("=");
                String access_Token=temp[1];
                System.out.println(access_Token);


                return access_Token;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }
//Authorization请求头值：token+空格+accesstoken
    public GithubUser getUser(String accessToken){
           OkHttpClient client = new OkHttpClient();

//        Request request = new Request.Builder()
//                .url(https://api.github.com/user)
//                 .header(Authorization,token +accessToken)
//                .build();

            Request request = new Request.Builder()
                    .url("https://api.github.com/user")
                    .header("Authorization","token "+accessToken)
                    .build();
            try {Response response = client.newCall(request).execute();
                 String accessTokenString=response.body().string();



              GithubUser githubUser=JSON.parseObject(accessTokenString,GithubUser.class);
//              String-> class
//                access_token=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&scope=user&token_type=bearer
//git remote set-url origin  https://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@github.com/931986/community.git

                return githubUser;
            }catch(IOException e){
                System.out.println("???");
                e.printStackTrace();
          }
            return null;

    }

//    public static void main(String[] args){
////        IOC对象注入，不再需要传统的创建new
//
//
//    }

}
