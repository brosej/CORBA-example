package calcServer;

import CalcApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class CalcImpl extends CalcInterfacePOA {
	private ORB orb;

    public void setORB(ORB orb_val) 
    {   
        orb = orb_val;
    }

  

    public String add(double x, double y)
    {
        double res= x+y;
        return Double.toString(res);
    }

    public String subtract(double x, double y)
    {
        double res= x-y;
        return Double.toString(res);
    }

    public String multiply(double x, double y)
    {
        double res= x*y;
        return Double.toString(res);
    }

    public String divide(double x, double y)
    {
        double res= x/y;
        return Double.toString(res);
    }
    
    public String random() 
    {
        double res=Math.random();
        return Double.toString(res);
    }

    public void shutdown()
    {
            orb.shutdown(false);
    }

}
