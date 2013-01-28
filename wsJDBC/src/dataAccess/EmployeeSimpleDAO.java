package dataAccess;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import dataAccess.domain.Employee;



public class EmployeeSimpleDAO implements EmployeeDAO
{
	private java.sql.Connection conn;
	
	public EmployeeSimpleDAO()
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
	public void addEmployee(Employee e) throws SQLException {
		
	}

	@Override
	public void removeEmployee(Employee e) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> listAllEmployees()
	{
		
		try{
		
		//Création d'un objet Statement
	      Statement state = (Statement) conn.createStatement();
	      //L'objet ResultSet contient le résultat de la requête SQL
	      ResultSet result = state.executeQuery("SELECT * FROM employes");
	      //On récupère les MetaData
	      ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
	          
	      System.out.println("\n**************************************************");
	      //On affiche le nom des colonnes
	      
	      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
	          
	      System.out.println("\n**************************************************");
	          
	      while(result.next()){        
	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	          System.out.print("\t" + result.getObject(i).toString() + "\t |");
	             
	        System.out.println("\n---------------------------------------------------");
	      }
		}
		
		catch(Exception e)
		{
			 e.printStackTrace();
			 throw new RuntimeException("erreur dans l'execution de la requète -- le prog va s'arrêter");
		}
		return null;
		
	}

	@Override
	public void closeConnection()
	{
			
		
	}

}
