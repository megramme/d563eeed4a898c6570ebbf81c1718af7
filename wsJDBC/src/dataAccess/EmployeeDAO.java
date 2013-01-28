package dataAccess;
import java.sql.SQLException;
import java.util.List;

import dataAccess.domain.*;

public interface EmployeeDAO 
{
	public void addEmployee(Employee e) throws SQLException;
	public void removeEmployee(Employee e) throws SQLException;
	public List<Employee> listAllEmployees() throws SQLException;
	public void closeConnection();
}
