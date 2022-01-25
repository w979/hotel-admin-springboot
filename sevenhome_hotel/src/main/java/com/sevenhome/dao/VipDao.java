package com.sevenhome.dao;

import static com.sevenhome.dao.SubscribeDynamicSqlSupport.subscribe;
import static com.sevenhome.dao.UserOnlineDynamicSqlSupport.id;
import static com.sevenhome.dao.UserOnlineDynamicSqlSupport.userOnline;
import static com.sevenhome.dao.VipDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.Subscribe;
import com.sevenhome.bean.po.UserOnline;
import com.sevenhome.bean.po.Vip;

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
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface VipDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, vipNo, vipStatus, vipRemark, viptypeId, vipStarttime, vipEndtime, useronlineId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.id", before = false, resultType = Integer.class)
    int insert(InsertStatementProvider<Vip> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("VipResult")
    Optional<Vip> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "VipResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "vip_no", property = "vipNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "vip_status", property = "vipStatus", jdbcType = JdbcType.VARCHAR),
            @Result(column = "vip_remark", property = "vipRemark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "viptype_id", property = "viptypeId", jdbcType = JdbcType.INTEGER),
            @Result(column = "vip_starttime", property = "vipStarttime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "vip_endtime", property = "vipEndtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "useronline_id", property = "useronlineId", jdbcType = JdbcType.INTEGER)
    })
    List<Vip> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, vip, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, vip, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Vip record) {
        return MyBatis3Utils.insert(this::insert, record, vip, c ->
                c.map(vipNo).toProperty("vipNo")
                        .map(vipStatus).toProperty("vipStatus")
                        .map(vipRemark).toProperty("vipRemark")
                        .map(viptypeId).toProperty("viptypeId")
                        .map(vipStarttime).toProperty("vipStarttime")
                        .map(vipEndtime).toProperty("vipEndtime")
                        .map(useronlineId).toProperty("useronlineId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Vip record) {
        return MyBatis3Utils.insert(this::insert, record, vip, c ->
                c.map(vipNo).toPropertyWhenPresent("vipNo", record::getVipNo)
                        .map(vipStatus).toPropertyWhenPresent("vipStatus", record::getVipStatus)
                        .map(vipRemark).toPropertyWhenPresent("vipRemark", record::getVipRemark)
                        .map(viptypeId).toPropertyWhenPresent("viptypeId", record::getViptypeId)
                        .map(vipStarttime).toPropertyWhenPresent("vipStarttime", record::getVipStarttime)
                        .map(vipEndtime).toPropertyWhenPresent("vipEndtime", record::getVipEndtime)
                        .map(useronlineId).toPropertyWhenPresent("useronlineId", record::getUseronlineId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Vip> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, vip, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Vip> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, vip, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Vip> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, vip, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Vip> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, vip, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Vip record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(vipNo).equalTo(record::getVipNo)
                .set(vipStatus).equalTo(record::getVipStatus)
                .set(vipRemark).equalTo(record::getVipRemark)
                .set(viptypeId).equalTo(record::getViptypeId)
                .set(vipStarttime).equalTo(record::getVipStarttime)
                .set(vipEndtime).equalTo(record::getVipEndtime)
                .set(useronlineId).equalTo(record::getUseronlineId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Vip record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(vipNo).equalToWhenPresent(record::getVipNo)
                .set(vipStatus).equalToWhenPresent(record::getVipStatus)
                .set(vipRemark).equalToWhenPresent(record::getVipRemark)
                .set(viptypeId).equalToWhenPresent(record::getViptypeId)
                .set(vipStarttime).equalToWhenPresent(record::getVipStarttime)
                .set(vipEndtime).equalToWhenPresent(record::getVipEndtime)
                .set(useronlineId).equalToWhenPresent(record::getUseronlineId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Vip record) {
        return update(c ->
                c.set(vipNo).equalTo(record::getVipNo)
                        .set(vipStatus).equalTo(record::getVipStatus)
                        .set(vipRemark).equalTo(record::getVipRemark)
                        .set(viptypeId).equalTo(record::getViptypeId)
                        .set(vipStarttime).equalTo(record::getVipStarttime)
                        .set(vipEndtime).equalTo(record::getVipEndtime)
                        .set(useronlineId).equalTo(record::getUseronlineId)
                        .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Vip record) {
        return update(c ->
                c.set(vipNo).equalToWhenPresent(record::getVipNo)
                        .set(vipStatus).equalToWhenPresent(record::getVipStatus)
                        .set(vipRemark).equalToWhenPresent(record::getVipRemark)
                        .set(viptypeId).equalToWhenPresent(record::getViptypeId)
                        .set(vipStarttime).equalToWhenPresent(record::getVipStarttime)
                        .set(vipEndtime).equalToWhenPresent(record::getVipEndtime)
                        .set(useronlineId).equalToWhenPresent(record::getUseronlineId)
                        .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * 根据手机号查询该用户vip信息
     *
     * @param useronlinePhone
     * @return
     */
    @Select("select * from vip v left join useronline u on v.useronline_id = u.id where u.useronline_phone = #{useronlinePhone} ")
    @ResultMap("vip_viptype")
    Vip getVip(String useronlinePhone);

    /**
     * 通过用户id获得VIP信息
     *
     * @param userId
     * @return
     */
    default Vip getVipByUserId(Integer userId) {
        SelectStatementProvider provider = SqlBuilder.select(VipDao.selectList)
                .from(vip)
                .where(vip.useronlineId, isEqualTo(userId))
                .build().render(RenderingStrategies.MYBATIS3);
        List<Vip> vipList = this.selectMany(provider);
        if (vipList.size() > 0) {
            return vipList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 显示会员列表信息
     *
     * @param selectStatement
     * @return
     */
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("vip_useronline")
    List<Vip> selectViplist(SelectStatementProvider selectStatement);


    default List<Vip> selectVipListByQuery(Integer viptypeId, String vipStatus, String phone, String username, String idCard) {
        if ("".equals(viptypeId)) {
            viptypeId = null;
        }
        if ("".equals(vipStatus)) {
            vipStatus = null;
        }

        if (phone != null && !"".equals(phone)) {
            phone = "%" + phone + "%";
        } else {
            phone = null;
        }
        if (username != null && !"".equals(username)) {
            username = "%" + username + "%";
        } else {
            username = null;
        }
        if (idCard != null && !"".equals(idCard)) {
            idCard = "%" + idCard + "%";
        } else {
            idCard = null;
        }

        SelectStatementProvider provider = SqlBuilder.select(VipDao.selectList)
                .from(vip)
                .leftJoin(UserOnlineDynamicSqlSupport.userOnline)
                .on(useronlineId, equalTo(UserOnlineDynamicSqlSupport.id))
                .where(vip.viptypeId, isEqualToWhenPresent(viptypeId))
                .and(vip.vipStatus, isEqualToWhenPresent(vipStatus))
                .and(UserOnlineDynamicSqlSupport.useronlinePhone, isLikeWhenPresent(phone))
                .and(UserOnlineDynamicSqlSupport.username, isLikeWhenPresent(username))
                .and(UserOnlineDynamicSqlSupport.useronlineIdcard, isLikeWhenPresent(idCard))
                .build().render(RenderingStrategies.MYBATIS3);
        return this.selectViplist(provider);
    }

    /**
     * 通过id查询VIP信息
     *
     * @param selectStatement
     * @return
     */
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("vip_useronline_viptype")
    public Vip selectVip(SelectStatementProvider selectStatement);

    default Vip selectVipById(Integer id) {
        SelectStatementProvider provider = SqlBuilder.select(VipDao.selectList)
                .from(vip)
                .where(vip.useronlineId, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return this.selectVip(provider);
    }

    /**
     * 冻结
     * @param id
     * @return
     */
    default int freezeVip(Integer id){
        UpdateStatementProvider provider = SqlBuilder.update(vip)
                .set(vip.vipStatus)
                .equalTo("2")
                .where(vip.useronlineId, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return this.update(provider);
    }

    /**
     * 激活
     * @param id
     * @return
     */
    default int activateVip(Integer id){
        UpdateStatementProvider provider = SqlBuilder.update(vip)
                .set(vip.vipStatus)
                .equalTo("1")
                .where(vip.useronlineId, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return this.update(provider);
    }


    /**
     * 根据id查询vip信息
     * @param id
     * @return
     */
    @Select("select * from vip where id=#{id}")
    @ResultMap("vip_viptype")
    Vip getVipById(@Param("id") Integer id);

    /**
     * 根据vipno查询id
     * @return
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    Vip getVipId(SelectStatementProvider selectStatement);

    default Vip getVipByVipNo(String vipNo){
        String finalNo=null;
        if (vipNo != null && !"".equals(vipNo)){
            finalNo=vipNo;
        }
        SelectStatementProvider provider = SqlBuilder.select(VipDao.selectList)
                .from(vip)
                .where(VipDynamicSqlSupport.vipNo,isEqualToWhenPresent(finalNo))
                .build().render(RenderingStrategies.MYBATIS3);
        return this.getVipId(provider);
    }


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("vip_useronline")
    Vip getUserTotalPay(SelectStatementProvider selectStatement);

    /**
     * 根据vipno查询user信息
     * @param vipNo
     * @return
     */
    default Vip UpdateTotalPay(String vipNo){
        SelectStatementProvider provider = SqlBuilder.select(VipDao.selectList)
                .from(vip)
                .where(VipDynamicSqlSupport.vipNo,isEqualTo(vipNo))
                .build().render(RenderingStrategies.MYBATIS3);

        return this.getUserTotalPay(provider);
    }

    @Select("select count(*) from vip")
    Integer findVips();
}