package com.sevenhome.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class HotelDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Hotel hotel = new Hotel();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = hotel.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> hotelName = hotel.hotelName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> area = hotel.area;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> detailAddress = hotel.detailAddress;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> longitude = hotel.longitude;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> latitude = hotel.latitude;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> hotelPhone = hotel.hotelPhone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> hotelDescription = hotel.hotelDescription;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> homepageImg = hotel.homepageImg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> detailImg = hotel.detailImg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> hotelFacility = hotel.hotelFacility;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> hotelStatus = hotel.hotelStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Hotel extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> hotelName = column("hotel_name", JDBCType.VARCHAR);

        public final SqlColumn<String> area = column("area", JDBCType.VARCHAR);

        public final SqlColumn<String> detailAddress = column("detail_address", JDBCType.VARCHAR);

        public final SqlColumn<String> longitude = column("longitude", JDBCType.VARCHAR);

        public final SqlColumn<String> latitude = column("latitude", JDBCType.VARCHAR);

        public final SqlColumn<String> hotelPhone = column("hotel_phone", JDBCType.VARCHAR);

        public final SqlColumn<String> hotelDescription = column("hotel_description", JDBCType.VARCHAR);

        public final SqlColumn<String> homepageImg = column("homepage_img", JDBCType.VARCHAR);

        public final SqlColumn<String> detailImg = column("detail_img", JDBCType.VARCHAR);

        public final SqlColumn<String> hotelFacility = column("hotel_facility", JDBCType.VARCHAR);

        public final SqlColumn<String> hotelStatus = column("hotel_status", JDBCType.VARCHAR);

        public Hotel() {
            super("hotel");
        }
    }
}