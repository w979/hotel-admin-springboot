package com.sevenhome.service;

import com.sevenhome.bean.fo.CheckOutFo;

import java.util.HashMap;
import java.util.List;

public interface ICheckOutService {
    List<String> getCancelSectionDates(CheckOutFo checkOutFo);

    HashMap<String, String> cancelSection(CheckOutFo checkOutFo);

    HashMap<String, Object> checkOutRightNow(CheckOutFo checkOutFo);
}
