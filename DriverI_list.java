import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class DriverI_list 
{
	public static void main(String[] args) 
	{	  				
		 System.out.println("Open some files and make some calculations.");
		 System.out.println();
		 List link=new List();		
		 Scanner inputF1=null;
		 Scanner inputF2=null;
		 Scanner inputF3=null;
		 Scanner inputF4=null;
		 PrintWriter pw=null;
		  try
		  {
			 inputF1=new Scanner(new FileInputStream("Part-Time-Faculty.txt"));	
			 inputF2=new Scanner(new FileInputStream("TAs.txt"));
			 inputF3=new Scanner(new FileInputStream("Full-Time-Faculty.txt"));
			 inputF4=new Scanner(new FileInputStream("Staff.txt"));
			 link.getArraySize1(inputF1);	
			 link.getArraySize2(inputF2);
			 link.getArraySize3(inputF3);
			 link.getArraySize4(inputF4);
		  }
		  catch(FileNotFoundException e)
		  {
			 System.out.println("Problem opening files.Program will terminate.");
			 System.exit(0);
		  }
		  System.out.println("=====================================================================");
	      System.out.println("Open Part-Time-Faculty.txt and TAs.txt to find combined total salary.");
		  try
		  {			
			 inputF1=new Scanner(new FileInputStream("Part-Time-Faculty.txt"));
			 inputF2=new Scanner(new FileInputStream("TAs.txt"));		
			 link.findTermSalary(inputF1,inputF2);
		  }
		  catch(FileNotFoundException e)
		  {
			 System.out.println("Problem opening files.Program will terminate.");
			 System.exit(0);
		  }
		  System.out.println();
		  System.out.println("=====================================================================");
	      System.out.println("Open Full-Time-Faculty.txt to find the highest and lowest salary.");
		  try
		  {			
			 inputF3=new Scanner(new FileInputStream("Full-Time-Faculty.txt"));				 	
			 link.findHighest_and_FT_Salary(inputF3);
	
		  }
		  catch(FileNotFoundException e)
		  {
			 System.out.println("Problem opening files.Program will terminate.");
			 System.exit(0);
		  }
		  System.out.println();
		  System.out.println("=====================================================================");
	      System.out.println("Open Staff.txt to increases the salary as per its evaluation code..");
		  try
		  {			
			 inputF4=new Scanner(new FileInputStream("Staff.txt"));				 	
		     link.Increase_Staff_Salary(inputF4);
		  }
		  catch(FileNotFoundException e)
		  {
			 System.out.println("Problem opening files.Program will terminate.");
			 System.exit(0);
		  }
		  /**write the added information to TAs.txt.
		   */
		  try
		  {
			 pw=new PrintWriter(new FileOutputStream("Staff.txt"));
			 link.output(pw);
		  }
		  catch(FileNotFoundException e)
		  {
			 System.out.println("Problem opening files.Program will terminate.");
			 System.exit(0);
		  }
	}

}
