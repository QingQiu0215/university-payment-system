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
public class TA extends Employee
{
   private String classification;
   private int classes;
   private int totalHours;
   private static int size=0;
   private ArrayList<TA> ta;
   private ArrayList<Long> ta_id;
   
   public TA()
   {
	   super();
	   classification=null;
	   classes=0;
	   totalHours=0;
   }
   public TA(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,String newclassification,int newclasses,int newtotalHours)
   {
	   super(newId,newFirstName,newFamilyName,newCity,newHireYear);
	   classification=newclassification;
	   classes=newclasses;
	   totalHours=newtotalHours;
   }
   public String getClassification()
   {
	   return classification;
   }
   public void setClassification(String newClassification)
   {
	   classification=newClassification;
   }
   public int getClasses()
   {
	   return classes;
   }
   public void setClasses(int newClasses)
   {
	   classes=newClasses;
   }
   public int getTotalHours()
   {
	   return totalHours;
   }
   public void setTotalHours(int newTotalHours)
   {
	   totalHours=newTotalHours;
   }
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
   public void fillInArrayList(Scanner inputFile)
   {
	   ta=new ArrayList<TA>();
	   ta_id=new ArrayList<Long>();
	   for(int i=0;i<size;i++)
	   {
		   TA assistant=new TA(inputFile.nextLong(),inputFile.next(),inputFile.next(),inputFile.next(),inputFile.nextInt(),inputFile.next(),inputFile.nextInt(),inputFile.nextInt());;
		   ta.add(assistant);
		   ta_id.add(assistant.getId());
	   }	
	   inputFile.close();
   }   
   public void addTARecords(Scanner inputFile)
   {
	   fillInArrayList(inputFile);
	   System.out.println("Please add information of teaching assistants.");
	   Scanner keyboard=new Scanner(System.in);
	   long id=0;
	   String fisrname=null;
	   String familyname=null;
	   String cityname=null;
	   int hireyear=0;
	   String types=null;	   
	   int courses=0;
	   int allhours=0;	   
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
		        if(ta_id.contains(id)==true)
		      	   duplicate=true;
	            while(duplicate)
	            {
	        	    duplicate=false;
	        	    System.out.println("The ID you entered exiested in the original file,please enter another one:");
	        	    id=keyboard.nextLong();
	        	    if(ta_id.contains(id)==true)
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
	      keyboard.nextLine();
	      System.out.println("Please enter classification:");
	      types=keyboard.nextLine();	      
	      boolean coursesBound=false;
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter courses:");
	    	    courses=keyboard.nextInt();
		        if(courses>100||courses<0)
		        	coursesBound=true;
	            while(coursesBound)
	            {
	            	coursesBound=false;
	        	    System.out.println("The courses you entered is unreasonable,please enter another one:");
	        	    courses=keyboard.nextInt();
	        	    if(courses>100||courses<0)
			        	coursesBound=true;
	            }
	            done=true;
	         }
	         catch(InputMismatchException e)
	         {
	        	 keyboard.nextLine();
	    	    System.out.println("This is not a correct type.Please enter a int type courses:");
	         }
	      }
	      done=false;
	      boolean hrsBound=false;
	      while(!done)
	      {
	         try
	         {
	    	    System.out.println("Please enter hours:");
	    	    allhours=keyboard.nextInt();
		        if(allhours>8760||allhours<0)
		        	hrsBound=true;
	            while(yearBound)
	            {
	            	hrsBound=false;
	        	    System.out.println("The hours you entered is unreasonable,please enter another one:");
	        	    allhours=keyboard.nextInt();
	        	    if(allhours>8760||allhours<0)
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
	      TA addItems=new TA(id,fisrname,familyname,cityname,hireyear,types,courses,allhours);;
		  ta.add(addItems);
		  ta_id.add(addItems.getId());	      
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
	   }
   }
   public void storeInText(PrintWriter outputFile)
   {
	   Object[] arr=ta.toArray();
	   for(int i=0;i<arr.length;i++)	   
		   outputFile.printf("%-10d%-10s%-15s%-15s%-10d%-10s%-10d%-10d%n",((TA) arr[i]).getId(),((TA) arr[i]).getFirstName(),((TA) arr[i]).getFamilyName(),((TA) arr[i]).getCity(),((TA) arr[i]).getHireYear(),((TA) arr[i]).classification,((TA) arr[i]).classes,((TA) arr[i]).totalHours); 
	   outputFile.close();
   }
}
