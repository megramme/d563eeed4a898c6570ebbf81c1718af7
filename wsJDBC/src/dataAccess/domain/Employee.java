package dataAccess.domain;

public class Employee 
{
	private int id;
	private String name;
	private String firstName;
	
	public Employee(String name, String firstName)
	{
		this.name = name;
		this.firstName = firstName;
	}
	
	public String ToString()
	{
		return "employe id: "+this.id+" -- "+this.name+" "+this.firstName+".";
	}
	
	public int getid()
	{
		return this.id;
	}
	
	public void setid(int id)
	{
		this.id = id;
	}
	
	public String getname()
	{
		return this.name;
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public String getfirstName()
	{
		return this.firstName;
	}
	
	public void setfirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
}
