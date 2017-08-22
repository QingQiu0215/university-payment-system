import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
/**will create  several linked list as following:
 */
public class List 
{
  /**the node for part time faculty
   */
  private class Node1
  {	  
	  private long Id;
	  private String FirstName;
	  private String FamilyName;
	  private String city;
	  private int HireYear;
	  private double HourlyRate;
	  private int hours;
	  private int studentNum;
	  private Node1 link;	
      public Node1()
      {
    	  Id=0;
  		  FirstName=null;
  		  FamilyName=null;
  		  city=null;
  		  HireYear=1980;
  		  HourlyRate=0;
 	      hours=0;
 	      studentNum=0;
    	  link=null;
      }      
  	  public Node1(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newHourlyRate,int newhours,int newstudentNum,Node1 linkValue)
      {
  		  Id=newId;
		  FirstName=newFirstName;
		  FamilyName=newFamilyName;
		  city=newCity;
		  HireYear=newHireYear;
		  HourlyRate=newHourlyRate;
	      hours=newhours;
	      studentNum=newstudentNum;
    	  link=linkValue;
      }
  }
  /**the node for teaching assistant.
   */
  private class Node2
  {	  
	  private long Id;
	  private String FirstName;
	  private String FamilyName;
	  private String city;
	  private int HireYear;
	  private String classification;
	  private int classes;
	  private int totalHours;
	  private Node2 link;	
      public Node2()
      {
    	  Id=0;
  		  FirstName=null;
  		  FamilyName=null;
  		  city=null;
  		  HireYear=1980;
  		  classification=null;
  		  classes=0;
  		  totalHours=0;
    	  link=null;
      }      
  	  public Node2(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,String newclassification,int newclasses,int newtotalHours,Node2 linkValue)
      {
  		  Id=newId;
		  FirstName=newFirstName;
		  FamilyName=newFamilyName;
		  city=newCity;
		  HireYear=newHireYear;
		  classification=newclassification;
  		  classes=newclasses;
  		  totalHours=newtotalHours;
    	  link=linkValue;
      }
  }
  /**the node for full time faculty
   */
  private class Node3
  {	  
	  private long Id;
	  private String FirstName;
	  private String FamilyName;
	  private String city;
	  private int HireYear;
	  private double money;
	  private Node3 link;	
      public Node3()
      {
    	  Id=0;
  		  FirstName=null;
  		  FamilyName=null;
  		  city=null;
  		  HireYear=1980;
          money=0;
    	  link=null;
      }      
  	  public Node3(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newmoney,Node3 linkValue)
      {
  		  Id=newId;
		  FirstName=newFirstName;
		  FamilyName=newFamilyName;
		  city=newCity;
		  HireYear=newHireYear;
		  money=newmoney;
    	  link=linkValue;
      }
  }
  /**the node for staff.
   */
  private class Node4
  {	  
	  private long Id;
	  private String FirstName;
	  private String FamilyName;
	  private String city;
	  private int HireYear;
	  private double wage;
	  private String code;
	  private Node4 link;	
      public Node4()
      {
    	  Id=0;
  		  FirstName=null;
  		  FamilyName=null;
  		  city=null;
  		  HireYear=1980;
          wage=0;
          code=null;
    	  link=null;
      }      
  	  public Node4(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newwage,String newcode,Node4 linkValue)
      {
  		  Id=newId;
		  FirstName=newFirstName;
		  FamilyName=newFamilyName;
		  city=newCity;
		  HireYear=newHireYear;
		  wage=newwage;
		  code=newcode;
    	  link=linkValue;
      }
  }
  /**declare some pointers.
   */
  private Node1 head1;
  private Node2 head2;
  private Node3 head3;
  private Node4 head4;
  private Node4 tail;
  /**declare sizes and initialize them to indicate the number of 
   * lines of records accordingly.
   */
  private int size1=0;
  private int size2=0;
  private int size3=0;
  private int size4=0;
  private final static double RATE=18.25;
  public List()
  {
	  head1=null;
	  head2=null;
	  head3=null;
	  head4=null;
	  tail=null;
  }
  /**get the lines of Part-Time-Faculty.txt.
	 */
  public void getArraySize1(Scanner inputFile)
  {	  
	  String line=null;
	  while(inputFile.hasNextLine())
	  {	      
	    line=inputFile.nextLine();
	    size1++;
	  }
      inputFile.close();	  
  }
  /**get the lines of TAs.txt.
	 */
  public void getArraySize2(Scanner inputFile)
  {	  
	  String line=null;
	  while(inputFile.hasNextLine())
	  {	      
	    line=inputFile.nextLine();
	    size2++;
	  }
      inputFile.close();	  
  }
  /**get the lines of Full-Time-Faculty.txt.
 	 */
  public void getArraySize3(Scanner inputFile)
  {	  
	  String line=null;
	  while(inputFile.hasNextLine())
	  {	      
	    line=inputFile.nextLine();
	    size3++;
	  }
      inputFile.close();	  
  }
  /**get the lines of Staff.txt.
	 */
  public void getArraySize4(Scanner inputFile)
  {	  
	  String line=null;
	  while(inputFile.hasNextLine())
	  {	      
	    line=inputFile.nextLine();
	    size4++;
	  }
      inputFile.close();	  
  }
  /**add each node to the beginning of the file accordingly.
   */
  private void addToStart1(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newHourlyRate,int newhours,int newstudentNum)
  {
	  head1=new Node1(newId,newFirstName,newFamilyName,newCity,newHireYear,newHourlyRate,newhours,newstudentNum,head1);
  }
  private void addToStart2(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,String newclassification,int newclasses,int newtotalHours)
  {
	  head2=new Node2(newId,newFirstName,newFamilyName,newCity,newHireYear,newclassification,newclasses,newtotalHours,head2);
  }
  private void addToStart3(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newmoney)
  {
	  head3=new Node3(newId,newFirstName,newFamilyName,newCity,newHireYear,newmoney,head3);
  }
  /**add each node to the end of the Staff.txt.
   */
  private void addToEnd(long newId,String newFirstName,String newFamilyName,String newCity,int newHireYear,double newwage,String newcode)
  {	  
	  Node4 newEntry=new Node4(newId,newFirstName,newFamilyName,newCity,newHireYear,newwage,newcode,null);
	  if(head4==null)
	  {
		  tail=newEntry;
		  head4=tail;
	  }
	  else 
	  {
		  tail.link=newEntry;
		  tail=tail.link;
	  }	  
  }
  /**find all the total salary of part time faculty and teaching assistant and calculate the total salary.
   */
  public void findTermSalary(Scanner inputFile1,Scanner inputFile2)
  {
	  /**the for loop is to add all items of part time faculty into linked list.
	   */
	  for(int i=0;i<size1;i++)
	  {
		  addToStart1(inputFile1.nextLong(),inputFile1.next(),inputFile1.next(),inputFile1.next(),inputFile1.nextInt(),inputFile1.nextDouble(),inputFile1.nextInt(),inputFile1.nextInt());
	  }
	  Node1 position1=head1;
	  double total1=0;
	  /**as per requirement, add some extra money into the total salary.
	   */
	  while(position1!=null)
	  {
		  if(position1.studentNum<40)
		      total1+=position1.hours*position1.HourlyRate;
		  else if(position1.studentNum<=60&&position1.studentNum>=40)
			  total1+=position1.hours*position1.HourlyRate+500;  
		  else
			  total1+=position1.hours*position1.HourlyRate+1000;
		  position1=position1.link;
	  }
	  /**the for loop is to add all items of teaching assistant into linked list.
	   */
	  for(int i=0;i<size2;i++)
	  {
		  addToStart2(inputFile2.nextLong(),inputFile2.next(),inputFile2.next(),inputFile2.next(),inputFile2.nextInt(),inputFile2.next(),inputFile2.nextInt(),inputFile2.nextInt());
	  }
	  Node2 position2=head2;
	  double total2=0;
	  while(position2!=null)
	  {
		  if(position2.classification.equals("UGrad"))
		      total2+=position2.totalHours*RATE;
		  else if(position2.classification.equals("Grad"))
			  total2+=position2.totalHours*RATE*1.2;  		  
		  position2=position2.link;
	  }
	  /**output the combined total salary of part-time faculty and TAs.
	   */
	  System.out.println("The total salary of part-time faculty is(4 month):"+(total1+total2));
	  inputFile1.close();
	  inputFile2.close();
  }
  /**finds the highest and lowest salary for any full-time faculty.
   */
  public void findHighest_and_FT_Salary(Scanner inputF)
  {
	  for(int i=0;i<size3;i++)
	  {
		  addToStart3(inputF.nextLong(),inputF.next(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextDouble());
	  }
	  //declare some pointers and initialize them to head3,null.
	  Node3 position3=head3;
	  Node3 position4=head3;
	  Node3 position5=head3;
	  Node3 position6=head3;
	  double max=position3.money;
	  double min=position3.money;
	  //find the max value of salary in the linked list.
	  while(position3!=null)
	  {
		 if(position3.money>max) 
			 max=position3.money;
		 position3=position3.link;
	  }
	  //find the min value of salary in the linked list.
	  while(position4!=null)
	  {
		 if(position4.money<min) 
			 min=position4.money;
		 position4=position4.link;
	  }
	  System.out.println("These employees have highest salary:");
	  //output all the max value of salary in the linked list.
	  while(position5!=null)
	  {
		 if(position5.money==max) 
			 System.out.printf("%-10d%-10s%-15s%-15s%-10d%-10.2f%n",position5.Id,position5.FirstName,position5.FamilyName,position5.city,position5.HireYear,position5.money);
		 position5=position5.link;
	  }
	  System.out.println("These employees have lowest salary:");
	  //output all the min value of salary in the linked list.
	  while(position6!=null)
	  {
		 if(position6.money==min) 
			 System.out.printf("%-10d%-10s%-15s%-15s%-10d%-10f.2%n",position6.Id,position6.FirstName,position6.FamilyName,position6.city,position6.HireYear,position6.money);
		 position6=position6.link;
	  }
	  inputF.close();
  }
  /**This method increases the salary as per its evaluation code.
   */
  public void Increase_Staff_Salary(Scanner inputF)
  {
	  /**the for loop is to add all items of staff into linked list.
	   */
	  for(int i=0;i<size4;i++)
	  {
		  addToEnd(inputF.nextLong(),inputF.next(),inputF.next(),inputF.next(),inputF.nextInt(),inputF.nextDouble(),inputF.next());
	  }
	  Node4 position=head4;
	  while(position!=null)
	  {
		  //use switch to change the salary and code to "E".
		  switch(position.code)
		  {
		    case "A": position.wage*=1.08;position.code="E";break;
		    case "B": position.wage*=1.06;position.code="E";break;
		    case "C": position.wage*=1.03;position.code="E";break;
		    case "D": position.wage*=1.01;position.code="E";break;
		    case "E": position.wage*=1;break;
	        default:position.wage=0;break;
		  }
		  position=position.link;
	  }
	  inputF.close();
  }
  /**this method is to write all the information in the linked list into the Staff.txt file.
   */
  public void output(PrintWriter pw)
  {
	  Node4 position=head4;
	  while(position!=null)
	  {
		  pw.printf("%-10d%-10s%-15s%-15s%-10d%-10.2f%-10s%n",position.Id,position.FirstName,position.FamilyName,position.city,position.HireYear,position.wage,position.code);
		  position=position.link;
	  }
	  pw.close(); 
  }
}
