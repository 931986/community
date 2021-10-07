package com.example.spring_.commnity.Mapper;

import com.example.spring_.commnity.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.lang.annotation.*;

@Mapper
public interface UserMapper{
    Integer ID=2;
    @Insert("insert into USER (ACCOUNT_ID,NAME,TOKEN,GMT_CREATE,GMT_MODIFIED,AVATAR_URL) values (#{accountId},#{name},#{Token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
     public void Insert(User user);
    @Select("select * from USER where token=#{token}")
    User findToken(@Param("token")String token);
    @Select("select * from USER where id=#{id}")
    User findById(@Param("id") Integer id);
}
//       String[] value();
//
//       String databaseId() default "";
//
//       @Documented
//       @Retention(RetentionPolicy.RUNTIME)
//       @Target({ElementType.METHOD})
//       public @interface List {
//           Insert[] value();
//       }


