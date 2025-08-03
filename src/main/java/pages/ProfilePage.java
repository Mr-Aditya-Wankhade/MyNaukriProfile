package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    WebDriver driver;
    WebDriverWait wait;

    private By profileIcon = By.xpath("//div[@class='nI-gNb-drawer__icon']");
    private By viewProfileLink = By.xpath("//a[text()='View & Update Profile']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToProfile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon)).click();
        WebElement viewProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(viewProfileLink));
        System.out.println("View Profile Displayed: " + viewProfile.isDisplayed());
        viewProfile.click();
    }
}
