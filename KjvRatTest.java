
import java.util.*;
import java.io.*;

public class KjvRatTest {
	public static void main(String[] args) 
	  {
		KjvRat r1 = new KjvRat(),
		       r2 = new KjvRat(4,2);
		System.out.println(r2.getClass());
		KjvRat r3 = r1.plusTo(r2);
		r3.setNum(7);
		r2.normalize();
		System.out.print(r2);
		System.out.println();
		try
		  {
		   KjvRat r4 = r3.clone();
		   System.out.println("r1="+r1.toString()+"  r3="+r3.toString());
		   System.out.println("r4="+r4.toString());
		   r4.setNum(5);
		   System.out.println("mod r3="+r3.toString());
		   System.out.println("mod r4="+r4.toString());
		   int b = r3.compareTo(r4);
		   System.out.println("b="+b);
		   if (b<0)
			   System.out.println("r3 < r4");
		   else if (b==0)
			   System.out.println("r3 == r4");
		   else
			   System.out.println("r3 > r4");
		   KjvRat r5=null;
		   KjvRat r6 = r3.plus(r4);
		   Stack st = new Stack();
		   if (r3.equals(r6))
			   System.out.println("������� �����");
		   else
			   System.out.println("������� �� �����");
		   r3.setDenom(0);
		  }
		catch (RuntimeException e)
		  { System.out.println(e.getMessage());	
		  }
		catch (FileMyException e)
		  { System.out.println("�� Exception: "+e.getMessage()+ "; "+e.toString() + "; " + e.getClass().getName());

		  }

		catch (IOException e)
		  { System.out.println("��������� Exception: "+e.getMessage()+ "; "+e.toString() + "; " + e.getClass().getName());	
		  }


	  }

}
