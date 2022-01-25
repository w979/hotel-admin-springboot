package com.sevenhome.utils;

import java.util.Calendar;
import java.util.Random;

/**
 * 生成随机码
 */
public class RandomCode {

    /**
     * 生成10位订单编号
     * @return
     */
    public static String getNo(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String yearStr = String.valueOf(year);
        // 随机产生6位激活码
        String[] codes = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String code = yearStr;
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            String str = codes[random.nextInt(codes.length)];
            code += str;
        }
        return code;
    }

    /**
     * 生成15位vip编号
     * @return
     */
    public static String getVipNo(String phone){
        // 随机产生6位激活码
        String[] codes = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String code = "V"+phone;
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            String str = codes[random.nextInt(codes.length)];
            code += str;
        }
        return code;
    }
}
