package calcServer;

import CalcApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class StartServer {
	
	  public static void main(String args[]) {
		    try{
		      ORB orb = ORB.init(args, null);      
		      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		      rootpoa.the_POAManager().activate();
		 
		      CalcImpl calcimpl = new CalcImpl();
		      calcimpl.setORB(orb); 
		 
		      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calcimpl);
		      CalcInterface href = CalcInterfaceHelper.narrow(ref);
		 
		      org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
		      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		 
		      NameComponent path[] = ncRef.to_name( "CalcOperations" );
		      ncRef.rebind(path, href);
		 
		      System.out.println("Calculator Server ready ...");
		 
			  orb.run();
		      
		    } 
		 
		      catch (Exception e) {
		        System.err.println("ERROR: " + e);
		        e.printStackTrace(System.out);
		      }
		 
		      System.out.println("Calculator Server Exiting ...");
		 
		  }

}
