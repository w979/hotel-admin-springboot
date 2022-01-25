package com.sevenhome.dao;

import static com.sevenhome.dao.OrdersDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import com.sevenhome.bean.po.Role;
import com.sevenhome.bean.po.Room;
import com.sevenhome.bean.po.Subscribe;
import com.sevenhome.bean.vo.EveryDayBusinessVo;
import com.sevenhome.bean.vo.VisualDataVo;
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
public interface OrdersDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderno, subscribeId, checkinId, orderTotalprice, orderStatus, orderGeneratetime, roomId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Orders> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrdersResult")
    Optional<Orders> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrdersResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orderno", property="orderno", jdbcType=JdbcType.VARCHAR),
        @Result(column="subscribe_id", property="subscribeId", jdbcType=JdbcType.INTEGER),
        @Result(column="checkin_id", property="checkinId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_totalprice", property="orderTotalprice", jdbcType=JdbcType.DECIMAL),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_generatetime", property="orderGeneratetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.INTEGER)
    })
    List<Orders> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, orders, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, orders, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Orders record) {
        return MyBatis3Utils.insert(this::insert, record, orders, c ->
            c.map(orderno).toProperty("orderno")
            .map(subscribeId).toProperty("subscribeId")
            .map(checkinId).toProperty("checkinId")
            .map(orderTotalprice).toProperty("orderTotalprice")
            .map(orderStatus).toProperty("orderStatus")
            .map(orderGeneratetime).toProperty("orderGeneratetime")
            .map(roomId).toProperty("roomId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Orders record) {
        return MyBatis3Utils.insert(this::insert, record, orders, c ->
            c.map(orderno).toPropertyWhenPresent("orderno", record::getOrderno)
            .map(subscribeId).toPropertyWhenPresent("subscribeId", record::getSubscribeId)
            .map(checkinId).toPropertyWhenPresent("checkinId", record::getCheckinId)
            .map(orderTotalprice).toPropertyWhenPresent("orderTotalprice", record::getOrderTotalprice)
            .map(orderStatus).toPropertyWhenPresent("orderStatus", record::getOrderStatus)
            .map(orderGeneratetime).toPropertyWhenPresent("orderGeneratetime", record::getOrderGeneratetime)
            .map(roomId).toPropertyWhenPresent("roomId", record::getRoomId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Orders> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, orders, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Orders> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, orders, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Orders> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, orders, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Orders> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, orders, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Orders record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderno).equalTo(record::getOrderno)
                .set(subscribeId).equalTo(record::getSubscribeId)
                .set(checkinId).equalTo(record::getCheckinId)
                .set(orderTotalprice).equalTo(record::getOrderTotalprice)
                .set(orderStatus).equalTo(record::getOrderStatus)
                .set(orderGeneratetime).equalTo(record::getOrderGeneratetime)
                .set(roomId).equalTo(record::getRoomId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Orders record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderno).equalToWhenPresent(record::getOrderno)
                .set(subscribeId).equalToWhenPresent(record::getSubscribeId)
                .set(checkinId).equalToWhenPresent(record::getCheckinId)
                .set(orderTotalprice).equalToWhenPresent(record::getOrderTotalprice)
                .set(orderStatus).equalToWhenPresent(record::getOrderStatus)
                .set(orderGeneratetime).equalToWhenPresent(record::getOrderGeneratetime)
                .set(roomId).equalToWhenPresent(record::getRoomId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Orders record) {
        return update(c ->
            c.set(orderno).equalTo(record::getOrderno)
            .set(subscribeId).equalTo(record::getSubscribeId)
            .set(checkinId).equalTo(record::getCheckinId)
            .set(orderTotalprice).equalTo(record::getOrderTotalprice)
            .set(orderStatus).equalTo(record::getOrderStatus)
            .set(orderGeneratetime).equalTo(record::getOrderGeneratetime)
            .set(roomId).equalTo(record::getRoomId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Orders record) {
        return update(c ->
            c.set(orderno).equalToWhenPresent(record::getOrderno)
            .set(subscribeId).equalToWhenPresent(record::getSubscribeId)
            .set(checkinId).equalToWhenPresent(record::getCheckinId)
            .set(orderTotalprice).equalToWhenPresent(record::getOrderTotalprice)
            .set(orderStatus).equalToWhenPresent(record::getOrderStatus)
            .set(orderGeneratetime).equalToWhenPresent(record::getOrderGeneratetime)
            .set(roomId).equalToWhenPresent(record::getRoomId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Select("select * from orders")
    List<Orders> getAllOrders();

    /**
     * 定时任务批量修改订单状态
     * @param ids
     * @return
     */
    int batUpdateOrderStatus(List<Integer> ids);

    @ResultMap("orders_checkin_subscribe")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    Orders getOrders(SelectStatementProvider provider);

    /**
     * 返回订单，连表查
     * @param ordersno1
     * @return
     */
    default Orders selectOrdersByOrdersno(String ordersno1){
        SelectStatementProvider provider = SqlBuilder.select(OrdersDao.selectList)
                .from(orders)
                .where(orderno, isEqualTo((ordersno1)))
                .build().render(RenderingStrategies.MYBATIS3);
        Orders orders = this.getOrders(provider);
        return orders;
    }

    @Select("select orderno from orders where room_id = #{roomid} and order_status = 4")
    String getOrderNoByRoomId(Integer roomid);

    
    @ResultMap("orders_room_subscibe_checkIn")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    List<Orders> selectOrders(SelectStatementProvider provider);

    /**
     * 查询线上订单信息 +条件查询
     * @return
     */
   default List<Orders> queryOrders(String name,String orderno,String status,Integer hotelid){
        String finalName = null;
       
        if (orderno != null && !"".equals(name)){
            finalName="%"+name+"%";
        }

        String finalOrderNo = null;
        if (orderno != null && !"".equals(orderno)){
            finalOrderNo="%"+orderno+"%";
        }

        if ("".equals(status)){
            status = null;
        }

        if ("".equals(hotelid)){
            hotelid = null;
        }

        SelectStatementProvider provider = SqlBuilder
                .select(orders.allColumns(),SubscribeDynamicSqlSupport.subscribe.allColumns(),RoomDynamicSqlSupport.room.allColumns())
                .from(orders)
                .leftJoin(SubscribeDynamicSqlSupport.subscribe)
                .on(subscribeId, equalTo(SubscribeDynamicSqlSupport.id))
                .leftJoin(RoomDynamicSqlSupport.room)
                .on(roomId, equalTo(RoomDynamicSqlSupport.id))
                .where(SubscribeDynamicSqlSupport.subscribeName,isLikeWhenPresent(finalName))
                .and(OrdersDynamicSqlSupport.orderno, isLikeWhenPresent(finalOrderNo))
                .and(orderStatus, isEqualToWhenPresent(status))
                .and(RoomDynamicSqlSupport.hotelId, isEqualToWhenPresent(hotelid))
                .and(subscribeId, isNotNull())
                .build().render(RenderingStrategies.MYBATIS3);
        return selectOrders(provider);
    }

    /**
     * 根据id查询订单订单列表
     */
    @Select("select *from orders where id=#{OrderId}")
    @ResultMap("orders_room_subscibe_checkIn")
    Orders getOrdersById(Integer orderId);

    default List<Integer> getRoomidByCheckinId(List<Integer> checkinIds){
        SelectStatementProvider render = SqlBuilder.select(orders.id).from(orders).where(checkinId, isIn(checkinIds))
                .build().render(RenderingStrategies.MYBATIS3);
        List<Orders> select = this.selectMany(render);
        ArrayList<Integer> list = new ArrayList<>();
        for (Orders orders1 : select) {
            list.add(orders1.getId());
        }
        return list;
    }


     default List<Orders> getLeaveRoomList(@Param("hotelid") Integer hotelid,@Param("roomno") String roomno){
        if (roomno != null){
            roomno = "%"+String.valueOf(roomno)+"%";
        }

         SelectStatementProvider render = SqlBuilder.select(OrdersDao.selectList).from(orders).leftJoin(CheckInDynamicSqlSupport.checkIn)
                 .on(CheckInDynamicSqlSupport.checkIn.id, equalTo(orders.checkinId))
                 .leftJoin(RoomDynamicSqlSupport.room)
                 .on(orders.roomId, equalTo(RoomDynamicSqlSupport.id))
                 .where(RoomDynamicSqlSupport.rommno, isLikeWhenPresent(roomno))
                 .and(orders.orderStatus, isEqualTo("4"))
                 .and(RoomDynamicSqlSupport.hotelId, isEqualTo(hotelid))
                 .build().render(RenderingStrategies.MYBATIS3);

         List<Orders> orders = this.selectOrders(render);
         return orders;
     }

    /**
     * 订单表映射房间表
     * @author lee
     * @param selectStatement
     * @return
     */
    @ResultMap("order_room")
    @Select("SELECT * FROM `orders` o left join room r on o.room_id = r.id where o.id = #{grorderId}")
    Optional<Orders> selectByOrdersId(SelectStatementProvider selectStatement);
    
    /**
     * 根据id修改订单状态
     */
    @Update("update orders set order_status=#{status} where id=#{id}")
    int updateOrdersStatus(Integer id,String status);

    @ResultMap("orders_room_subscibe_checkIn")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    List<Orders> selectOrdersReality(SelectStatementProvider provider);

    /**
     * 查询线下订单信息 +条件查询
     * @return
     */
    default List<Orders> queryOrdersReality(String name,String orderno,String status,Integer hotelid){
        String finalName = null;

        if (orderno != null && !"".equals(name)){
            finalName="%"+name+"%";
        }

        String finalOrderNo = null;
        if (orderno != null && !"".equals(orderno)){
            finalOrderNo="%"+orderno+"%";
        }

        if ("".equals(status)){
            status = null;
        }

        if ("".equals(hotelid)){
            hotelid = null;
        }

        SelectStatementProvider provider = SqlBuilder
                .select(orders.allColumns(),CheckInDynamicSqlSupport.checkIn.allColumns(),RoomDynamicSqlSupport.room.allColumns())
                .from(orders)
                .leftJoin(CheckInDynamicSqlSupport.checkIn)
                .on(checkinId, equalTo(CheckInDynamicSqlSupport.id))
                .leftJoin(RoomDynamicSqlSupport.room)
                .on(roomId, equalTo(RoomDynamicSqlSupport.id))
                .where(CheckInDynamicSqlSupport.checkinName,isLikeWhenPresent(finalName))
                .and(OrdersDynamicSqlSupport.orderno, isLikeWhenPresent(finalOrderNo))
                .and(orderStatus, isEqualToWhenPresent(status))
                .and(RoomDynamicSqlSupport.hotelId, isEqualToWhenPresent(hotelid))
                .and(subscribeId, isNull())
                .build().render(RenderingStrategies.MYBATIS3);
        return selectOrders(provider);
    }

    /**
     * 总收入
     * @return
     */
    @Select("select sum(order_totalprice) from orders")
    Double findEarning();


    @Select("select count(*) from orders")
    Integer findOrders();

    /**
     * 查询各家店的订单信息
     * @return
     */
    @ResultMap("order_subscribe_employee_hotel")
    @Select("select count(h.hotel_name) as num,h.hotel_name as hotelname from orders o left join check_in c on o.checkin_id = c.id left join employee e on c.employee_id = e.id left join hotel h on h.id = e.hotel_id GROUP BY h.hotel_name HAVING count(h.hotel_name)>=1 order by num desc")
     List<VisualDataVo> findOrdersBySole();

    /**
     * 每日营业额
     * @param startDate
     * @param endDate
     * @return
     */
    @ResultMap("everydayBusiness")
    @Select("SELECT date_format(order_generatetime, '%Y-%m-%d') dat,sum(order_totalprice) money FROM `orders`" +
            "where order_generatetime>#{startDate} and order_generatetime<=#{endDate} " +
            "group by date_format(order_generatetime, '%Y-%m-%d') " +
            "ORDER BY dat")
    List<EveryDayBusinessVo> findEverydayBusiness(String startDate, String endDate);
}