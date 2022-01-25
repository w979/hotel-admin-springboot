package com.sevenhome.dao;

import static com.sevenhome.dao.RoomTypeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.Role;
import com.sevenhome.bean.po.RoomType;
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
public interface RoomTypeDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, roomtypeName, marketPrice, onlinePrice, roomtypeStatus, roomtypeArea, bedNumber, bedType, breakfast, smoking);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<RoomType> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RoomTypeResult")
    Optional<RoomType> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RoomTypeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="roomtype_name", property="roomtypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="market_price", property="marketPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="online_price", property="onlinePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="roomtype_status", property="roomtypeStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="roomtype_area", property="roomtypeArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="bed_number", property="bedNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="bed_type", property="bedType", jdbcType=JdbcType.VARCHAR),
        @Result(column="breakfast", property="breakfast", jdbcType=JdbcType.VARCHAR),
        @Result(column="smoking", property="smoking", jdbcType=JdbcType.VARCHAR)
    })
    List<RoomType> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, roomType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, roomType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RoomType record) {
        return MyBatis3Utils.insert(this::insert, record, roomType, c ->
            c.map(roomtypeName).toProperty("roomtypeName")
            .map(marketPrice).toProperty("marketPrice")
            .map(onlinePrice).toProperty("onlinePrice")
            .map(roomtypeStatus).toProperty("roomtypeStatus")
            .map(roomtypeArea).toProperty("roomtypeArea")
            .map(bedNumber).toProperty("bedNumber")
            .map(bedType).toProperty("bedType")
            .map(breakfast).toProperty("breakfast")
            .map(smoking).toProperty("smoking")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RoomType record) {
        return MyBatis3Utils.insert(this::insert, record, roomType, c ->
            c.map(roomtypeName).toPropertyWhenPresent("roomtypeName", record::getRoomtypeName)
            .map(marketPrice).toPropertyWhenPresent("marketPrice", record::getMarketPrice)
            .map(onlinePrice).toPropertyWhenPresent("onlinePrice", record::getOnlinePrice)
            .map(roomtypeStatus).toPropertyWhenPresent("roomtypeStatus", record::getRoomtypeStatus)
            .map(roomtypeArea).toPropertyWhenPresent("roomtypeArea", record::getRoomtypeArea)
            .map(bedNumber).toPropertyWhenPresent("bedNumber", record::getBedNumber)
            .map(bedType).toPropertyWhenPresent("bedType", record::getBedType)
            .map(breakfast).toPropertyWhenPresent("breakfast", record::getBreakfast)
            .map(smoking).toPropertyWhenPresent("smoking", record::getSmoking)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RoomType> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, roomType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RoomType> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, roomType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RoomType> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, roomType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RoomType> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, roomType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RoomType record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomtypeName).equalTo(record::getRoomtypeName)
                .set(marketPrice).equalTo(record::getMarketPrice)
                .set(onlinePrice).equalTo(record::getOnlinePrice)
                .set(roomtypeStatus).equalTo(record::getRoomtypeStatus)
                .set(roomtypeArea).equalTo(record::getRoomtypeArea)
                .set(bedNumber).equalTo(record::getBedNumber)
                .set(bedType).equalTo(record::getBedType)
                .set(breakfast).equalTo(record::getBreakfast)
                .set(smoking).equalTo(record::getSmoking);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RoomType record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomtypeName).equalToWhenPresent(record::getRoomtypeName)
                .set(marketPrice).equalToWhenPresent(record::getMarketPrice)
                .set(onlinePrice).equalToWhenPresent(record::getOnlinePrice)
                .set(roomtypeStatus).equalToWhenPresent(record::getRoomtypeStatus)
                .set(roomtypeArea).equalToWhenPresent(record::getRoomtypeArea)
                .set(bedNumber).equalToWhenPresent(record::getBedNumber)
                .set(bedType).equalToWhenPresent(record::getBedType)
                .set(breakfast).equalToWhenPresent(record::getBreakfast)
                .set(smoking).equalToWhenPresent(record::getSmoking);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RoomType record) {
        return update(c ->
            c.set(roomtypeName).equalTo(record::getRoomtypeName)
            .set(marketPrice).equalTo(record::getMarketPrice)
            .set(onlinePrice).equalTo(record::getOnlinePrice)
            .set(roomtypeStatus).equalTo(record::getRoomtypeStatus)
            .set(roomtypeArea).equalTo(record::getRoomtypeArea)
            .set(bedNumber).equalTo(record::getBedNumber)
            .set(bedType).equalTo(record::getBedType)
            .set(breakfast).equalTo(record::getBreakfast)
            .set(smoking).equalTo(record::getSmoking)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RoomType record) {
        return update(c ->
            c.set(roomtypeName).equalToWhenPresent(record::getRoomtypeName)
            .set(marketPrice).equalToWhenPresent(record::getMarketPrice)
            .set(onlinePrice).equalToWhenPresent(record::getOnlinePrice)
            .set(roomtypeStatus).equalToWhenPresent(record::getRoomtypeStatus)
            .set(roomtypeArea).equalToWhenPresent(record::getRoomtypeArea)
            .set(bedNumber).equalToWhenPresent(record::getBedNumber)
            .set(bedType).equalToWhenPresent(record::getBedType)
            .set(breakfast).equalToWhenPresent(record::getBreakfast)
            .set(smoking).equalToWhenPresent(record::getSmoking)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * 根据id查询房型
     * @param id
     * @return
     */
    @Select("select * from roomtype where id=#{id}")
    RoomType getRoomType(Integer id);

    /**
     * 房间映射房间类型
     * @param selectStatement
     * @return
     */
    @Select("SELECT * FROM `roomtype` where id = #{id}")
    Optional<RoomType> selectByRoomType(SelectStatementProvider selectStatement);

    /**
     * 查询所有房型
     * @return
     */
    @Select("select * from roomtype")
    List<RoomType> getRoomTypeList();
}