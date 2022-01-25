package com.sevenhome.dao;

import static com.sevenhome.dao.HotelDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.Hotel;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface HotelDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, hotelName, area, detailAddress, longitude, latitude, hotelPhone, hotelDescription, homepageImg, detailImg, hotelFacility, hotelStatus);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Hotel> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("HotelResult")
    Optional<Hotel> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="HotelResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hotel_name", property="hotelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail_address", property="detailAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotel_phone", property="hotelPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotel_description", property="hotelDescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="homepage_img", property="homepageImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail_img", property="detailImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotel_facility", property="hotelFacility", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotel_status", property="hotelStatus", jdbcType=JdbcType.VARCHAR)
    })
    List<Hotel> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, hotel, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, hotel, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Hotel record) {
        return MyBatis3Utils.insert(this::insert, record, hotel, c ->
            c.map(hotelName).toProperty("hotelName")
            .map(area).toProperty("area")
            .map(detailAddress).toProperty("detailAddress")
            .map(longitude).toProperty("longitude")
            .map(latitude).toProperty("latitude")
            .map(hotelPhone).toProperty("hotelPhone")
            .map(hotelDescription).toProperty("hotelDescription")
            .map(homepageImg).toProperty("homepageImg")
            .map(detailImg).toProperty("detailImg")
            .map(hotelFacility).toProperty("hotelFacility")
            .map(hotelStatus).toProperty("hotelStatus")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Hotel record) {
        return MyBatis3Utils.insert(this::insert, record, hotel, c ->
            c.map(hotelName).toPropertyWhenPresent("hotelName", record::getHotelName)
            .map(area).toPropertyWhenPresent("area", record::getArea)
            .map(detailAddress).toPropertyWhenPresent("detailAddress", record::getDetailAddress)
            .map(longitude).toPropertyWhenPresent("longitude", record::getLongitude)
            .map(latitude).toPropertyWhenPresent("latitude", record::getLatitude)
            .map(hotelPhone).toPropertyWhenPresent("hotelPhone", record::getHotelPhone)
            .map(hotelDescription).toPropertyWhenPresent("hotelDescription", record::getHotelDescription)
            .map(homepageImg).toPropertyWhenPresent("homepageImg", record::getHomepageImg)
            .map(detailImg).toPropertyWhenPresent("detailImg", record::getDetailImg)
            .map(hotelFacility).toPropertyWhenPresent("hotelFacility", record::getHotelFacility)
            .map(hotelStatus).toPropertyWhenPresent("hotelStatus", record::getHotelStatus)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Hotel> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, hotel, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Hotel> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, hotel, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Hotel> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, hotel, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Hotel> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, hotel, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Hotel record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(hotelName).equalTo(record::getHotelName)
                .set(area).equalTo(record::getArea)
                .set(detailAddress).equalTo(record::getDetailAddress)
                .set(longitude).equalTo(record::getLongitude)
                .set(latitude).equalTo(record::getLatitude)
                .set(hotelPhone).equalTo(record::getHotelPhone)
                .set(hotelDescription).equalTo(record::getHotelDescription)
                .set(homepageImg).equalTo(record::getHomepageImg)
                .set(detailImg).equalTo(record::getDetailImg)
                .set(hotelFacility).equalTo(record::getHotelFacility)
                .set(hotelStatus).equalTo(record::getHotelStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Hotel record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(hotelName).equalToWhenPresent(record::getHotelName)
                .set(area).equalToWhenPresent(record::getArea)
                .set(detailAddress).equalToWhenPresent(record::getDetailAddress)
                .set(longitude).equalToWhenPresent(record::getLongitude)
                .set(latitude).equalToWhenPresent(record::getLatitude)
                .set(hotelPhone).equalToWhenPresent(record::getHotelPhone)
                .set(hotelDescription).equalToWhenPresent(record::getHotelDescription)
                .set(homepageImg).equalToWhenPresent(record::getHomepageImg)
                .set(detailImg).equalToWhenPresent(record::getDetailImg)
                .set(hotelFacility).equalToWhenPresent(record::getHotelFacility)
                .set(hotelStatus).equalToWhenPresent(record::getHotelStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Hotel record) {
        return update(c ->
            c.set(hotelName).equalTo(record::getHotelName)
            .set(area).equalTo(record::getArea)
            .set(detailAddress).equalTo(record::getDetailAddress)
            .set(longitude).equalTo(record::getLongitude)
            .set(latitude).equalTo(record::getLatitude)
            .set(hotelPhone).equalTo(record::getHotelPhone)
            .set(hotelDescription).equalTo(record::getHotelDescription)
            .set(homepageImg).equalTo(record::getHomepageImg)
            .set(detailImg).equalTo(record::getDetailImg)
            .set(hotelFacility).equalTo(record::getHotelFacility)
            .set(hotelStatus).equalTo(record::getHotelStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Hotel record) {
        return update(c ->
            c.set(hotelName).equalToWhenPresent(record::getHotelName)
            .set(area).equalToWhenPresent(record::getArea)
            .set(detailAddress).equalToWhenPresent(record::getDetailAddress)
            .set(longitude).equalToWhenPresent(record::getLongitude)
            .set(latitude).equalToWhenPresent(record::getLatitude)
            .set(hotelPhone).equalToWhenPresent(record::getHotelPhone)
            .set(hotelDescription).equalToWhenPresent(record::getHotelDescription)
            .set(homepageImg).equalToWhenPresent(record::getHomepageImg)
            .set(detailImg).equalToWhenPresent(record::getDetailImg)
            .set(hotelFacility).equalToWhenPresent(record::getHotelFacility)
            .set(hotelStatus).equalToWhenPresent(record::getHotelStatus)
            .where(id, isEqualTo(record::getId))
        );
    }


    /**
     * @author wry
     * @date 2022/1/17 14:54
     * 根据id查询指定酒店信息 wry
     */
    @Select("select *from hotel where id=#{hotelId}")
    Hotel getHotelById(Integer hotelId);
}
