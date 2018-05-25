import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LadingSubscribePage {
    private WebDriver webDriver;
    private WebElement inputEmail;
    private WebElement buttonEmail;


    public LadingSubscribePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        inputEmail = webDriver.findElement(By.xpath("//input [@type='text']"));
        buttonEmail = webDriver.findElement(By.xpath("//button"));
    }

    public void setEmail(String email) {
        inputEmail.sendKeys(email);
        buttonEmail.click();
    }
}