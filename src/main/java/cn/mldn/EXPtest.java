package cn.mldn;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.util.reservesDecimal;
import cn.mldn.vo.AccC;
import com.jmatio.io.MatFileReader;
import org.apache.log4j.Logger;

import static cn.mldn.util.readMat.getValue;

public class EXPtest {
    public static void main(String[] args) throws Exception {
        MatFileReader matFileReader = new MatFileReader("/Users/BJH/Desktop/mat/expmat/exptcgaUVM.mat");
        /*********************************************************/
        double[][] expns = getValue(matFileReader, "expn");
        double[][] expts = getValue(matFileReader, "expt");
        for(int i = 0;i<expts.length;i++){
            String stringNL = "";
            String stringNY = "";
            String stringTL = "";
            String stringTY = "";
            if(expns.length==0){
                stringNL = "";
                stringNY = "";
            }else {
                for(int j=0;j<expns[i].length;j++){
                    stringNL=stringNL + reservesDecimal.getValue(expns[i][j],4)+" ";
                    stringNY=stringNY + reservesDecimal.getValue(Math.pow(2,expns[i][j]),4)+" ";
                }
            }
            stringNL=stringNL.trim();
            stringNY=stringNY.trim();
            for(int j=0;j<expts[i].length;j++){
                stringTL=stringTL+reservesDecimal.getValue(expts[i][j],4)+" ";
                stringTY=stringTY+ reservesDecimal.getValue(Math.pow(2, expts[i][j]),4)+" ";
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
