package POM;
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminPage;

public class TestAdmin {

    public static void main(String[] args) {
        // Set up the WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();
        
        // Open the OrangeHRM Admin page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        // Create an instance of the AdminPage object
        AdminPage adminPage = new AdminPage(driver);

        // Perform a search action on the Admin page
        adminPage.enterUsernameForSearch("Admin");
        adminPage.selectRole("Admin"); // Example: Select Admin role
        adminPage.selectStatus("Enabled"); // Example: Select Enabled status
        adminPage.clickSearchButton(); // Click the search button to apply filters

        // Optionally, you can also add a new user (this part can be expanded with additional methods)
        adminPage.clickAddButton(); // Click the 'Add' button to add a new user

        // Additional steps, like interacting with the "Add User" form, can be written here

        // Close the browser
        driver.quit();
    }
}

