import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;
/**the following comments are similar as that in class FullTimeFaculty except special and different cases.
 */
public class PartTimeFaculty extends Employee
{
   private double HourlyRate;
   private int hours;
   private int studentNum;
   private static int size=0;
   private ArrayList<PartTimeFaculty> pt;//declare an ArrayList which store all bills.
   private ArrayList<Long> pt_id;//declare an ArrayList which store the bill number of Bill.
   public PartTimeFaculty()
   {
	   super();
	   HourlyRate=0;
	   hours=0;
	   studentNum=0;
   }
   public PartTimeFaculty(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newHourlyRate,int newhours,int newstudentNum)
   {
	   super(newId,newFirstName,newFamilyName,newCity,newHireYear);
	   HourlyRate=newHourlyRate;
	   hours=newhours;
	   studentNum=newstudentNum;
   }
   public double getHourlyRate()
   {
	   return HourlyRate;
   }
   public void setHourlyRate(double newHourlyRate)
   {
	   HourlyRate=newHourlyRate;
   }
   public int getHours()
   {
	   return hours;
   }
   public void setHours(int newhours)
   {
	   hours=newhours;
   }
   public int getStudentNum()
   {
	   return hours;
   }
   public void setStudentNum(int newStudentNum)
   {
	   studentNum=newStudentNum;
   }
   public void getArraySize(Scanner inputFile)
   {	  
 	  String line=null;
 	  while(inputFile.hasNextLine())
 	  {	      
 	    line=inputFile.nextLine();
 	    size++;
 	  }
       inputFile.close();	  
   }
   public void fillInArrayList(Scanner inputFile)
   {
	   pt=new ArrayList<PartTimeFaculty>();
	   pt_id=new ArrayList<Long>();
	   for(int i=0;i<size;i++)
	   {
		   PartTimeFaculty ptFaculty=new PartTimeFaculty(inputFile.nextLong(),inputFile.next(),inputFile.next(),inputFile.next(),inputFile.nextInt(),inputFile.nextDouble(),inputFile.nextInt(),inputFile.nextInt());;
		   pt.add(ptFaculty);
		   pt_id.add(ptFaculty.getId());
	   }	
	   inputFile.close();
   }
   
   public void addPTRecords(Scanner inputFile)
   {
	   fillInArrayList(inputFile);
	   System.out.println("Please add information of part-time faculty.");
	   Scanner keyboard=new Scanner(System.in);
	   long id=0;
	   String fisrname=null;
	   String familyname=null;
	   String cityname=null;
	   int hireyear=0;
	   double hrRate=0;	   
	   int hrs=0;
	   int sNum=0;	   
	   int exitInt=0;
	   boolean add=true;
	   boolean done=false;
	   boolean duplicate=false;
	   while(add)
	   {
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter ID:");
		        id=keyboard.nextLong();
		        if(pt_id.contains(id)==true)
		      	   duplicate=true;
	            while(duplicate)
	            {
	        	    duplicate=false;
	        	    System.out.println("The ID you entered exiested in the original file,please enter another one:");
	        	    id=keyboard.nextLong();
	        	    if(pt_id.contains(id)==true)
			    	  duplicate=true;
	            }
	            done=true;
	         }
	         catch(InputMismatchException e)
	         {
	        	keyboard.nextLine();
	    	    System.out.println("This is not a correct type.Please enter a long type ID:");
	         }
	      }
	      done=false;
	      keyboard.nextLine();
	      System.out.println("Please enter first name:");
	      fisrname=keyboard.nextLine();
	      System.out.println("Please enter family name:");
	      familyname=keyboard.nextLine();
	      System.out.println("Please enter city name:");
	      cityname=keyboard.nextLine();
	      boolean yearBound=false;
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter hired year:");
	    	    hireyear=keyboard.nextInt();
		        if(hireyear>2018||hireyear<1900)
		    	    yearBound=true;
	            while(yearBound)
	            {
	        	    yearBound=false;
	        	    System.out.println("The hired year you entered is unreasonable,please enter another one:");
	        	    hireyear=keyboard.nextInt();
	        	    if(hireyear>2018||hireyear<1900)
			    	    yearBound=true;
	            }
	            done=true;
	         }
	         catch(InputMismatchException e)
	         {
	        	keyboard.nextLine();
	    	    System.out.println("This is not a correct type.Please enter a int type hired year:");
	         }
	      }
	      done=false;
	      boolean hrRateBound=false;
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter hourly rate:");
	    	    hrRate=keyboard.nextDouble();
		        if(hrRate>10000||hrRate<0)
		        	hrRateBound=true;
	            while(hrRateBound)
	            {
	            	hrRateBound=false;
	        	    System.out.println("The hourly rate you entered is unreasonable,please enter another one:");
	        	    hrRate=keyboard.nextDouble();
	        	    if(hrRate>10000||hrRate<0)
			        	hrRateBound=true;
	            }
	            done=true;
	         }
	         catch(InputMismatchException e)
	         {
	        	keyboard.nextLine();
	    	    System.out.println("This is not a correct type.Please enter a double type hourly rate:");
	         }
	      }
	      done=false;
	      boolean hrsBound=false;
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter hours:");
	    	    hrs=keyboard.nextInt();
		        if(hrs>8760||hrs<0)
		        	hrsBound=true;
	            while(yearBound)
	            {
	            	hrsBound=false;
	        	    System.out.println("The hours you entered is unreasonable,please enter another one:");
	        	    hrs=keyboard.nextInt();
	        	    if(hrs>8760||hrs<0)
			        	hrsBound=true;
	            }
	            done=true;
	         }
	         catch(InputMismatchException e)
	         {
	        	keyboard.nextLine();
	    	    System.out.println("This is not a correct type.Please enter a int type hours:");
	         }
	      }
	      done=false;
	      boolean sNumbound=false;
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter number of students:");
	    	    sNum=keyboard.nextInt();
		        if(sNum>1000||sNum<0)
		        	sNumbound=true;
	            while(yearBound)
	            {
	            	sNumbound=false;
	        	    System.out.println("The hired year you entered is unreasonable,please enter another one:");
	        	    sNum=keyboard.nextInt();
	        	    if(sNum>1000||sNum<0)
			        	sNumbound=true;
	            }
	            done=true;
	         }
	         catch(InputMismatchException e)
	         {
	        	keyboard.nextLine();
	    	    System.out.println("This is not a correct type.Please enter a int type student number:");
	         }
	      }	      	      	      	      
	      done=false;
	      PartTimeFaculty addItems=new PartTimeFaculty(id,fisrname,familyname,cityname,hireyear,hrRate,hrs,sNum);
		  pt.add(addItems);
		  pt_id.add(addItems.getId());
	      boolean add_exit=false;
	      while(!add_exit)
	      {
		      try
		      {
			      System.out.println("Please enter -1 to end adding,otherwise continue:");
			      exitInt=keyboard.nextInt();
			      if(exitInt==-1)
			      {
				      add_exit=true;
				      add=false;
				      System.out.println("You chose to end adding.The added information was add in the file already.");
			      }
			      else
			      {
				      System.out.println("You chose to continue adding.");
				      add_exit=true;
			      }
		      }
		      catch(InputMismatchException e)
		      {
		    	  keyboard.nextLine();
			      System.out.println("This is not a correct type.Please enter a int type:");
		      }
	      }
	   }//end of outer while loop
   }
   public void storeInText(PrintWriter outputFile)
   {
	   Object[] arr=pt.toArray();
	   for(int i=0;i<arr.length;i++)	   
		   outputFile.printf("%-10d%-10s%-15s%-15s%-10d%-10.2f%-10d%-10d%n",((PartTimeFaculty) arr[i]).getId(),((PartTimeFaculty) arr[i]).getFirstName(),((PartTimeFaculty) arr[i]).getFamilyName(),((PartTimeFaculty) arr[i]).getCity(),((PartTimeFaculty) arr[i]).getHireYear(),((PartTimeFaculty) arr[i]).HourlyRate,((PartTimeFaculty) arr[i]).hours,((PartTimeFaculty) arr[i]).studentNum); 
	   outputFile.close();
   }
}
