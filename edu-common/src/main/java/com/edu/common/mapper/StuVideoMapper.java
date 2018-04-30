package com.edu.common.mapper;

import com.edu.common.pojo.StuVideo;
import com.edu.common.pojo.StuVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuVideoMapper {
    long countByExample(StuVideoExample example);

    int deleteByExample(StuVideoExample example);

    int insert(StuVideo record);

    int insertSelective(StuVideo record);

    List<StuVideo> selectByExample(StuVideoExample example);

    int updateByExampleSelective(@Param("record") StuVideo record, @Param("example") StuVideoExample example);

    int updateByExample(@Param("record") StuVideo record, @Param("example") StuVideoExample example);
}