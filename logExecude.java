package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class logExecude{

    public static void main(String[] args) {
        // Setup the WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();
        
        // Open the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Create an instance of the LoginPage object
        logExecude loginPage = new logExecude(driver);

        // Perform login actions
        loginpage.enterUsername("Admin");
        loginpage.enterPassword("admin123");
        loginpage.clickLogin();

        // Add assertions here to verify successful login (optional)

     }
}

