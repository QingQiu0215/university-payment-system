import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;
/**create a class FullTimeFaculty which inherit from Employee
 */
public class FullTimeFaculty extends Employee
{
   private double salary;
   private static int size=0;
   private ArrayList<FullTimeFaculty> ft;//declare an ArrayList which store all bills.
   private ArrayList<Long> ft_id;//declare an ArrayList which store the bill number of Bill.
   public FullTimeFaculty()
   {
	   super();
	   salary=0;
   }
   public FullTimeFaculty(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newsalary)
   {
	   super(newId,newFirstName,newFamilyName,newCity,newHireYear);
	   salary=newsalary;
   }
   public double getSalary()
   {
	   return salary;
   }
   public void setSalary(double newSalary)
   {
	   salary=newSalary;
   }
   /**get the lines of bill.txt.
	 */
   public void getArraySize(Scanner inputFile)
   {	  
 	  String line=null;
 	  //the while-loop check the end of a file.
 	  while(inputFile.hasNextLine())
 	  {	      
 	    line=inputFile.nextLine();
 	    size++;
 	  }
       inputFile.close();	  
   }
   /**extract the bill number of each line and add to ArrayList serv_bill.
     *and store all bills into ArrayList ft.
	 */
   public void fillInArrayList(Scanner inputFile)
   {
	   ft=new ArrayList<FullTimeFaculty>();
	   ft_id=new ArrayList<Long>();
	   for(int i=0;i<size;i++)
	   {
		 FullTimeFaculty ftFaculty=new FullTimeFaculty(inputFile.nextLong(),inputFile.next(),inputFile.next(),inputFile.next(),inputFile.nextInt(),inputFile.nextDouble());;
		 ft.add(ftFaculty);
		 ft_id.add(ftFaculty.getId());
	   }		   
   }
   /**add another bill from the users.
	 */
   public void addFTRecords(Scanner inputFile)
   {
	   fillInArrayList(inputFile);
	   System.out.println("Please add information of full-time faculty.");
	   Scanner keyboard=new Scanner(System.in);
	   long id=0;
	   String firstname=null;
	   String familyname=null;
	   String cityname=null;
	   int hireyear=0;
	   double money=0;
	   int exitInt=0;
	   boolean add=true;//control the while loop.
	   boolean done=false;
	   boolean duplicate=false;
	   /**prompt the user to enter ID.If it is not a long type, the user will be required to 
		 * enter another ID until the correct type will be entered.If the ID exist in the file,
		 * prompt the users to enter another one until a different ID is entered.
		 */
	   while(add)
	   {
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter ID:");
		        id=keyboard.nextLong();
		        if(ft_id.contains(id)==true)
		      	   duplicate=true;
	            while(duplicate)
	            {
	        	    duplicate=false;
	        	    System.out.println("The ID you entered exiested in the original file,please enter another one:");
	        	    id=keyboard.nextLong();
	        	    if(ft_id.contains(id)==true)
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
	      done=false;//set the done=false again, so that it can be used in the following codes.
	      
	      keyboard.nextLine();//clean the line.
	      System.out.println("Please enter first name:");
	      firstname=keyboard.nextLine();//prompt the user to enter first name.
	      System.out.println("Please enter family name:");
	      familyname=keyboard.nextLine();//prompt the user to enter family name.
	      System.out.println("Please enter city name:");
	      cityname=keyboard.nextLine();//prompt the user to enter city name.
	      boolean yearBound=false;
	      /**prompt the user to enter hired year.If it is not an int type, the user will be required to 
			 * enter another hired year until the correct type will be entered.
			 */
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter hired year:");
	    	    hireyear=keyboard.nextInt();
	    	    /**if the years the user entered is not valid, the following while loop 
			      * will be executed until valid year will be entered.
			      */
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
	      /**prompt the user to enter salary.If it is not an double type, the user will be required to 
			* enter another salary until the correct type will be entered.
			*/
	      boolean salaryBound=false;
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter salary:");
	    	    money=keyboard.nextDouble();
	    	    /**if the salary the user entered is not valid, the following while loop 
			      * will be executed until valid salary will be entered.
			      */
		        if(money>2000000||money<0)
		        	salaryBound=true;
	            while(salaryBound)
	            {
	            	salaryBound=false;
	        	    System.out.println("The salary you entered is unreasonable,please enter another one:");
	        	    money=keyboard.nextDouble();
	        	    if(money>2000000||money<0)
			        	salaryBound=true;
	            }
	            done=true;
	         }
	         catch(InputMismatchException e)
	         {
	            keyboard.nextLine();
	    	    System.out.println("This is not a correct type.Please enter a double type hired year:");
	         }
	      }
	      done=false;
	      /**create a new object which includes all the attributes the users entered 
			*/
	      FullTimeFaculty addItems=new FullTimeFaculty(id,firstname,familyname,cityname,hireyear,money);
	      /**add the new object the users entered to the ArrayList. 
			*/
		  ft.add(addItems);
		  /**add the new ID the users entered to the ArrayList. 
			*/
		  ft_id.add(addItems.getId());
		  /**ask the users if continue to add,enter -1 to end adding,otherwise continue to add.
			*/
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
				      inputFile.close();
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
	   inputFile.close();	
   }
   /**this method is to write all the information in the ArrayList into the txt file.
    */
   public void storeInText(PrintWriter outputFile)
   {
	   Object[] arr=ft.toArray();
	   for(int i=0;i<arr.length;i++)	   
		   outputFile.printf("%-10d%-10s%-15s%-15s%-10d%-10.2f%n",((FullTimeFaculty) arr[i]).getId(),((FullTimeFaculty) arr[i]).getFirstName(),((FullTimeFaculty) arr[i]).getFamilyName(),((FullTimeFaculty) arr[i]).getCity(),((FullTimeFaculty) arr[i]).getHireYear(),((FullTimeFaculty) arr[i]).salary); 
	   outputFile.close();
   }  
}
