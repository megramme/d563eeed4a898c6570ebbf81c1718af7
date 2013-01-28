package dataAccess;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dataAccess.domain.Employee;

public class EmployeePreparedDAO implements EmployeeDAO
{

	
private java.sql.Connection conn;
	
	public EmployeePreparedDAO()
	{
	    try 
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Driver O.K.");
	 
	      String url = "jdbc:mysql://127.0.0.1:3306/wsjdbcdb";
	      String user = "root";
	      String passwd = "";
	 
	      conn = (Connection) DriverManager.getConnection(url, user, passwd);
	      
	      System.out.println("Connexion effective !");  
	      
	    }
	    
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	      throw new RuntimeException("erreur dans l'obtention de la connexion -- le prog va s'arrêter");
	    }     
	  
	}

	
	@Override
	public void addEmployee(Employee e) throws SQLException 
	{
		
		String name = e.getname();
		String firstName = e.getfirstName();
		String query = "INSERT INTO employes(nom,prenom) VALUES ('"+name+"','"+firstName+"');";
		
		PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(query);
		prepare.execute();
	      
	    prepare.close();
	      
	    System.out.println("Requête effectuée avec succes !");
	}

	@Override
	public void removeEmployee(Employee e) throws SQLException {
		String name = e.getname();
		String firstName = e.getfirstName();
		String query = "DELETE FROM employes WHERE nom = '"+name+"' AND prenom = '"+firstName+"';";
		
		PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(query);
		prepare.execute();
	      
	    prepare.close();
	      
	    System.out.println("Requête effectuée avec succes !");
		
	}

	@Override
	public List<Employee> listAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

}
