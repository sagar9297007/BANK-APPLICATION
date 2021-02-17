package singlePageApplication;

import java.util.*;

class Clear
{
	void clc()
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
class Print
{
	Clear c = new Clear();
	LinkedList<String> a = new LinkedList<String>();
	LinkedList<String> b = new LinkedList<String>();
	
	Scanner scan = new Scanner(System.in);
	
	int search()
	{
		LinkedList<String> ac = new LinkedList<String>(a);
		LinkedList<String> bc = new LinkedList<String>(b);
		c.clc();
		String TC;
		String DC;
		System.out.println("ENTER THE KEY WORD TO SEARCH");
		String st = scan.nextLine();
		String ct= st.toUpperCase();
		int g=0;
		try
		{


			for(int j=-1;j<=ac.size()+1;j++)
			{
			TC=ac.pop();
			DC=bc.pop();
			if (TC.contains(ct))
			{
				g++;
				System.out.println("POST FOUND"+"\n");
				System.out.println(TC);
				System.out.println(DC+"\n");
			}
			}
			try
			{
			TC=ac.getFirst();
			DC=bc.getFirst();
			if (TC.contains(ct))
			{
				g++;
				System.out.println("POST FOUND");
				System.out.println(TC);
				System.out.println(DC+"\n");
			}
			}
			catch (NoSuchElementException e)
			{
			}
			
		}
		catch (NoSuchElementException e)
		{

		}
		
		return g;
	}
	int display()
	{
		
	
		LinkedList<String> ac = new LinkedList<String>(a);
		LinkedList<String> bc = new LinkedList<String>(b);
		c.clc();
		int q = a.size();
			try
			{
				for (int i=-1;i<=ac.size()+1;i++)
				{
					System.out.println(ac.pop());
					System.out.println(bc.pop());
					System.out.println("\n"+"\n");
				}

				try
				{
					System.out.println(ac.getFirst());
					System.out.println(bc.getFirst());
					System.out.println("\n"+"\n");
				}
				catch (NoSuchElementException e)
				{
				}
			}
			catch (NoSuchElementException e)
			{
			}
	return q;
	}
	void post()
	{
		System.out.println("TITLE :-");
		String t = scan.nextLine();
		a.add(t.toUpperCase());
		System.out.println("\n"+"DESCRIPTION :-");
		String d = scan.nextLine();
		b.add(d);
		c.clc();
		System.out.println("SUCCESSFULLY POSTED ");
	}
}
class Application
{
	public static void main(String[] args)
	{
		Clear c = new Clear();
		Scanner scan = new Scanner(System.in);
		Print p = new Print();
		
		int i=0;
		do
		{	
			System.out.println("1.SEARCH POST"+"\n"+"2.PUBLISHED"+"\n"+"3.NEW POST"+"\n"+"4.EXIT");
			i=scan.nextInt();
			if(i==1) 
			{
				c.clc();
				int g = p.search();
				if(g==0)
				{
					System.out.println("\n"+"NO POST FOUND"+"\n");
				}
				
			}
			if(i==2) 
			{
				c.clc();
				int w = p.display();
				if(w==0)
				{
					System.out.println("\n"+"NO POST FOUND"+"\n");
				}
				
			}
			if(i==3) 
			{
				c.clc();
				p.post();

			}

			if(i!=4&&(i!=1&&i!=2&&i!=3))
			{
				c.clc();
				System.out.println("invalid key"+"\n");
			}
		}while(i!=4);

		c.clc();
	}
}
