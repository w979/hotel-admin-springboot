package com.sevenhome.dao;

import static com.sevenhome.dao.RoomGoodsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.RoomGoods;
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
public interface RoomGoodsDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, roomgoodsName, roomgoodsPrice, goodstype);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<RoomGoods> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RoomGoodsResult")
    Optional<RoomGoods> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RoomGoodsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="roomgoods_name", property="roomgoodsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="roomgoods_price", property="roomgoodsPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="goodstype", property="goodstype", jdbcType=JdbcType.VARCHAR)
    })
    List<RoomGoods> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, roomGoods, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, roomGoods, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RoomGoods record) {
        return MyBatis3Utils.insert(this::insert, record, roomGoods, c ->
            c.map(roomgoodsName).toProperty("roomgoodsName")
            .map(roomgoodsPrice).toProperty("roomgoodsPrice")
            .map(goodstype).toProperty("goodstype")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RoomGoods record) {
        return MyBatis3Utils.insert(this::insert, record, roomGoods, c ->
            c.map(roomgoodsName).toPropertyWhenPresent("roomgoodsName", record::getRoomgoodsName)
            .map(roomgoodsPrice).toPropertyWhenPresent("roomgoodsPrice", record::getRoomgoodsPrice)
            .map(goodstype).toPropertyWhenPresent("goodstype", record::getGoodstype)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RoomGoods> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, roomGoods, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RoomGoods> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, roomGoods, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RoomGoods> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, roomGoods, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RoomGoods> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, roomGoods, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RoomGoods record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomgoodsName).equalTo(record::getRoomgoodsName)
                .set(roomgoodsPrice).equalTo(record::getRoomgoodsPrice)
                .set(goodstype).equalTo(record::getGoodstype);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RoomGoods record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomgoodsName).equalToWhenPresent(record::getRoomgoodsName)
                .set(roomgoodsPrice).equalToWhenPresent(record::getRoomgoodsPrice)
                .set(goodstype).equalToWhenPresent(record::getGoodstype);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RoomGoods record) {
        return update(c ->
            c.set(roomgoodsName).equalTo(record::getRoomgoodsName)
            .set(roomgoodsPrice).equalTo(record::getRoomgoodsPrice)
            .set(goodstype).equalTo(record::getGoodstype)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RoomGoods record) {
        return update(c ->
            c.set(roomgoodsName).equalToWhenPresent(record::getRoomgoodsName)
            .set(roomgoodsPrice).equalToWhenPresent(record::getRoomgoodsPrice)
            .set(goodstype).equalToWhenPresent(record::getGoodstype)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * 根据id查询房间商品信息
     * wry
     */
    @Select("select *from roomgoods where id=#{roomgoodsId}")
    RoomGoods getRoomGoodsById(Integer roomgoodsId);


}