package com.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.Test_Base;

public class Custom_listeners implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println(" On finish>>>");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println(" On Start>>>");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed....");
		Test_Base b = new Test_Base();
		try {
			b.failed(result.getMethod().getMethodName());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println(" On Test Case Skipped>>>");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println(" On Test Case Start>>>");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(" On Test Case Success>>>");
		// TODO Auto-generated method stub
		
	}

}
