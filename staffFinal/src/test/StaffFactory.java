package test;

import pojo.NonTeaching;
import pojo.Staff;
import pojo.Teaching;

public class StaffFactory 
{

	public static Staff getInstance(int choice) 
	{
		switch (choice) 
		{
		case 1:
			return new Teaching();
		case 2:
			return new NonTeaching();
		}
		return null;
	}

}
