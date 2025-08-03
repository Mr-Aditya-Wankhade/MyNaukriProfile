package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResumeHeadlinePage {
    WebDriver driver;
    WebDriverWait wait;

    private By editButton = By.xpath("//div[@class='widgetHead']//span[@class='edit icon'][normalize-space()='editOneTheme']");
    private By headlineTextarea = By.id("resumeHeadlineTxt");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    public ResumeHeadlinePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void updateHeadline() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editButton)).click();
        WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(headlineTextarea));

        String currentText = textarea.getAttribute("value");
        System.out.println("Current Headline: " + currentText);

        String newText = currentText.contains(" & Manual Testing") ?
                currentText.replace(" & Manual Testing", "").trim() :
                currentText + " & Manual Testing";

        textarea.clear();
        textarea.sendKeys(newText);
        System.out.println("New Headline: " + newText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton)).click();
    }
}
