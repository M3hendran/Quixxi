package quixxiversion3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.ITestAnnotation;

public class AfterClassExecution extends TestListenerAdapter implements IRetryAnalyzer, IAnnotationTransformer {
	
	int counter=0;
	int retrycount=2;
	
	@OverridingMethodsMustInvokeSuper
	public boolean retry(ITestResult result) {
		
		// TODO Auto-generated method stub
		
		if(counter < retrycount)
		{
			
			System.out.println("Executing "+ counter);
			
			counter++;
			return true;
		}
		
		return false;
	}


	@OverridingMethodsMustInvokeSuper
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		
		annotation.setRetryAnalyzer(AfterClassExecution.class);
		
	}
	
	@Override
	public void onTestFailure(ITestResult tr){
		
		System.out.println(tr.getName()+new StringBuffer().append(" Method Failed"));
		
	}

	@Override
	public void onTestSkipped(ITestResult tr){
		
		System.out.println(tr.getName()+new StringBuffer().append(" Method Skipped"));
	}
	
	public void onTestSuccess(ITestResult tr){
		
		System.out.println(tr.getName()+new StringBuffer().append(" Method Passed"));
	}
}
