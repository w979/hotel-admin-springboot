package com.sevenhome;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class ApplicationAppTest {

    @Test
    public void demo() {
        BigDecimal orderTotalprice = BigDecimal.valueOf(398.00);
        System.out.println(orderTotalprice);
        System.out.println("11111111111111111111");
        //单日价格
        BigDecimal oneDayPrice = orderTotalprice.divide(BigDecimal.valueOf(9), BigDecimal.ROUND_HALF_UP).setScale(1) ;
        System.out.println("2222222222222222222");
    }
}