package pojo;

public abstract class Staff 
{
	int empID;
	String name;
	float salary;
	public Staff() 
	{	}
	public Staff(int empID, String name, float salary)
	{
		this.empID = empID;
		this.name = name;
		this.salary = salary;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public abstract void calculateSalary();
	@Override
	public String toString() 
	{
		return String.format("%-5d%-30s%-10.2f", this.empID,this.name,this.salary);
	}
	
}
