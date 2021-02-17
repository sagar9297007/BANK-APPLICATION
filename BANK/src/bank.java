/*userId:-USER
  password:-USER*/

import java.util.*;
import java.io.*;
class clear
{
 void clsc()
 {
	try
	{	
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
	}
	catch(Exception E)
	{
		System.out.println(E);
	}
 }
}
class banker
{
	String bankName= "AAA bank";
	String cusId;
	String ifsc;
	private float balance;
	String uniqueCode;
	static LinkedList<String> data = new  LinkedList<String>();
	Scanner scan = new Scanner(System.in);

	String CID()
	{
		System.out.println("ENTER IFSC CODE:- ");
		ifsc= scan.nextLine();
		Random n = new Random();
		uniqueCode=String.valueOf(n.nextInt(50000));
		cusId = bankName.substring(0,3)+'-'+ifsc+'-'+uniqueCode;
		System.out.println("ID details saved as "+" : "+cusId);
		return cusId;
	}

	String details()
	{
		System.out.println("enter costumer name:- ");
		String name = scan.nextLine();
		System.out.println("enter balance:- ");
		balance = scan.nextFloat();
		String bal =Float.toString(balance);
		String cdetails = name+" "+cusId+" "+bal;
		System.out.println("details saved as "+" : "+cdetails);
		return cdetails;
	}
    void saveData(String g)
	{
		String h=g;
		data.add(h);
	}
	int search()
	{   
		int feedback=0;
		System.out.println("enter details to search");
		String search = scan.next();
		for (int ii=0;ii<data.size();ii++)
		{
			String temp=data.get(ii);

			if(temp.contains(search)==true)
			{
				System.out.println("data found"+"\n"+temp);
				feedback++;
			}

		}
			return feedback;

	}

	void viewAll()
	{
		for(String s:data)
		{
		  System.out.println(s);
		}
	}
}
class bank extends banker
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("enter the userId : ");
		String user = scan.next();
		System.out.print("enter the password : ");
		String password = scan.next();
		clear c = new clear();
		if(user.equals("USER")&&password.equals("USER"))
		{
		System.out.println("Sucessfuly logged in"+"\n"+"\n");

		banker b =new banker();
		int i=0;
		do
		{
			System.out.println("press 1 to create details "+"\n"+"press 2 to search details"+"\n"+"press 3 to view all details"+"\n"+"press 4 to exil");
			i = scan.nextInt();
		
		//-------------------------------------------------------------------------------

		if(i==1)
		{
			c.clsc();
			b.CID();
			String s=b.details();
			b.saveData(s);
		
			System.out.println("saving......");
			try
			{
			Thread.sleep(4000);
			}
			catch (Exception e)
			{
			}
			c.clsc();
			System.out.println("data saved");
		}

		//------------------------------------------------------------------------
		if(i==2)
		{
			c.clsc();
			int fb=b.search();
			if (fb==0)
			{
				System.out.println("no data found");
			}
		}
		//------------------------------------------------------------------------------
		if(i==3)
		{
			c.clsc();
			b.viewAll();
		}
		//-----------------------------------------------------------------------------
		if(i!=1&&i!=2&&i!=3&&i!=4)
		{
			c.clsc();
			System.out.println("invalid input");
		}

		}while (i!=4);

		System.out.println("sucesfuly logged out");
	}
    else
	{
		System.out.println("wrong pasword and userId");
	}
  }
}