package cn.mldn.vo;

import java.io.Serializable;

public class AccC implements Serializable {
    private Integer geneId ;
    private String valueNL ;
    private String valueNY ;
    private String valueTL ;
    private String valueTY ;

    public Integer getGeneId() {
        return geneId;
    }

    public void setGeneId(Integer geneId) {
        this.geneId = geneId;
    }

    public String getValueNL() {
        return valueNL;
    }

    public void setValueNL(String valueNL) {
        this.valueNL = valueNL;
    }

    public String getValueNY() {
        return valueNY;
    }

    public void setValueNY(String valueNY) {
        this.valueNY = valueNY;
    }

    public String getValueTL() {
        return valueTL;
    }

    public void setValueTL(String valueTL) {
        this.valueTL = valueTL;
    }

    public String getValueTY() {
        return valueTY;
    }

    public void setValueTY(String valueTY) {
        this.valueTY = valueTY;
    }

    @Override
    public String toString() {
        return "AccC{" +
                "geneId=" + geneId +
                ", valueNL='" + valueNL + '\'' +
                ", valueNY='" + valueNY + '\'' +
                ", valueTL='" + valueTL + '\'' +
                ", valueTY='" + valueTY + '\'' +
                '}';
    }
}
