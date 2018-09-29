package cn.mldn.util;

public class reservesDecimal {
    public static double getValue(double value,int number){
        double v = (double) Math.round(value * Math.pow(10,number)) / Math.pow(10,number);//保留几位数字
        return v;
    }
}
