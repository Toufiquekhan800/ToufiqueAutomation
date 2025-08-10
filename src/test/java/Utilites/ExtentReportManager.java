package Utilites;

import TestCase.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

import org.testng.ITestListener;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExtentReportManager implements ITestListener {


    public ExtentSparkReporter SparkReporter;
    public ExtentReports Extent;
    public ExtentTest Test;
    String repname;

public void onStart(ITestContext context){

    String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    repname= "Test-Report-"+timestamp+ ".html";


    SparkReporter =new ExtentSparkReporter(".\\reports\\" + repname);
    SparkReporter.config().setDocumentTitle("Ecommerce Automation Report");
    SparkReporter.config().setReportName("Ecommerce Funtional Testing");
    SparkReporter.config().setTheme(Theme.DARK);

    Extent = new ExtentReports();
    Extent.attachReporter(SparkReporter);
    Extent.setSystemInfo("Application", "Ecommerce Site");
    Extent.setSystemInfo("User Name", System.getProperty("user.name"));
    Extent.setSystemInfo("Environment" , "QA");

    String os =context.getCurrentXmlTest().getParameter("os");
    Extent.setSystemInfo("Operating System", os);

    String browser = context.getCurrentXmlTest().getParameter("browser");
    Extent.setSystemInfo("Browser", browser);


    List<String> includeGroup = context.getCurrentXmlTest().getIncludedGroups();
    if (!includeGroup.isEmpty()) {
        Extent.setSystemInfo("Group", String.valueOf(includeGroup));
    }
}


public void onTestSuccess(ITestResult result){
    Test = Extent.createTest(result.getTestClass().getName());
    Test.assignCategory(result.getMethod().getGroups());
    Test.log(Status.PASS, result.getName() + "got excecute the Test");
}


public void onTestFailure(ITestResult result){
    Test = Extent.createTest(result.getTestClass().getName());
    Test.assignCategory(result.getMethod().getGroups());
    Test.log(Status.FAIL, result.getName() + "got fail the Test");
    Test.log(Status.FAIL, result.getThrowable().getMessage());

    try {
        String imgpath = new BaseClass().captureScreenShoot(result.getName());
        Test.addScreenCaptureFromPath(imgpath);
    }
    catch (Exception e){
        e.printStackTrace();
    }

}


public void onFinish(ITestContext testContext){
    Extent.flush();
    String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repname;
    File extentreport = new File(pathOfExtentReport);

    try {
        Desktop.getDesktop().browse(extentreport.toURI());
    }
    catch (Exception e1){
        e1.printStackTrace();
    }
}

}
