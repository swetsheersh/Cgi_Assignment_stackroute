package SeleniumPOM.Assign.PageObjectModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterSuite;

public class FacebookTest {
	WebDriver driver;
	Register reg;
	Login log;
	ForgetPass forPass;
	
  @Test(dataProvider = "dp",priority = 2)
  public void verifyRegister(String fname, String lname,String email,String reemail, String pass,String day,String mon, String year,String gen,String exp) throws Exception {
	  //driver.get("https://www.facebook.com/");
	  //driver.manage().window().maximize();
	  
	  driver.navigate().to("https://www.facebook.com/");
	  
	 // Thread.sleep(3000);
	  //reg=new Register(driver);
	  reg.create();
	  reg.sendfirstName(fname);
	  reg.sendlastName(lname);
	  reg.sendEmail(email);
	  reg.resendEmail(reemail);
	  reg.sendpass(pass);
	  reg.sendday(String.valueOf((int)Double.parseDouble(day)));
	  reg.sendmonth(String.valueOf((int)Double.parseDouble(mon)));
	  reg.sendyear(String.valueOf((int)Double.parseDouble(year)));
	  reg.clickgender(gen);
	  reg.clickSubmit();
	  Thread.sleep(6000);
	  assertEquals(driver.getCurrentUrl().contains("recover"), Boolean.parseBoolean(exp));
	  Thread.sleep(2000);
  }
  @Test(dataProvider = "dp1",priority = 1)
  public void loginTest(String uname,String pass,String exp) throws Exception {
	  driver.navigate().to("https://www.facebook.com/");
	  
	  this.log.sendUserName(uname);
	  this.log.sendPass(pass);
	  this.log.clickLogin();
	  
	  Thread.sleep(4000);
	  
	  assertEquals(this.driver.getPageSource().contains("mind"),Boolean.parseBoolean(exp));
	  
	  Thread.sleep(1000);
	  driver.manage().deleteAllCookies();
	  
  }
  
  @Test(dataProvider = "dp2",priority = 0)
  public void forgetTest(String email,String exp) throws InterruptedException {
	  driver.navigate().to("https://www.facebook.com/");
	  this.forPass.clickFPass();;
	  Thread.sleep(2000);
	  this.forPass.sendEmail(email);
	  this.forPass.clickSearch();
	  Thread.sleep(5000);
	  
	  assertEquals(this.driver.getPageSource().contains("Recover"), Boolean.parseBoolean(exp));
	  driver.manage().deleteAllCookies();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Executing Test...");
	  this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  this.reg=new Register(driver);
	  this.log=new Login(driver);
	  this.forPass=new ForgetPass(driver);
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Register Test...");
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  this.driver=new ChromeDriver(options);
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();
  }
  
  @DataProvider
  public Object[][] dp() throws Exception {
	  FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/fb.xlsx");
  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
  	  XSSFSheet sheet=workbook.getSheetAt(0);
  	  int rowNum=sheet.getLastRowNum();
  	  int colNum=sheet.getRow(0).getLastCellNum();
  	  Object[][] myobj = new Object[rowNum][colNum];
  	  for(int i=1;i<=rowNum;i++) {
  		  XSSFRow row=sheet.getRow(i);
  		  for(int j=0;j<colNum;j++) {
  			  try {
  			  String value=row.getCell(j).toString();
  			  System.out.print(value+" ");
  			  myobj[i-1][j]=value;
  			  }catch(Exception e) {}
  		  }
  		  //row.createCell(colNum).setCellValue("Pass");
  		  
  		  System.out.println("");
  	  }
  	 // OutputStream file1=new FileOutputStream("C:/Users/HARSH/Desktop/Test.xlsx");
  	 // workbook.write(file1);
  	 // file1.close();
    return myobj;
  }
  
  @DataProvider
  public Object[][] dp1() throws Exception {
	  FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/fb.xlsx");
  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
  	  XSSFSheet sheet=workbook.getSheetAt(1);
  	  int rowNum=sheet.getLastRowNum();
  	  int colNum=sheet.getRow(0).getLastCellNum();
  	  Object[][] myobj = new Object[rowNum][colNum];
  	  for(int i=1;i<=rowNum;i++) {
  		  XSSFRow row=sheet.getRow(i);
  		  for(int j=0;j<colNum;j++) {
  			  try {
  			  String value=row.getCell(j).toString();
  			  System.out.print(value+" ");
  			  myobj[i-1][j]=value;
  			  }catch(Exception e) {}
  		  }
  		  //row.createCell(colNum).setCellValue("Pass");
  		  
  		  System.out.println("");
  	  }
  	 // OutputStream file1=new FileOutputStream("C:/Users/HARSH/Desktop/Test.xlsx");
  	 // workbook.write(file1);
  	 // file1.close();
    return myobj;
  }
  
  @DataProvider
  public Object[][] dp2() throws Exception {
	  FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/fb.xlsx");
  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
  	  XSSFSheet sheet=workbook.getSheetAt(2);
  	  int rowNum=sheet.getLastRowNum();
  	  int colNum=sheet.getRow(0).getLastCellNum();
  	  Object[][] myobj = new Object[rowNum][colNum];
  	  for(int i=1;i<=rowNum;i++) {
  		  XSSFRow row=sheet.getRow(i);
  		  for(int j=0;j<colNum;j++) {
  			  try {
  			  String value=row.getCell(j).toString();
  			  System.out.print(value+" ");
  			  myobj[i-1][j]=value;
  			  }catch(Exception e) {}
  		  }
  		  //row.createCell(colNum).setCellValue("Pass");
  		  
  		  System.out.println("");
  	  }
  	 // OutputStream file1=new FileOutputStream("C:/Users/HARSH/Desktop/Test.xlsx");
  	 // workbook.write(file1);
  	 // file1.close();
    return myobj;
  }

  @AfterSuite
  public void afterSuite() {
	  this.driver.quit();
  }

}
