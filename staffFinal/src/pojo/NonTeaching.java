package pojo;

public class NonTeaching extends Staff
{
	int labHrs;
	public NonTeaching() 
	{	}
	
	public NonTeaching(int empID, String name, float salary, int labHrs) 
	{
		super(empID, name, salary);
		this.labHrs = labHrs;
	}
	

	public int getLabHrs() {
		return labHrs;
	}

	public void setLabHrs(int labHrs) {
		this.labHrs = labHrs;
	}

	@Override
	public void calculateSalary() 
	{
		this.salary = 850 * this.labHrs;
	}
	
	@Override
	public String toString() 
	{
		return super.toString()+this.labHrs;
	}
	
}
