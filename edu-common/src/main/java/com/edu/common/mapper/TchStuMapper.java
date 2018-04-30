package com.edu.common.mapper;

import com.edu.common.pojo.TchStuExample;
import com.edu.common.pojo.TchStuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TchStuMapper {
    long countByExample(TchStuExample example);

    int deleteByExample(TchStuExample example);

    int deleteByPrimaryKey(TchStuKey key);

    int insert(TchStuKey record);

    int insertSelective(TchStuKey record);

    List<TchStuKey> selectByExample(TchStuExample example);

    int updateByExampleSelective(@Param("record") TchStuKey record, @Param("example") TchStuExample example);

    int updateByExample(@Param("record") TchStuKey record, @Param("example") TchStuExample example);
}