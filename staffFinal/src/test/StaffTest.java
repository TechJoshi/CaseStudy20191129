package test;

import java.util.List;
import java.util.Scanner;

import pojo.NonTeaching;
import pojo.Staff;
import pojo.Teaching;

public class StaffTest 
{
	Staff staff;
	
	public Staff getStaff() 
	{
		return staff;
	}
	public void setStaff(Staff staff) 
	{
		this.staff = staff;
	}
	static Scanner sc = new Scanner(System.in);
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1.Teaching");
		System.out.println("2.Non Teaching");
		System.out.println("Select Choice:  ");
		return sc.nextInt();
		
		
	}
	public static int subMenuList() 
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Record");
		System.out.println("2.Update Record");
		System.out.println("3.Delete Record");
		System.out.println("4.Print Record");
		System.out.println("Enter the choice: ");
		
		return sc.nextInt();
	}
	public Staff acceptRecord() 
	{
		System.out.print("Enter Emp Id: ");
		this.staff.setEmpID(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter Name:  ");
		this.staff.setName(sc.nextLine());
		if(this.staff instanceof Teaching)
		{
			Teaching t = (Teaching) this.staff;
			System.out.println("Enter Lecture hours: ");
			t.setLectHrs(sc.nextInt());
			t.calculateSalary();
		}
		else
		{
			NonTeaching t = (NonTeaching) this.staff;
			System.out.println("Enter Lecture hours: ");
			t.setLabHrs(sc.nextInt());
			t.calculateSalary();
		}
		
		return this.staff;
	}
	public void printRecord(List<Staff> staffList) 
	{
		if(staffList != null)
		{
			for (Staff staff : staffList) 
			{
				System.out.println(staff);
			}
		}
	}


}
