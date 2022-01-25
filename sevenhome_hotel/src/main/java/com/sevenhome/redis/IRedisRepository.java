package com.sevenhome.redis;

import com.sevenhome.bean.po.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * redis 对象类型存储
 */
@Repository
public interface IRedisRepository extends CrudRepository<Employee,Integer> {
}
