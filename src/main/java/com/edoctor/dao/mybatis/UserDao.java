package com.edoctor.dao.mybatis;

import com.edoctor.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("SELECT * FROM user")
    List<User> getUserList();

    @Select("SELECT * FROM user WHERE user_id = #{user_id}")
    User getUserById(@Param("user_id") Integer user_id);

    @Update("UPDATE user SET sex = #{sex} WHERE user_id = #{user_id}")
    void updateUserSexById(@Param("user_id") Integer user_id, @Param("sex") String sex);

    @Delete("DELETE FROM user WHERE user_id = #{user_id}")
    void deleteUserById(@Param("user_id") Integer user_id);

    @Insert("INSERT INTO user(user_id, name, dep_id, sex) VALUES(#{user_id}, #{name}, #{dep_id}, #{sex})")
    void addOneUser(@Param("user_id") Integer user_id,
                    @Param("name") String name,
                    @Param("dep_id") String dep_id,
                    @Param("sex") String sex);

    @Select("SELECT COUNT(*) FROM user")
    long count();
}
