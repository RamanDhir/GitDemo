package UI_auto;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{
    Base b=new Base();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		b.getMethodStartStatus(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		b.getMethodFinishStatus(result.getName());
	}

	public void onTestFailure(ITestResult result) {
     
	try {
		b.getScreenshot(result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
//	System.out.println("Test case:"+result.getName()+" :FAILED");	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
