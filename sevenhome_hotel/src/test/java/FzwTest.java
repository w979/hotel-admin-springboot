import com.github.pagehelper.PageInfo;
import com.sevenhome.ApplicationApp;
import com.sevenhome.bean.po.DepositDetail;
import com.sevenhome.bean.po.Orders;
import com.sevenhome.bean.po.Room;
import com.sevenhome.bean.po.Vip;
import com.sevenhome.bean.vo.OrdersVo;
import com.sevenhome.dao.*;
import com.sevenhome.bean.vo.DepositDetailVo;
import com.sevenhome.service.IDepositDetailsService;
import com.sevenhome.service.IOrdersService;
import com.sevenhome.service.impl.SubscribeService;
import com.sevenhome.utils.RandomCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;


@SpringBootTest(classes = ApplicationApp.class)
public class FzwTest {

    @Resource
    private VipDao vipDao;

    @Resource
    private IOrdersService ordersService;

    @Autowired
    private RoomDao roomDao;

    @Resource
    private DepositDetailDao depositDetailDao;

    @Resource
    private IDepositDetailsService depositDetailsService;

    @Resource
    private OrdersDao ordersDao;

    @Resource
    private DepositDao depositDao;

    @Test
    public void show1(){
        PageInfo<OrdersVo> pageInfo = ordersService.QueryAllOrdersReality(1, 10, "", "", "", 1);
        System.out.println(pageInfo);
    }

    @Test
    public void show2(){
        List<DepositDetail> depositDetails = depositDetailDao.queryAllDepositDetail(1);
        System.out.println(depositDetails);
        for (DepositDetail depositDetail : depositDetails) {
            System.out.println(depositDetail.getRoomGoods());
        }
    }

    @Test
    public void show3(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Room room = roomDao.getRoomGroupBy(1, 2, list);
        System.out.println(room.toString());
        Room oneRoomId = roomDao.getOneRoomId(room.getRoomtypeId(), list);
        System.out.println(oneRoomId.toString());
    }
    @Test
    public void show4(){
        String no = RandomCode.getVipNo("18207149575");
        System.out.println(no);
        List<DepositDetailVo> depositDetail = depositDetailsService.getDepositDetail(1);
        System.out.println(depositDetail);
    }

    @Test
    public void show5(){
        Vip vip = vipDao.UpdateTotalPay("8808");
        System.out.println(vip.getUserOnline().toString());
    }

    @Test
    public void show6() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatIntime = sdf.format(new Date());
        formatIntime.substring(0,9);
        System.out.println(formatIntime);

    }
}
