package com.edu.common.pojo;

public class KnowledgePointWithBLOBs extends KnowledgePoint {
    private String kpDetail;

    private String kpAdvice;

    private String kpRead;

    public String getKpDetail() {
        return kpDetail;
    }

    public void setKpDetail(String kpDetail) {
        this.kpDetail = kpDetail == null ? null : kpDetail.trim();
    }

    public String getKpAdvice() {
        return kpAdvice;
    }

    public void setKpAdvice(String kpAdvice) {
        this.kpAdvice = kpAdvice == null ? null : kpAdvice.trim();
    }

    public String getKpRead() {
        return kpRead;
    }

    public void setKpRead(String kpRead) {
        this.kpRead = kpRead == null ? null : kpRead.trim();
    }
}