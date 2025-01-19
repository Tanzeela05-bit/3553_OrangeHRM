package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CheckClickableLinks {

    public static void main(String[] args) {
        // Setup WebDriver for Chrome
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to the OrangeHRM website
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            
            // Find all the links on the page
            List<WebElement> links = driver.findElements(By.tagName("a"));
            
            // Iterate through all links
            for (WebElement link : links) {
                // Check if the link is visible and enabled
                if (link.isDisplayed() && link.isEnabled()) {
                    String linkText = link.getText();
                    String linkUrl = link.getAttribute("href");
                    System.out.println("Checking link: " + linkText + " (" + linkUrl + ")");
                    
                    // Click the link to verify if it works
                    try {
                        link.click();
                        
                        // Wait until the page is loaded after clicking the link (waiting for the title of the new page)
                        WebDriverWait wait = new WebDriverWait(driver, 10);
                        wait.until(ExpectedConditions.titleContains("OrangeHRM")); // You can customize the expected title
                        
                        // If the link was clicked successfully and the page loads correctly
                        System.out.println("Link works successfully: " + linkText);
                    } catch (TimeoutException e) {
                        // Handle cases where the link fails to load or times out
                        System.out.println("Link failed to load or timed out: " + linkText);
                    } catch (Exception e) {
                        // Handle any unexpected exceptions
                        System.out.println("Error clicking the link: " + linkText);
                    }

                    // Navigate back to the original page (to check next links)
                    driver.navigate().back();
                    
                    // Re-find all links on the current page after navigating back
                    links = driver.findElements(By.tagName("a"));
                } else {
                    System.out.println("Link is not clickable: " + link.getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

