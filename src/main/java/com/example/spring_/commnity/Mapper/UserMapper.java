package com.example.spring_.commnity.Mapper;

import com.example.spring_.commnity.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.lang.annotation.*;

@Mapper
public interface UserMapper{
    Integer ID=2;
    @Insert("insert into USER (ACCOUNT_ID,NAME,TOKEN,GMT_CREATE,GMT_MODIFIED) values (#{accountId},#{name},#{Token},#{gmtCreate},#{gmtModified})")
     public void Insert(User user);
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


