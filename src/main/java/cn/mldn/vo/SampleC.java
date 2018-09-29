package cn.mldn.vo;

import java.io.Serializable;

public class SampleC implements Serializable {
    private Integer cancerId ;
    private String cancerName ;
    private String sampleIdN ;
    private String sampleIdT ;

    public Integer getCancerId() {
        return cancerId;
    }

    public void setCancerId(Integer cancerId) {
        this.cancerId = cancerId;
    }

    public String getCancerName() {
        return cancerName;
    }

    public void setCancerName(String cancerName) {
        this.cancerName = cancerName;
    }

    public String getSampleIdN() {
        return sampleIdN;
    }

    public void setSampleIdN(String sampleIdN) {
        this.sampleIdN = sampleIdN;
    }

    public String getSampleIdT() {
        return sampleIdT;
    }

    public void setSampleIdT(String sampleIdT) {
        this.sampleIdT = sampleIdT;
    }

    @Override
    public String toString() {
        return "SampleC{" +
                "cancerId=" + cancerId +
                ", cancerName='" + cancerName + '\'' +
                ", sampleIdN='" + sampleIdN + '\'' +
                ", sampleIdT='" + sampleIdT + '\'' +
                '}';
    }
}
