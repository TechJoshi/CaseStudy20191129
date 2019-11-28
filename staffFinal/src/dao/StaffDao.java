package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.NonTeaching;
import pojo.Staff;
import pojo.Teaching;
import utils.DBUtils;

public class StaffDao implements Closeable 
{

	Connection connection;
	CallableStatement statement;
	public StaffDao() throws Exception 
	{
		connection = DBUtils.getConnection();
	}
	

	public void insert(Staff staff) throws Exception 
	{
		String sql = "{call sp_insert_staff(?,?,?,?)}";
		statement = connection.prepareCall(sql);
		statement.setInt(1, staff.getEmpID());
		statement.setString(2, staff.getName());
		statement.setFloat(3, staff.getSalary());
		if(staff instanceof Teaching)
		{
			Teaching t = (Teaching) staff;
			statement.setInt(4,t.getLectHrs());
		}
		else
		{
			NonTeaching t = (NonTeaching) staff;
			statement.setInt(4, t.getLabHrs());
		}
		statement.execute();
	}
	
	
	@Override
	public void close() throws IOException 
	{
		try 
		{
			if(connection != null)
				connection.close();
			if(statement != null)
				statement.close();
		}
		catch (SQLException cause) 
		{
			throw new RuntimeException(cause);
		}
	}


	public List<Staff> getStaff() throws Exception 
	{
		List<Staff> staffList = new ArrayList<Staff>();
		String sql = "{call sp_select_staff()}";
		statement = connection.prepareCall(sql);
		statement.execute();
		try(ResultSet rs = statement.getResultSet();)
		{
			while(rs.next())
			{
				Teaching t = new Teaching(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
				staffList.add(t);
			}
		}
		return staffList;
	}


	public void update(int empId, int hrs,Staff staff2) throws SQLException 
	{
		String sql = "{call sp_update_staff(?,?,?)}";
		statement  = connection.prepareCall(sql);
		if(staff2 instanceof Teaching)
		{
			Teaching t = (Teaching) staff2;
			statement.setInt(1,empId);
			statement.setInt(2, hrs);
			t.setLectHrs(hrs);
			t.calculateSalary();
			statement.setFloat(3, t.getSalary());
		}
		else
		{
			NonTeaching t = (NonTeaching) staff2;
			statement.setInt(1,empId);
			statement.setInt(2, hrs);
			t.setLabHrs(hrs);
			t.calculateSalary();
			statement.setFloat(3, t.getSalary());
		}
		statement.execute();
	}


	public void delete(int empId) throws SQLException 
	{
		String sql = "{call sp_delete_staff(?)}";
		statement = connection.prepareCall(sql);
		statement.setInt(1, empId);
		statement.execute();
		
	}


	

}
