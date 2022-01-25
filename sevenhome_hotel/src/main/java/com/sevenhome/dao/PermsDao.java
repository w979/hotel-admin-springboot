package com.sevenhome.dao;

import static com.sevenhome.dao.PermsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.Perms;
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
public interface PermsDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, permName, perCode, link, parentid, permType, permStatus, icon);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Perms> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PermsResult")
    Optional<Perms> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PermsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="perm_name", property="permName", jdbcType=JdbcType.VARCHAR),
        @Result(column="per_code", property="perCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="perm_type", property="permType", jdbcType=JdbcType.VARCHAR),
        @Result(column="perm_status", property="permStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR)
    })
    List<Perms> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, perms, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, perms, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Perms record) {
        return MyBatis3Utils.insert(this::insert, record, perms, c ->
            c.map(permName).toProperty("permName")
            .map(perCode).toProperty("perCode")
            .map(link).toProperty("link")
            .map(parentid).toProperty("parentid")
            .map(permType).toProperty("permType")
            .map(permStatus).toProperty("permStatus")
            .map(icon).toProperty("icon")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Perms record) {
        return MyBatis3Utils.insert(this::insert, record, perms, c ->
            c.map(permName).toPropertyWhenPresent("permName", record::getPermName)
            .map(perCode).toPropertyWhenPresent("perCode", record::getPerCode)
            .map(link).toPropertyWhenPresent("link", record::getLink)
            .map(parentid).toPropertyWhenPresent("parentid", record::getParentid)
            .map(permType).toPropertyWhenPresent("permType", record::getPermType)
            .map(permStatus).toPropertyWhenPresent("permStatus", record::getPermStatus)
            .map(icon).toPropertyWhenPresent("icon", record::getIcon)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Perms> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, perms, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Perms> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, perms, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Perms> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, perms, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Perms> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, perms, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Perms record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(permName).equalTo(record::getPermName)
                .set(perCode).equalTo(record::getPerCode)
                .set(link).equalTo(record::getLink)
                .set(parentid).equalTo(record::getParentid)
                .set(permType).equalTo(record::getPermType)
                .set(permStatus).equalTo(record::getPermStatus)
                .set(icon).equalTo(record::getIcon);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Perms record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(permName).equalToWhenPresent(record::getPermName)
                .set(perCode).equalToWhenPresent(record::getPerCode)
                .set(link).equalToWhenPresent(record::getLink)
                .set(parentid).equalToWhenPresent(record::getParentid)
                .set(permType).equalToWhenPresent(record::getPermType)
                .set(permStatus).equalToWhenPresent(record::getPermStatus)
                .set(icon).equalToWhenPresent(record::getIcon);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Perms record) {
        return update(c ->
            c.set(permName).equalTo(record::getPermName)
            .set(perCode).equalTo(record::getPerCode)
            .set(link).equalTo(record::getLink)
            .set(parentid).equalTo(record::getParentid)
            .set(permType).equalTo(record::getPermType)
            .set(permStatus).equalTo(record::getPermStatus)
            .set(icon).equalTo(record::getIcon)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Perms record) {
        return update(c ->
            c.set(permName).equalToWhenPresent(record::getPermName)
            .set(perCode).equalToWhenPresent(record::getPerCode)
            .set(link).equalToWhenPresent(record::getLink)
            .set(parentid).equalToWhenPresent(record::getParentid)
            .set(permType).equalToWhenPresent(record::getPermType)
            .set(permStatus).equalToWhenPresent(record::getPermStatus)
            .set(icon).equalToWhenPresent(record::getIcon)
            .where(id, isEqualTo(record::getId))
        );
    }


    /**
     * 查询当前用户的权限
     * @param employeeId
     * @return
     */
    @Select("select p.per_code from perms p left join role_perms rp on p.id=rp.perm_id " +
        "left join role r on rp.role_id = r.id " +
        "left join role_employee re on r.id = re.role_id " +
        "where p.parentid is not null and re.employee_id=#{employeeId}")
    List<String> selectPermsByEmployeeId(Integer employeeId);
}