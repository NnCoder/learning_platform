package com.edu.common.mapper;

import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseExample;
import com.edu.common.pojo.CourseWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer courseId);

    int insert(CourseWithBLOBs record);

    int insertSelective(CourseWithBLOBs record);

    List<CourseWithBLOBs> selectByExampleWithBLOBs(CourseExample example);

    List<Course> selectByExample(CourseExample example);

    CourseWithBLOBs selectByPrimaryKey(Integer courseId);

    int updateByExampleSelective(@Param("record") CourseWithBLOBs record, @Param("example") CourseExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseWithBLOBs record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(CourseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CourseWithBLOBs record);

    int updateByPrimaryKey(Course record);
}