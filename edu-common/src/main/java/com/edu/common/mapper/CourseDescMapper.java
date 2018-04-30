package com.edu.common.mapper;

import com.edu.common.pojo.CourseDesc;
import com.edu.common.pojo.CourseDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseDescMapper {
    long countByExample(CourseDescExample example);

    int deleteByExample(CourseDescExample example);

    int deleteByPrimaryKey(Integer courseId);

    int insert(CourseDesc record);

    int insertSelective(CourseDesc record);

    List<CourseDesc> selectByExampleWithBLOBs(CourseDescExample example);

    List<CourseDesc> selectByExample(CourseDescExample example);

    CourseDesc selectByPrimaryKey(Integer courseId);

    int updateByExampleSelective(@Param("record") CourseDesc record, @Param("example") CourseDescExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseDesc record, @Param("example") CourseDescExample example);

    int updateByExample(@Param("record") CourseDesc record, @Param("example") CourseDescExample example);

    int updateByPrimaryKeySelective(CourseDesc record);

    int updateByPrimaryKeyWithBLOBs(CourseDesc record);
}