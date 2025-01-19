package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {

    WebDriver driver;

    // Locators for the Admin page elements
    By userSearchField = By.id("searchSystemUser_userName");
    By roleDropdown = By.id("searchSystemUser_userType");
    By statusDropdown = By.id("searchSystemUser_status");
    By searchButton = By.id("searchBtn");
    By addButton = By.xpath("//button[contains(text(),'Add')]");

    // Constructor to initialize the WebDriver
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to search for a user by their username
    public void enterUsernameForSearch(String username) {
        WebElement searchField = driver.findElement(userSearchField);
        searchField.clear(); // Clears any previous input
        searchField.sendKeys(username);
    }

    // Method to select a user role from the dropdown
    public void selectRole(String role) {
        WebElement roleElement = driver.findElement(roleDropdown);
        roleElement.sendKeys(role);
    }

    // Method to select a user status from the dropdown
    public void selectStatus(String status) {
        WebElement statusElement = driver.findElement(statusDropdown);
        statusElement.sendKeys(status);
    }

    // Method to click the search button
    public void clickSearchButton() {
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
    }

    // Method to click the Add button to add a new system user
    public void clickAddButton() {
        WebElement addBtn = driver.findElement(addButton);
        addBtn.click();
    }

    // Additional methods for interacting with user records (e.g., editing users, deleting users, etc.) can be added here
}

