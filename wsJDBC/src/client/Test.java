package client;

import java.sql.SQLException;

import dataAccess.EmployeeSimpleDAO;
import dataAccess.EmployeePreparedDAO;
import dataAccess.domain.Employee;

public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException 
	{
		EmployeeSimpleDAO ESDAO = new EmployeeSimpleDAO();
		Employee e1 = new Employee("Antoine", "Uber");
		EmployeePreparedDAO EPDAO = new EmployeePreparedDAO();
		EPDAO.removeEmployee(e1);
		ESDAO.listAllEmployees();

	}

}
