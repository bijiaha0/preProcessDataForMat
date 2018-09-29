package cn.mldn.util;
import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLCell;
import com.jmatio.types.MLChar;
import com.jmatio.types.MLDouble;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class readMat {
    private static Logger log = Logger.getLogger(readMat.class) ;
    public static void main(String[] args) throws IOException {

        MatFileReader matFileReader = new MatFileReader("/Users/BJH/Desktop/mat/expmat/exptcgaACC.mat");
        String s = getSampleID(matFileReader, "pIDt");
        log.info(s);
        /*********************************************************/
        double[][] expts = getValue(matFileReader, "expt");
        for(int i = 0;i<expts.length;i++){
        double[] one = expts[i];
        log.info(Arrays.toString(one));
        }
        /*********************************************************/
        String geneID= getSampleID(matFileReader, "geneID");
        log.info(geneID);
    }
    //得到value
    public static double[][] getValue(MatFileReader matFileReader,String expt){
        double[][] mlArrayDouble = ((MLDouble) matFileReader.getMLArray(expt)).getArray();
        //for(int i = 0;i<mlArrayDouble.length;i++){
        //    double[] one = mlArrayDouble[i];
        //    System.out.println(Arrays.toString(one));
        //}
        return mlArrayDouble;
    }
    //得到样本ID（肿瘤和正常样本）
    public static String getSampleID(MatFileReader matFileReader, String Pid){
        String s="";
        ArrayList<MLArray> pIDt = ((MLCell) matFileReader.getMLArray(Pid)).cells();
        for(int k=0;k<pIDt.size();k++){
            MLChar mlChar = (MLChar) pIDt.get(k);
            char[] chars = new char[mlChar.getN()];
            for(int i=0;i<mlChar.getM();i++){
                for(int j=0;j<mlChar.getN();j++){
                    chars[j]=mlChar.getChar(i,j);
                }
            }
            s =s + (new String(chars)+" ");
        }
        return s.trim();
    }
    //得到geneID
    public static String getGeneID(MatFileReader matFileReader, String geneID){
        String s="";
        ArrayList<MLArray> pIDt = ((MLCell) matFileReader.getMLArray(geneID)).cells();
        for(int k=0;k<pIDt.size();k++){
            MLChar mlChar = (MLChar) pIDt.get(k);
            char[] chars = new char[mlChar.getN()];
            for(int i=0;i<mlChar.getM();i++){
                for(int j=0;j<mlChar.getN();j++){
                    chars[j]=mlChar.getChar(i,j);
                }
            }
            s =s + (new String(chars)+" ");
        }
        return s.trim();
    }
}
