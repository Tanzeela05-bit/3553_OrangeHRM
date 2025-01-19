package POM;
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SystemUsersPage {

    WebDriver driver;

    // Locator for the table containing system user links
    By userLinks = By.xpath("//table[@id='tblSystemUsers']//a");

    // Constructor to initialize the WebDriver
    public SystemUsersPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get all the user links
    public List<WebElement> getUserLinks() {
        return driver.findElements(userLinks);
    }

    // Method to check if a specific link is clickable
    public boolean isLinkClickable(WebElement link) {
        return link.isDisplayed() && link.isEnabled();
    }

    // Method to click a specific link
    public void clickLink(WebElement link) {
        if (isLinkClickable(link)) {
            link.click();
        }
    }

    // Method to check all links in the system user table
    public void checkAllUserLinks() {
        List<WebElement> links = getUserLinks();
        for (WebElement link : links) {
            if (isLinkClickable(link)) {
                String linkText = link.getText();
                String linkUrl = link.getAttribute("href");
                System.out.println("Checking link: " + linkText + " (" + linkUrl + ")");
                
                try {
                    // Click the link to verify if it works
                    clickLink(link);
                    System.out.println("Link works successfully: " + linkText);
                    
                    // Optional: Wait for the page to load (if necessary, use WebDriverWait)

                    // Go back to the system users page after clicking the link (optional)
                    driver.navigate().back();
                } catch (Exception e) {
                    System.out.println("Error clicking the link: " + linkText);
                }
            } else {
                System.out.println("Link is not clickable: " + link.getText());
            }
        }
    }
}

