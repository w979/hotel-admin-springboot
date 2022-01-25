package com.sevenhome.dao;

import static com.sevenhome.dao.DepositDetailDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.DepositDetail;
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
public interface DepositDetailDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, roomgoodsId, depositdetailNum, depositId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<DepositDetail> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DepositDetailResult")
    Optional<DepositDetail> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DepositDetailResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="roomgoods_id", property="roomgoodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="depositdetail_num", property="depositdetailNum", jdbcType=JdbcType.INTEGER),
        @Result(column="deposit_id", property="depositId", jdbcType=JdbcType.INTEGER)
    })
    List<DepositDetail> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, depositDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, depositDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(DepositDetail record) {
        return MyBatis3Utils.insert(this::insert, record, depositDetail, c ->
            c.map(roomgoodsId).toProperty("roomgoodsId")
            .map(depositdetailNum).toProperty("depositdetailNum")
            .map(depositId).toProperty("depositId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(DepositDetail record) {
        return MyBatis3Utils.insert(this::insert, record, depositDetail, c ->
            c.map(roomgoodsId).toPropertyWhenPresent("roomgoodsId", record::getRoomgoodsId)
            .map(depositdetailNum).toPropertyWhenPresent("depositdetailNum", record::getDepositdetailNum)
            .map(depositId).toPropertyWhenPresent("depositId", record::getDepositId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DepositDetail> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, depositDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DepositDetail> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, depositDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DepositDetail> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, depositDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DepositDetail> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, depositDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(DepositDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomgoodsId).equalTo(record::getRoomgoodsId)
                .set(depositdetailNum).equalTo(record::getDepositdetailNum)
                .set(depositId).equalTo(record::getDepositId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DepositDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomgoodsId).equalToWhenPresent(record::getRoomgoodsId)
                .set(depositdetailNum).equalToWhenPresent(record::getDepositdetailNum)
                .set(depositId).equalToWhenPresent(record::getDepositId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(DepositDetail record) {
        return update(c ->
            c.set(roomgoodsId).equalTo(record::getRoomgoodsId)
            .set(depositdetailNum).equalTo(record::getDepositdetailNum)
            .set(depositId).equalTo(record::getDepositId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(DepositDetail record) {
        return update(c ->
            c.set(roomgoodsId).equalToWhenPresent(record::getRoomgoodsId)
            .set(depositdetailNum).equalToWhenPresent(record::getDepositdetailNum)
            .set(depositId).equalToWhenPresent(record::getDepositId)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * 根据押金id查询押金表明细
      *@author wry
      * @date 2022/1/18 10:32
     */
    @ResultMap("depositdetail_goods")
    @Select("select *from depositdetail dd left join roomgoods rg on dd.roomgoods_id=rg.id where deposit_id=#{depositId}")
    List<DepositDetail> queryAllDepositDetail(Integer depositId);

}