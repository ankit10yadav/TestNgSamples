package TestNg.TestNgSample;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class App 
{
	public Integer av=1;
	public Integer re;
	
	@BeforeSuite
    public void test1()
    {
    	System.out.println("1");
    	
    }
	@BeforeTest
    public void test2()
    {
    	System.out.println("2");
    	Second a=new Second();

		re=a.test3(av);
    	System.out.println("Result: "+re);
    }
	@BeforeClass
	public void test4()
    {
    	System.out.println("4");
    }
	//@BeforeMethod
	@Test
	public void test5()
    {
    	System.out.println("5");
    }
	@Test(description="Test6Description")
	@Parameters({"QA"})
	public void test6(String QA)
    {
		System.out.println(QA);
    	System.out.println("6");
    	Assert.assertNotNull(QA, "Env is  ot assigned");
    }
	@Test(dataProvider="GetUserData")
	public void test7(String Name, String Address)
    {
    	System.out.println("7");
    	System.out.println("Name= "+Name);
    	System.out.println("Address= "+Address);
    	System.out.println("testing");
    }
	@DataProvider
	public Iterator<String[]> GetUserData()
	{
		ArrayList<String[]> al= new ArrayList<String[]>();
		al=GetDataFromExcel.getdata();
		return al.iterator();
		
	}
	
	
}
