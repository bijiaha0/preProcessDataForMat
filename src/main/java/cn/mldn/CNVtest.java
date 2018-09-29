package cn.mldn;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.util.reservesDecimal;
import cn.mldn.vo.AccC;
import com.jmatio.io.MatFileReader;
import org.apache.log4j.Logger;

import java.io.IOException;

import static cn.mldn.util.readMat.getValue;

public class CNVtest {
    private static Logger log = Logger.getLogger(CNVtest.class);
    public static void main(String[] args) throws Exception {
        MatFileReader matFileReader = new MatFileReader("/Users/BJH/Desktop/mat/cnvmat/cnvtcgaACC.mat");
        /*********************************************************/
        double[][] cnvns = getValue(matFileReader, "cnvn");
        double[][] cnvts = getValue(matFileReader, "cnvt");
        for(int i = 0;i<cnvns.length;i++){
            String stringNL = "";
            String stringNY = "";
            String stringTL = "";
            String stringTY = "";
            for(int j=0;j<cnvns[i].length;j++){
                stringNL=stringNL + reservesDecimal.getValue(cnvns[i][j],4)+" ";
                stringNY=stringNY + reservesDecimal.getValue(Math.pow(2,cnvns[i][j]+1),4)+" ";
            }
            stringNL=stringNL.trim();
            stringNY=stringNY.trim();
            for(int j=0;j<cnvts[i].length;j++){
                stringTL=stringTL + reservesDecimal.getValue(cnvts[i][j],4)+" ";
                stringTY=stringTY + reservesDecimal.getValue(Math.pow(2, cnvts[i][j] + 1),4)+" ";
            }
            stringTL=stringTL.trim();
            stringTY=stringTY.trim();
            AccC cancer=new AccC();
            System.out.println(stringNL);
            System.out.println(stringNY);
            System.out.println(stringTL);
            System.out.println(stringTY);
            cancer.setValueNL(stringNL);
            cancer.setValueNY(stringNY);
            cancer.setValueTL(stringTL);
            cancer.setValueTY(stringTY);
            MyBatisSessionFactory.getSession().insert("cn.mldn.vo.mapping.AccCNS.doCreate", cancer);
            MyBatisSessionFactory.getSession().commit();
            MyBatisSessionFactory.close();
        }
    }
}
