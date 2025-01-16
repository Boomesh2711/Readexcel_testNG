package DataDriven;

import LoginTestCases.Pom;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class readExcel {
    List<String> Username=new ArrayList<String>() ;
    List<String> Password=new ArrayList<String>() ;
    public void readExcel1() throws IOException {
        FileInputStream excel=new FileInputStream       // reading the excel file
                ("D:\\Workspace\\DemoProject\\TestData.xlsx");
        Workbook wb=new XSSFWorkbook(excel);

        Sheet sheet=wb.getSheet("Sheet1");          // getting the sheet from the workbook
        Iterator<Row> RowIterator = sheet.iterator();     // iterating the rows

        while(RowIterator.hasNext()){                    // iterating the rows
          Row rowvalue=  RowIterator.next();            // getting the row
           Iterator<Cell> columnIterator= rowvalue.iterator();      // getting the column
        int i=2;
            while (columnIterator.hasNext()){
            if(i%2==0){
                Username.add(columnIterator.next().getStringCellValue());  // iterating the column
            }else {
                Password.add (columnIterator.next().getStringCellValue());
            }
            i++;
            }
        }
    }

public void login(String uName, String pass){
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().timeouts().implicitlyWait(15, java.util.concurrent.TimeUnit.SECONDS);
    Pom.UserName(driver).sendKeys(uName);
    Pom.Password(driver).sendKeys(pass);
    Pom.LoginButton(driver).click();
    driver.quit();
}
public void Execute(){
        for( int i=0;i<Username.size();i++){
            login(Username.get(i),Password.get(i));
            //System.out.println(Username.get(i));
        }
}

    public static void main(String[] args) throws IOException {
        readExcel UsingPoi=new readExcel();
        UsingPoi.readExcel1();
        UsingPoi.Execute();
System.out.println(UsingPoi.Username);
System.out.println(UsingPoi.Password);
    }
}
