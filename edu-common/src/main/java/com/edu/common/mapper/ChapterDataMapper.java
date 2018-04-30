package com.edu.common.mapper;

import com.edu.common.pojo.ChapterData;
import com.edu.common.pojo.ChapterDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChapterDataMapper {
    long countByExample(ChapterDataExample example);

    int deleteByExample(ChapterDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChapterData record);

    int insertSelective(ChapterData record);

    List<ChapterData> selectByExample(ChapterDataExample example);

    ChapterData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChapterData record, @Param("example") ChapterDataExample example);

    int updateByExample(@Param("record") ChapterData record, @Param("example") ChapterDataExample example);

    int updateByPrimaryKeySelective(ChapterData record);

    int updateByPrimaryKey(ChapterData record);
}