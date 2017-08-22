import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class DriverI_add 
{
	public static void main(String[] args) 
	{	 
		System.out.println("==============================================================");
		System.out.println("Attempting to add new item to the file: Full-Time-Faculty.txt.");
		System.out.println("==============================================================");	  
		Scanner inputF=null;
		FullTimeFaculty ft=new FullTimeFaculty();
		//get size of arrayList.
		try
		{
			inputF=new Scanner(new FileInputStream("Full-Time-Faculty.txt"));
			ft.getArraySize(inputF);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		//add info.
		try
		{
			inputF=new Scanner(new FileInputStream("Full-Time-Faculty.txt"));
			ft.addFTRecords(inputF);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		PrintWriter pw=null;
		//write the added information to Full-Time-Faculty.txt.
		try
		{
			pw=new PrintWriter(new FileOutputStream("Full-Time-Faculty.txt"));
			ft.storeInText(pw);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		System.out.println("==============================================================");
		System.out.println("Attempting to add new item to the file: Part-Time-Faculty.txt.");
		System.out.println("==============================================================");  		
		PartTimeFaculty pt=new PartTimeFaculty();
		//get size of arrayList.
		try
		{
			inputF=new Scanner(new FileInputStream("Part-Time-Faculty.txt"));
			pt.getArraySize(inputF);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		//add info.
		try
		{
			inputF=new Scanner(new FileInputStream("Part-Time-Faculty.txt"));
			pt.addPTRecords(inputF);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		//write the added information to Part-Time-Faculty.txt.
		try
		{
			pw=new PrintWriter(new FileOutputStream("Part-Time-Faculty.txt"));
			pt.storeInText(pw);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		System.out.println("==============================================================");
		System.out.println("Attempting to add new item to the file: TAs.txt.");
		System.out.println("==============================================================");  		  		
		TA ta=new TA();
		//get size of arrayList.
		try
		{
			inputF=new Scanner(new FileInputStream("TAs.txt"));
			ta.getArraySize(inputF);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		//add info.
		try
		{
			inputF=new Scanner(new FileInputStream("TAs.txt"));
			ta.addTARecords(inputF);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
		//write the added information to TAs.txt.
		try
		{
			pw=new PrintWriter(new FileOutputStream("TAs.txt"));
			ta.storeInText(pw);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.Program will terminate.");
			System.exit(0);
		}
	}
}
