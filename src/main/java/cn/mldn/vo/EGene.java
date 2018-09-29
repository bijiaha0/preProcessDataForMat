package cn.mldn.vo;

import java.io.Serializable;

public class EGene implements Serializable {
    private int id;
    private String geneName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    @Override
    public String toString() {
        return "EGene{" +
                "id=" + id +
                ", geneName='" + geneName + '\'' +
                '}';
    }
}
