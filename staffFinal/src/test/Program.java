package test;
import java.util.List;
import java.util.Scanner;

import dao.StaffDao;
import pojo.Staff;
public class Program 
{

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		try(StaffDao dao = new StaffDao())
		{
			int choice,subChoice;
			int empId;
			int hrs;
			StaffTest test = new StaffTest();
			while((choice = StaffTest.menuList())!=0)
			{
				test.setStaff(StaffFactory.getInstance(choice));
				while((subChoice = StaffTest.subMenuList())!=0)
				{
					switch (subChoice) 
					{
					case 1:
						Staff staff = test.acceptRecord();
						dao.insert(staff);
						break;
					case 2:			
						System.out.print("Enter Emp Id: ");
						empId = sc.nextInt();
						System.out.println("Enter Hrs: ");
						hrs = sc.nextInt();
						dao.update(empId,hrs,test.getStaff());
						break;
					case 3:
						System.out.print("Enter Emp Id: ");
						empId = sc.nextInt();
						dao.delete(empId);
						break;
					case 4:
						List<Staff> staffList = dao.getStaff();
						test.printRecord(staffList);
						break;

					default:
						break;
					}
				}
			}
		}
		catch(Exception e)
		{
			
		}
	}

}
