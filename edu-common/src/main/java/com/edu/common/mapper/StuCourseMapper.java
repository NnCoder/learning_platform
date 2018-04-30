package com.edu.common.mapper;

import com.edu.common.pojo.StuCourse;
import com.edu.common.pojo.StuCourseExample;
import com.edu.common.pojo.StuCourseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuCourseMapper {
    long countByExample(StuCourseExample example);

    int deleteByExample(StuCourseExample example);

    int deleteByPrimaryKey(StuCourseKey key);

    int insert(StuCourse record);

    int insertSelective(StuCourse record);

    List<StuCourse> selectByExample(StuCourseExample example);

    StuCourse selectByPrimaryKey(StuCourseKey key);

    int updateByExampleSelective(@Param("record") StuCourse record, @Param("example") StuCourseExample example);

    int updateByExample(@Param("record") StuCourse record, @Param("example") StuCourseExample example);

    int updateByPrimaryKeySelective(StuCourse record);

    int updateByPrimaryKey(StuCourse record);
}