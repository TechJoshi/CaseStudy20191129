package pojo;

public class Teaching extends Staff
{
	int lectHrs;
	public Teaching() 
	{	}
	
	public Teaching(int empID, String name, float salary, int lectHrs) 
	{
		super(empID, name, salary);
		this.lectHrs = lectHrs;
	}
	
	public int getLectHrs() {
		return lectHrs;
	}

	public void setLectHrs(int lectHrs) {
		this.lectHrs = lectHrs;
	}
	
	@Override
	public void calculateSalary() 
	{
		this.salary = 1200 * this.lectHrs;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + this.lectHrs;
	}

}
