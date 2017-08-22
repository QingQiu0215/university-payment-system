
public class DriverI_follow 
{

	public static void main(String[] args) 
	{
		Employee e1=new Employee(7875493,"Linda","Davis","Brossard",1998);
		Employee e2=new Employee(8379288,"Mark","Davidson","Montreal",1989);
		Employee e3=new FullTimeFaculty(7638686,"Simon","Jackson","Laval",2008,120000);
		Employee e4=new PartTimeFaculty(4880032,"Ella","Ryan","St-Laurent",1999,65.12,130,54);
		if(e1.precedes(e3))
			System.out.println("The hire year of "+e1.getFirstName()+" precedes that of "+e3.getFirstName()+".");
		else
			System.out.println("The hire year of "+e1.getFirstName()+" follows that of "+e3.getFirstName()+".");
		if(e2.follows(e4))
			System.out.println("The hire year of "+e2.getFirstName()+" follows that of "+e4.getFirstName()+".");
		else
			System.out.println("The hire year of "+e2.getFirstName()+" precedes that of "+e4.getFirstName()+".");
	}

}
