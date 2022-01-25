package com.sevenhome.dao;

import static com.sevenhome.dao.RoomStatusDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.Room;
import com.sevenhome.bean.po.RoomStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import com.sevenhome.bean.po.RoomType;
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
public interface RoomStatusDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, roomId, roomstatus, roomstatusDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<RoomStatus> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RoomStatusResult")
    Optional<RoomStatus> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RoomStatusResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.INTEGER),
        @Result(column="roomstatus", property="roomstatus", jdbcType=JdbcType.INTEGER),
        @Result(column="roomstatus_date", property="roomstatusDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RoomStatus> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, roomStatus, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, roomStatus, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RoomStatus record) {
        return MyBatis3Utils.insert(this::insert, record, roomStatus, c ->
            c.map(roomId).toProperty("roomId")
            .map(roomstatus).toProperty("roomstatus")
            .map(roomstatusDate).toProperty("roomstatusDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RoomStatus record) {
        return MyBatis3Utils.insert(this::insert, record, roomStatus, c ->
            c.map(roomId).toPropertyWhenPresent("roomId", record::getRoomId)
            .map(roomstatus).toPropertyWhenPresent("roomstatus", record::getRoomstatus)
            .map(roomstatusDate).toPropertyWhenPresent("roomstatusDate", record::getRoomstatusDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RoomStatus> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, roomStatus, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RoomStatus> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, roomStatus, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RoomStatus> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, roomStatus, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RoomStatus> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, roomStatus, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RoomStatus record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomId).equalTo(record::getRoomId)
                .set(roomstatus).equalTo(record::getRoomstatus)
                .set(roomstatusDate).equalTo(record::getRoomstatusDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RoomStatus record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomId).equalToWhenPresent(record::getRoomId)
                .set(roomstatus).equalToWhenPresent(record::getRoomstatus)
                .set(roomstatusDate).equalToWhenPresent(record::getRoomstatusDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RoomStatus record) {
        return update(c ->
            c.set(roomId).equalTo(record::getRoomId)
            .set(roomstatus).equalTo(record::getRoomstatus)
            .set(roomstatusDate).equalTo(record::getRoomstatusDate)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RoomStatus record) {
        return update(c ->
            c.set(roomId).equalToWhenPresent(record::getRoomId)
            .set(roomstatus).equalToWhenPresent(record::getRoomstatus)
            .set(roomstatusDate).equalToWhenPresent(record::getRoomstatusDate)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int delRoomStatusByDateAndRoomId(Date updateLeaveTime, Integer roomId) {
        UpdateStatementProvider render = SqlBuilder.update(roomStatus)
                .set(RoomStatusDynamicSqlSupport.roomstatus).equalTo(0)
                .where(RoomStatusDynamicSqlSupport.roomId, isEqualTo(roomId))
                .and(roomstatusDate, isGreaterThanOrEqualTo(updateLeaveTime))
                .build().render(RenderingStrategies.MYBATIS3);
        int update = this.update(render);
        return update;
    }

    default int delRoomStatusByNewLeaveDateAndOldLeaveDate(Date newLeaveDate, Date oldLeaveDate, Integer roomId){
        UpdateStatementProvider render = SqlBuilder.update(roomStatus)
                .set(RoomStatusDynamicSqlSupport.roomstatus).equalTo(0).where(roomstatusDate, isGreaterThanOrEqualTo(newLeaveDate))
                .and(roomstatusDate, isLessThan(oldLeaveDate)).and(roomStatus.roomId,isEqualTo(roomId))
                .build().render(RenderingStrategies.MYBATIS3);

        int delete = this.update(render);
        return delete;
    }

    @Select("SELECT * FROM `roomstatus` where room_id = #{id}")
    Optional<RoomStatus> selectByRoomStatus(SelectStatementProvider selectStatement);

    //根据订房与退房时间查询房态信息
    @Select("select room_id from `roomstatus` where roomstatus = 0 and roomstatus_date between #{inTime} and #{leaveTime}")
    List<RoomStatus> getRoomStatusByTime(Date inTime,Date leaveTime);

    @Select("SELECT * FROM `roomstatus` where roomstatus = 0 and room_id = #{roomId} and roomstatus_date between #{startTime} and #{endTime}")
    List<RoomStatus> findRoomStatus(Integer roomId, String startTime, String endTime);

    /**
     * 批量修改房态表状态
     * @param ids
     * @return
     */
    int updateRoomStatus(List<Integer> ids);
}