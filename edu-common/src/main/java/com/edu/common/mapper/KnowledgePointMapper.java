package com.edu.common.mapper;

import com.edu.common.pojo.KnowledgePoint;
import com.edu.common.pojo.KnowledgePointExample;
import com.edu.common.pojo.KnowledgePointWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgePointMapper {
    long countByExample(KnowledgePointExample example);

    int deleteByExample(KnowledgePointExample example);

    int deleteByPrimaryKey(Integer kpId);

    int insert(KnowledgePointWithBLOBs record);

    int insertSelective(KnowledgePointWithBLOBs record);

    List<KnowledgePointWithBLOBs> selectByExampleWithBLOBs(KnowledgePointExample example);

    List<KnowledgePoint> selectByExample(KnowledgePointExample example);

    KnowledgePointWithBLOBs selectByPrimaryKey(Integer kpId);

    int updateByExampleSelective(@Param("record") KnowledgePointWithBLOBs record, @Param("example") KnowledgePointExample example);

    int updateByExampleWithBLOBs(@Param("record") KnowledgePointWithBLOBs record, @Param("example") KnowledgePointExample example);

    int updateByExample(@Param("record") KnowledgePoint record, @Param("example") KnowledgePointExample example);

    int updateByPrimaryKeySelective(KnowledgePointWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(KnowledgePointWithBLOBs record);

    int updateByPrimaryKey(KnowledgePoint record);
}