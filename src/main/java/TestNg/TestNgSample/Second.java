package TestNg.TestNgSample;

import org.testng.annotations.Test;

public class Second
{
	Integer re=null;
	@Test
	public Integer test3(Integer av)
    {
		re=av;
    	System.out.println("Test3");
    	return re;
    }
}
