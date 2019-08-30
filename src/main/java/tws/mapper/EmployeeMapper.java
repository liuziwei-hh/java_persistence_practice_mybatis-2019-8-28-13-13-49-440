package tws.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.controller.Employee;

@Mapper
public interface EmployeeMapper {

	@Insert("insert into employee values(#{employee.id},#{employee.name},#{employee.age})")
	void insertEmployee(@Param("employee") Employee employee);

	@Select("SELECT * FROM employee OFFSET 5 ROWS FETCH NEXT 10 ROWS ONLY")
	List<Employee> getAllEmployeeInPage();

	void selectEmployee(Employee employee);

	@Update("update employee set name=#{employee.name},age=#{employee.age}")
	List<Employee> updateEmployee(Employee employee);

	@Delete("delete from employee where id=#{employee.id}")
	void deleteEmployee();

}
