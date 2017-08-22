import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class Staff extends Employee
{
   private double salary;
   private String pCode;
   public Staff()
   {
	   super();
	   salary=0;
	   pCode=null;
   }
   public Staff(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newsalary,String newpCode)
   {
	   super(newId,newFirstName,newFamilyName,newCity,newHireYear);
	   salary=newsalary;
	   pCode=newpCode;
   }
   public double getSalary()
   {
	   return salary;
   }
   public void setSalary(double newSalary)
   {
	   salary=newSalary;
   }
   public String getPCode()
   {
	   return pCode;
   }
   public void setPCode(String newPCode)
   {
	   pCode=newPCode;
   }
}
