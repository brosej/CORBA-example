package CalcApp;

/**
* CalcApp/CalcInterfaceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcInterface.idl
* jueves 12 de abril de 2018 14H39' VET
*/

public final class CalcInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public CalcApp.CalcInterface value = null;

  public CalcInterfaceHolder ()
  {
  }

  public CalcInterfaceHolder (CalcApp.CalcInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalcApp.CalcInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalcApp.CalcInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalcApp.CalcInterfaceHelper.type ();
  }

}
