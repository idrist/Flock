package com.utilities;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class SeleniumListener implements ITestListener, ISuiteListener, IInvokedMethodListener {
	
	ScreenShots ss = new ScreenShots();
	// Belongs to ISuiteListener - it executes before Suite start
		public void onStart(ISuite arg0) {
			Reporter.log("Starting the Suite (onStart Suite): " + arg0.getName(), true);
		}

		// Belongs to ISuiteListener - it executes once the Suite is finished
		public void onFinish(ISuite arg0) {
			Reporter.log("Completed the Suite (onFinish Suite): " + arg0.getName(), true);
		}

		// Belongs to ITestListener - it executes before starting of set of Tests
		public void onStart(ITestContext arg0) {
			Reporter.log("Starting <test> tag with name(onStart Test): " + arg0.getName(), true);
			ITestNGMethod methods[] = arg0.getAllTestMethods();
			Reporter.log("The following methods from the <test> tag will be executed: ");
			for (ITestNGMethod method : methods) {
				Reporter.log(method.getMethodName(), true);
			}
		}

		// Belongs to ITestListener - it executes once set of Tests is finished
		public void onFinish(ITestContext arg0) {
			Reporter.log("Completed the Suite (onFinish Test): " + arg0.getName(), true);
		}

		// Belongs to ITestListener - it executes only when the test is pass
		public void onTestSuccess(ITestResult arg0) {
			// This is calling the printTestResults method
			Reporter.log("Successful Test (onTestSuccess): " + arg0.getName(), true);
			/*Object currentClass = arg0.getInstance();
	        WebDriver driver = ((SignIn.FlockSignInDetailed)currentClass).getDriver();

			try {
				ss.takeScreenShot(driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
			printTestResults(arg0);*/
		}

		// Belongs to ITestListener - it executes only when the test fail
		// (@Test)
		public void onTestFailure(ITestResult arg0) {
			// This is calling the printTestResults method
			Reporter.log("Failed Test (onTestFailure): " + arg0.getName(), true);
			/*Object currentClass = arg0.getInstance();
	        WebDriver driver = ((SignIn.FlockSignInDetailed)currentClass).getDriver();
	        
			try {
				ss.takeScreenShot(driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
			printTestResults(arg0);*/
		}

		// Belongs to ITestListener - it executes before the test (@Test) start
		public void onTestStart(ITestResult arg0) {
			Reporter.log("Starting Test (onTestStart): " + arg0.getName(), true);
			//System.out.println("onTestStart - The execution of the main test starts now");
		}

		// Belongs to ITestListener - it executes only if test (@Test) is skipped
		public void onTestSkipped(ITestResult arg0) {
			Reporter.log("Skipped Test (onTestSkipped): " + arg0.getName(), true);
		}

		// This is the method which will be executed in case of test pass or fail
		// This will provide the information on the test
		private void printTestResults(ITestResult result) {
			Reporter.log("Test Method resides in "
					+ result.getTestClass().getName(), true);

			String status = null;
			switch (result.getStatus()) {
			case ITestResult.SUCCESS:
				status = "Pass";
				break;
			case ITestResult.FAILURE:
				status = "Failed";
				break;
			case ITestResult.SKIP:
				status = "Skipped";
			}
			Reporter.log("Test Status: " + status, true);
		}

		// Belongs to IInvokedMethodListener - it executes before every
		// method including @Before @After @Test
		public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
			String textMsg = "About to begin executing following method (beforeInvocation): " + arg1.getTestClass().getName() + " => " + arg0.getTestMethod().getMethodName();
			Reporter.log(textMsg, true);
		}

		// Belongs to IInvokedMethodListener - it executes after every
		// method including @Before @After @Test
		public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
			String textMsg = "Finished executing the following method (afterInvocation): " + arg1.getTestClass().getName() + " => " + arg0.getTestMethod().getMethodName();
			Reporter.log(textMsg, true);
		}

		// This will return method names to the calling function
		private String returnMethodName(ITestNGMethod method) {
			return method.getRealClass().getSimpleName() + "."
					+ method.getMethodName();
		}
		// Ignore this
		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		}
}
