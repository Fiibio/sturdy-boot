package com.sqh.springboot.mapper;

import com.sqh.springboot.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO STUDENT(sno,sname,sex) VALUES (#{sno}, #{sname}, #{sex})")
    int insert(Student student);
    @Update("update STUDENT set sname=#{sname},sex=#{sex} where sno=#{sno}")
    int update(Student student);
    @Delete("Delete from STUDENT where sno=#{sno}")
    int delete(String sno);
    @Select("select * from STUDENT where sno=#{sno}")
    @Results(id = "student",value= {
            @Result(property = "sno", column = "sno", javaType = String.class),
            @Result(property = "sname", column = "sname", javaType = String.class),
            @Result(property = "sex", column = "sex", javaType = String.class)
    })
    Student query(String sno);

}
