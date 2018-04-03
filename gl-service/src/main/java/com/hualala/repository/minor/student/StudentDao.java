package com.hualala.repository.minor.student;

import com.hualala.interfaces.student.Student;
import com.hualala.interfaces.student.StudentAddReq;
import com.hualala.interfaces.student.StudentDelReq;
import com.hualala.interfaces.student.StudentUpdateReq;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentDao {


    @Select("select * from student")
    List<Student> selectAll();

    @Insert("insert into student (uid, username, password) values (#{uid}, #{username}, #{password})")
    int add(StudentAddReq studentAddReq);


    @Update("update student set username = #{username}, password = #{password} where uid = #{uid} ")
    int update(StudentUpdateReq studentUpdateReq);

    @Delete("delete from student where uid = #{uid}")
    int delete(StudentDelReq studentDelReq);

    int deleteByPrimaryKey(Integer id);
}
