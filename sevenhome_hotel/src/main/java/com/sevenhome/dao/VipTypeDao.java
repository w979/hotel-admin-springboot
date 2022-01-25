package com.sevenhome.dao;

import static com.sevenhome.dao.VipTypeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.VipType;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SortSpecification;
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
public interface VipTypeDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, viptypeName, viptypeLevel, viptypeDiscount, viptypeStep);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<VipType> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("VipTypeResult")
    Optional<VipType> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="VipTypeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="viptype_name", property="viptypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="viptype_level", property="viptypeLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="viptype_discount", property="viptypeDiscount", jdbcType=JdbcType.VARCHAR),
        @Result(column="viptype_step", property="viptypeStep", jdbcType=JdbcType.VARCHAR)
    })
    List<VipType> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, vipType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, vipType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(VipType record) {
        return MyBatis3Utils.insert(this::insert, record, vipType, c ->
            c.map(viptypeName).toProperty("viptypeName")
            .map(viptypeLevel).toProperty("viptypeLevel")
            .map(viptypeDiscount).toProperty("viptypeDiscount")
            .map(viptypeStep).toProperty("viptypeStep")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(VipType record) {
        return MyBatis3Utils.insert(this::insert, record, vipType, c ->
            c.map(viptypeName).toPropertyWhenPresent("viptypeName", record::getViptypeName)
            .map(viptypeLevel).toPropertyWhenPresent("viptypeLevel", record::getViptypeLevel)
            .map(viptypeDiscount).toPropertyWhenPresent("viptypeDiscount", record::getViptypeDiscount)
            .map(viptypeStep).toPropertyWhenPresent("viptypeStep", record::getViptypeStep)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<VipType> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, vipType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<VipType> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, vipType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<VipType> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, vipType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<VipType> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, vipType, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(VipType record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(viptypeName).equalTo(record::getViptypeName)
                .set(viptypeLevel).equalTo(record::getViptypeLevel)
                .set(viptypeDiscount).equalTo(record::getViptypeDiscount)
                .set(viptypeStep).equalTo(record::getViptypeStep);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(VipType record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(viptypeName).equalToWhenPresent(record::getViptypeName)
                .set(viptypeLevel).equalToWhenPresent(record::getViptypeLevel)
                .set(viptypeDiscount).equalToWhenPresent(record::getViptypeDiscount)
                .set(viptypeStep).equalToWhenPresent(record::getViptypeStep);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(VipType record) {
        return update(c ->
            c.set(viptypeName).equalTo(record::getViptypeName)
            .set(viptypeLevel).equalTo(record::getViptypeLevel)
            .set(viptypeDiscount).equalTo(record::getViptypeDiscount)
            .set(viptypeStep).equalTo(record::getViptypeStep)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(VipType record) {
        return update(c ->
            c.set(viptypeName).equalToWhenPresent(record::getViptypeName)
            .set(viptypeLevel).equalToWhenPresent(record::getViptypeLevel)
            .set(viptypeDiscount).equalToWhenPresent(record::getViptypeDiscount)
            .set(viptypeStep).equalToWhenPresent(record::getViptypeStep)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * 显示会员类型列表
     * @return
     */
    default List<VipType> selectVipTypList(){
        SelectStatementProvider provider = SqlBuilder.select(VipTypeDao.selectList)
                .from(vipType)
                .build().render(RenderingStrategies.MYBATIS3);
        return this.selectMany(provider);
    }


    /**
     * 通过id获取会员类型
     * @param id
     * @return
     */
    @Select("select * from viptype where id = #{id}")
    VipType getVipType(Integer id);
}