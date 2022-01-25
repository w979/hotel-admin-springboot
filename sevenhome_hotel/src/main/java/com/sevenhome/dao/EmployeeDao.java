package com.sevenhome.dao;

import static com.sevenhome.dao.EmployeeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sevenhome.bean.po.Employee;
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

@Mapper
public interface EmployeeDao {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, empname, sex, username, password, empImg, empNumber, empSalary, empStatus, hotelId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Employee> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EmployeeResult")
    Optional<Employee> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EmployeeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="empname", property="empname", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_img", property="empImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_number", property="empNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_salary", property="empSalary", jdbcType=JdbcType.DECIMAL),
        @Result(column="emp_status", property="empStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotel_id", property="hotelId", jdbcType=JdbcType.INTEGER)
    })
    List<Employee> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, employee, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, employee, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Employee record) {
        return MyBatis3Utils.insert(this::insert, record, employee, c ->
            c.map(empname).toProperty("empname")
            .map(sex).toProperty("sex")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(empImg).toProperty("empImg")
            .map(empNumber).toProperty("empNumber")
            .map(empSalary).toProperty("empSalary")
            .map(empStatus).toProperty("empStatus")
            .map(hotelId).toProperty("hotelId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Employee record) {
        return MyBatis3Utils.insert(this::insert, record, employee, c ->
            c.map(empname).toPropertyWhenPresent("empname", record::getEmpname)
            .map(sex).toPropertyWhenPresent("sex", record::getSex)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(empImg).toPropertyWhenPresent("empImg", record::getEmpImg)
            .map(empNumber).toPropertyWhenPresent("empNumber", record::getEmpNumber)
            .map(empSalary).toPropertyWhenPresent("empSalary", record::getEmpSalary)
            .map(empStatus).toPropertyWhenPresent("empStatus", record::getEmpStatus)
            .map(hotelId).toPropertyWhenPresent("hotelId", record::getHotelId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Employee> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, employee, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Employee> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, employee, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Employee> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, employee, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Employee> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, employee, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Employee record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(empname).equalTo(record::getEmpname)
                .set(sex).equalTo(record::getSex)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(empImg).equalTo(record::getEmpImg)
                .set(empNumber).equalTo(record::getEmpNumber)
                .set(empSalary).equalTo(record::getEmpSalary)
                .set(empStatus).equalTo(record::getEmpStatus)
                .set(hotelId).equalTo(record::getHotelId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Employee record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(empname).equalToWhenPresent(record::getEmpname)
                .set(sex).equalToWhenPresent(record::getSex)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(empImg).equalToWhenPresent(record::getEmpImg)
                .set(empNumber).equalToWhenPresent(record::getEmpNumber)
                .set(empSalary).equalToWhenPresent(record::getEmpSalary)
                .set(empStatus).equalToWhenPresent(record::getEmpStatus)
                .set(hotelId).equalToWhenPresent(record::getHotelId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Employee record) {
        return update(c ->
            c.set(empname).equalTo(record::getEmpname)
            .set(sex).equalTo(record::getSex)
            .set(username).equalTo(record::getUsername)
            .set(password).equalTo(record::getPassword)
            .set(empImg).equalTo(record::getEmpImg)
            .set(empNumber).equalTo(record::getEmpNumber)
            .set(empSalary).equalTo(record::getEmpSalary)
            .set(empStatus).equalTo(record::getEmpStatus)
            .set(hotelId).equalTo(record::getHotelId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Employee record) {
        return update(c ->
            c.set(empname).equalToWhenPresent(record::getEmpname)
            .set(sex).equalToWhenPresent(record::getSex)
            .set(username).equalToWhenPresent(record::getUsername)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(empImg).equalToWhenPresent(record::getEmpImg)
            .set(empNumber).equalToWhenPresent(record::getEmpNumber)
            .set(empSalary).equalToWhenPresent(record::getEmpSalary)
            .set(empStatus).equalToWhenPresent(record::getEmpStatus)
            .set(hotelId).equalToWhenPresent(record::getHotelId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("employee_perms")
    List<Employee> selectEmployeeByName(SelectStatementProvider statementProvider);

    /**
     * 登陆查询
     */
    default Employee selectEmployeeByName(String username){
        SelectStatementProvider provider = SqlBuilder
                .select(EmployeeDao.selectList)
                .from(employee)
                .where(employee.username, isEqualTo(username))
                .build().render(RenderingStrategies.MYBATIS3);
        List<Employee> employeeList = this.selectEmployeeByName(provider);
        if (employeeList.size()>0){
            return employeeList.get(0);
        }
        return null;
    }

    /**
     * 查询员工个人信息
     * @author lee
     * @param username
     * @return
     */
//    default Employee findEmployeeByUserName(String username){
//        SelectDSLCompleter dslCompleter = c->c.where(EmployeeDynamicSqlSupport.username,isEqualTo(username));
//        return this.select(dslCompleter).get(0);
//    }
    /**
     * 查询员工个人信息
     * @author lee
     * @param username
     * @return
     */
    @ResultMap("employee_dept")
    @Select("SELECT e.*,role_id FROM `employee`e left join role_employee re on e.id = re.employee_id where username=#{username}")
    Employee findEmployeeByUserName(String username);
    /**
     * 查询所有员工对应的部门
     * @author lee
     * @return
     */
    @ResultMap("employee_dept")
    @Select("SELECT e.*,role_id FROM `employee`e left join role_employee re on e.id = re.employee_id where hotel_id=#{id}")
    List<Employee> findAllEmp(Integer id);


    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Select("select * from employee where id=#{id}")
    List<Employee> getEmployee(Integer id);


}