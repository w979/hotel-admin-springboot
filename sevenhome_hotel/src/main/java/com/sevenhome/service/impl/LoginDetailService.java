package com.sevenhome.service.impl;

import com.sevenhome.bean.po.Employee;
import com.sevenhome.dao.EmployeeDao;
import com.sevenhome.redis.impl.RedisStrRepository;
import lombok.SneakyThrows;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Spring security的获取登录人数据的业务类
 */
@Service
@Transactional
public class LoginDetailService implements UserDetailsService {
    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private RedisStrRepository redisStrRepository;
    /**
     *
     * @param username  获得用户在登录页面输入的帐号
     * @return
     * @throws UsernameNotFoundException
     */
    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("==>"+username);
        Employee employee = employeeDao.selectEmployeeByName(username);
        System.out.println("==>"+employee);
        List<String> permissions = employee.getPermList();
        String authority= String.join(",", permissions);
        //往redis存储权限
        redisStrRepository.setAuthority(username, authority);

        if (employee!=null&&employee.getEmpStatus().equals("n")){
            return new User(employee.getUsername(), employee.getPassword(),
                    true, false, false,
                    false, AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
        }
        System.out.println(authority);
        return new User(employee.getUsername(), employee.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
    }
}
