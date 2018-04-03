package com.hualala.repository.main.user;

import com.hualala.interfaces.student.StudentAddReq;
import com.hualala.interfaces.student.StudentDelReq;
import com.hualala.interfaces.student.StudentUpdateReq;
import com.hualala.interfaces.user.User;
import com.hualala.interfaces.user.UserAddReq;
import com.hualala.interfaces.user.UserDelReq;
import com.hualala.interfaces.user.UserUpdateReq;
import com.hualala.repository.main.BaseDao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao extends BaseDao {
    @Select("select * from user")
    List<User> selectAll();

    int deleteByPrimaryKey(Integer id);

    @Insert("insert into user (id, username, age) values (#{id}, #{username}, #{age})")
    int add(UserAddReq userAddReq);


    @Update("update user set username = #{username}e = #{age} where id = #{id} ")
    int update(UserUpdateReq userUpdateReq);

    @Delete("delete from user where id = #{id}")
    int delete(UserDelReq userDelReq);
}
