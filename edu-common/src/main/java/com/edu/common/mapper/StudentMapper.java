package com.edu.common.mapper;

import com.edu.common.pojo.Student;
import com.edu.common.pojo.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String stuAccount);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);
    
    List<Student> selectByTchAccount(@Param("tchAccount")String tchAccount);
    
    Student selectByPrimaryKey(String stuAccount);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}