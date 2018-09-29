package cn.mldn;
import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.EGene;
import com.jmatio.io.MatFileReader;
import static cn.mldn.util.readMat.getSampleID;
public class getGeneNameE {
    public static void main(String[] args) throws Exception {
        MatFileReader matFileReader = new MatFileReader("/Users/BJH/Desktop/mat/expmat/exptcgaACC.mat");
        String geneID= getSampleID(matFileReader, "geneID");
        String[] split = geneID.split(" ");
        for(int k =0;k < split.length;k++){
            //String s = split[k].split("\\|")[0];
            //EGene gene=new EGene();
            //System.out.println(s);
            //gene.setGeneName(s);
            EGene gene=new EGene();
            System.out.println(split[k]);
            gene.setGeneName(split[k]);
            MyBatisSessionFactory.getSession().insert("cn.mldn.vo.mapping.EGeneNS.doCreate", gene);
            MyBatisSessionFactory.getSession().commit();
            MyBatisSessionFactory.close();
        }
    }
}
