public class Employee implements Ordered
{
	/**declares some Employee attributes.
	 */
	private long Id;
	private String FirstName;
	private String FamilyName;
	private String city;
	private int HireYear;
	public Employee()
	{
		Id=0;
		FirstName=null;
		FamilyName=null;
		city=null;
		HireYear=1980;
	}
	public Employee(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear)
	{
		Id=newId;
		FirstName=newFirstName;
		FamilyName=newFamilyName;
		city=newCity;
		HireYear=newHireYear;
	}
	/**complete the following methods in the interface Ordered.
	 */
	public boolean precedes(Object other)
	{
		if(other==null)
			return false;
		else if(!(other instanceof Employee))
			return false;
		else
		{
			Employee e=(Employee)other;
			return HireYear<e.HireYear;
		}
	}
	public boolean follows(Object other)
	{
		if(other==null)
			return false;
		else if(!(other instanceof Employee))
			return false;
		else
		{
			Employee e=(Employee)other;
			return HireYear>e.HireYear;
		}   
	}
	public long getId()
	{
		return Id;
	}
	public void setId(long newId)
	{
		Id=newId;
	}
	public String getFamilyName()
	{
		return FamilyName;
	}
	public void setFamilyName(String newFamilyName)
	{
		FamilyName=newFamilyName;
	}
	public String getFirstName()
	{
		return FirstName;
	}
	public void setFirstName(String newFirstName)
	{
		FirstName=newFirstName;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String newCity)
	{
		city=newCity;
	}
	public int getHireYear()
	{
		return HireYear;
	}
	public void setHireYear(int newHireYear)
	{
		HireYear=newHireYear;
	}
	public String toString()
	{
		return Id+" "+FirstName+" "+FamilyName+" "+city+" "+HireYear;
	}
}
