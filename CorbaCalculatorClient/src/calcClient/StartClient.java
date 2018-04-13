package calcClient;

import CalcApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.Scanner;
import java.lang.*; 

public class StartClient {
	
	  static CalcInterface CalcImpl;
	  static int flag=1;
	  static double x=0.0d;
	  static double y=0.0d;
	  
	  public static void main(String args[])
	   {
	        
	    try{
	                System.out.println("\n----------------------------------");
                 	System.out.println("Buscando servidor...");
	           
	                ORB orb = ORB.init(args, null);

	                org.omg.CORBA.Object objRef = 
	                orb.resolve_initial_references("NameService");

	                NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

	                String name = "CalcOperations";
	                CalcImpl = CalcInterfaceHelper.narrow(ncRef.resolve_str(name));

					System.out.print("Server encontrado: \n\n");

	                Scanner sc=new Scanner(System.in);
	      
	                flag=1;

	                do
	                {

	                System.out.print("\nIngrese el primer numero: ");
	                x=sc.nextDouble();

	                System.out.print("\nIngrese el segundo numero: ");
	                y=sc.nextDouble();
	                System.out.println("--------------------------------------------------");
	                System.out.println("\nSuma\t= "+CalcImpl.add(x,y));
	                System.out.println("\nResta\t= "+CalcImpl.subtract(x,y));
	                System.out.println("\nMultiplicacion\t= "+CalcImpl.multiply(x,y));
	                System.out.println("\nDivision\t= "+CalcImpl.divide(x,y));
	                System.out.println("--------------------------------------------------");
	                System.out.println("Desea realizar otro calculo?[1:Yes|0:No]: ");
	                flag=sc.nextInt();
	                }
	                while (flag!=0);

	                CalcImpl.shutdown();
	         }
	            catch (Exception e) 
	            {   
	              
	                 System.out.println("\nError");
	            }

	    	System.out.println("\nSaliendo...");
	        }

}
