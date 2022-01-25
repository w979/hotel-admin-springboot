package com.sevenhome.dao;

import static com.sevenhome.dao.CheckInDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.CheckIn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
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
public interface CheckInDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, checkinName, checkinIdcard, ckeckinPhone, checkinIntime, checkinLeavetime, checkinDeposit, checkinRoomrate, vipId, checkinOrigin, roomId, checkinPaytype, checkinRemark, employeeId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<CheckIn> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CheckInResult")
    Optional<CheckIn> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CheckInResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="checkin_name", property="checkinName", jdbcType=JdbcType.VARCHAR),
        @Result(column="checkin_idcard", property="checkinIdcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="ckeckin_phone", property="ckeckinPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="checkin_intime", property="checkinIntime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="checkin_leavetime", property="checkinLeavetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="checkin_deposit", property="checkinDeposit", jdbcType=JdbcType.DECIMAL),
        @Result(column="checkin_roomrate", property="checkinRoomrate", jdbcType=JdbcType.DECIMAL),
        @Result(column="vip_id", property="vipId", jdbcType=JdbcType.INTEGER),
        @Result(column="checkin_origin", property="checkinOrigin", jdbcType=JdbcType.VARCHAR),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.INTEGER),
        @Result(column="checkin_paytype", property="checkinPaytype", jdbcType=JdbcType.INTEGER),
        @Result(column="checkin_remark", property="checkinRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="employee_id", property="employeeId", jdbcType=JdbcType.VARCHAR)
    })
    List<CheckIn> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, checkIn, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, checkIn, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(CheckIn record) {
        return MyBatis3Utils.insert(this::insert, record, checkIn, c ->
            c.map(checkinName).toProperty("checkinName")
            .map(checkinIdcard).toProperty("checkinIdcard")
            .map(ckeckinPhone).toProperty("ckeckinPhone")
            .map(checkinIntime).toProperty("checkinIntime")
            .map(checkinLeavetime).toProperty("checkinLeavetime")
            .map(checkinDeposit).toProperty("checkinDeposit")
            .map(checkinRoomrate).toProperty("checkinRoomrate")
            .map(vipId).toProperty("vipId")
            .map(checkinOrigin).toProperty("checkinOrigin")
            .map(roomId).toProperty("roomId")
            .map(checkinPaytype).toProperty("checkinPaytype")
            .map(checkinRemark).toProperty("checkinRemark")
            .map(employeeId).toProperty("employeeId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(CheckIn record) {
        return MyBatis3Utils.insert(this::insert, record, checkIn, c ->
            c.map(checkinName).toPropertyWhenPresent("checkinName", record::getCheckinName)
            .map(checkinIdcard).toPropertyWhenPresent("checkinIdcard", record::getCheckinIdcard)
            .map(ckeckinPhone).toPropertyWhenPresent("ckeckinPhone", record::getCkeckinPhone)
            .map(checkinIntime).toPropertyWhenPresent("checkinIntime", record::getCheckinIntime)
            .map(checkinLeavetime).toPropertyWhenPresent("checkinLeavetime", record::getCheckinLeavetime)
            .map(checkinDeposit).toPropertyWhenPresent("checkinDeposit", record::getCheckinDeposit)
            .map(checkinRoomrate).toPropertyWhenPresent("checkinRoomrate", record::getCheckinRoomrate)
            .map(vipId).toPropertyWhenPresent("vipId", record::getVipId)
            .map(checkinOrigin).toPropertyWhenPresent("checkinOrigin", record::getCheckinOrigin)
            .map(roomId).toPropertyWhenPresent("roomId", record::getRoomId)
            .map(checkinPaytype).toPropertyWhenPresent("checkinPaytype", record::getCheckinPaytype)
            .map(checkinRemark).toPropertyWhenPresent("checkinRemark", record::getCheckinRemark)
            .map(employeeId).toPropertyWhenPresent("employeeId", record::getEmployeeId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CheckIn> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, checkIn, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CheckIn> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, checkIn, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CheckIn> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, checkIn, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CheckIn> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, checkIn, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(CheckIn record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(checkinName).equalTo(record::getCheckinName)
                .set(checkinIdcard).equalTo(record::getCheckinIdcard)
                .set(ckeckinPhone).equalTo(record::getCkeckinPhone)
                .set(checkinIntime).equalTo(record::getCheckinIntime)
                .set(checkinLeavetime).equalTo(record::getCheckinLeavetime)
                .set(checkinDeposit).equalTo(record::getCheckinDeposit)
                .set(checkinRoomrate).equalTo(record::getCheckinRoomrate)
                .set(vipId).equalTo(record::getVipId)
                .set(checkinOrigin).equalTo(record::getCheckinOrigin)
                .set(roomId).equalTo(record::getRoomId)
                .set(checkinPaytype).equalTo(record::getCheckinPaytype)
                .set(checkinRemark).equalTo(record::getCheckinRemark)
                .set(employeeId).equalTo(record::getEmployeeId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CheckIn record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(checkinName).equalToWhenPresent(record::getCheckinName)
                .set(checkinIdcard).equalToWhenPresent(record::getCheckinIdcard)
                .set(ckeckinPhone).equalToWhenPresent(record::getCkeckinPhone)
                .set(checkinIntime).equalToWhenPresent(record::getCheckinIntime)
                .set(checkinLeavetime).equalToWhenPresent(record::getCheckinLeavetime)
                .set(checkinDeposit).equalToWhenPresent(record::getCheckinDeposit)
                .set(checkinRoomrate).equalToWhenPresent(record::getCheckinRoomrate)
                .set(vipId).equalToWhenPresent(record::getVipId)
                .set(checkinOrigin).equalToWhenPresent(record::getCheckinOrigin)
                .set(roomId).equalToWhenPresent(record::getRoomId)
                .set(checkinPaytype).equalToWhenPresent(record::getCheckinPaytype)
                .set(checkinRemark).equalToWhenPresent(record::getCheckinRemark)
                .set(employeeId).equalToWhenPresent(record::getEmployeeId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(CheckIn record) {
        return update(c ->
            c.set(checkinName).equalTo(record::getCheckinName)
            .set(checkinIdcard).equalTo(record::getCheckinIdcard)
            .set(ckeckinPhone).equalTo(record::getCkeckinPhone)
            .set(checkinIntime).equalTo(record::getCheckinIntime)
            .set(checkinLeavetime).equalTo(record::getCheckinLeavetime)
            .set(checkinDeposit).equalTo(record::getCheckinDeposit)
            .set(checkinRoomrate).equalTo(record::getCheckinRoomrate)
            .set(vipId).equalTo(record::getVipId)
            .set(checkinOrigin).equalTo(record::getCheckinOrigin)
            .set(roomId).equalTo(record::getRoomId)
            .set(checkinPaytype).equalTo(record::getCheckinPaytype)
            .set(checkinRemark).equalTo(record::getCheckinRemark)
            .set(employeeId).equalTo(record::getEmployeeId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(CheckIn record) {
        return update(c ->
            c.set(checkinName).equalToWhenPresent(record::getCheckinName)
            .set(checkinIdcard).equalToWhenPresent(record::getCheckinIdcard)
            .set(ckeckinPhone).equalToWhenPresent(record::getCkeckinPhone)
            .set(checkinIntime).equalToWhenPresent(record::getCheckinIntime)
            .set(checkinLeavetime).equalToWhenPresent(record::getCheckinLeavetime)
            .set(checkinDeposit).equalToWhenPresent(record::getCheckinDeposit)
            .set(checkinRoomrate).equalToWhenPresent(record::getCheckinRoomrate)
            .set(vipId).equalToWhenPresent(record::getVipId)
            .set(checkinOrigin).equalToWhenPresent(record::getCheckinOrigin)
            .set(roomId).equalToWhenPresent(record::getRoomId)
            .set(checkinPaytype).equalToWhenPresent(record::getCheckinPaytype)
            .set(checkinRemark).equalToWhenPresent(record::getCheckinRemark)
            .set(employeeId).equalToWhenPresent(record::getEmployeeId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Select("select * from check_in where id = #{id}")
    CheckIn getCheckInById(@Param("id")Integer id);

    default int updateLeaveTime(Integer idVal, Date leaveTime, BigDecimal money){
        UpdateStatementProvider render = SqlBuilder.update(checkIn)
                .set(checkinRoomrate).equalTo(money)
                .set(checkinLeavetime).equalTo(leaveTime).where(id, isEqualTo(idVal))
                .build().render(RenderingStrategies.MYBATIS3);
        int update = this.update(render);
        return update;
    }

    @Select("select id from check_in where checkin_leavetime = #{leaveTime}")
    List<Integer> getCheckinIdByLeaveTime(Date leaveTime);
    


    default int updatePayType(Integer payType,Integer id){
        UpdateStatementProvider provider = SqlBuilder.update(checkIn).set(checkinPaytype).equalTo(payType).where(CheckInDynamicSqlSupport.id,isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        int update = this.update(provider);
        return update;
    }
}