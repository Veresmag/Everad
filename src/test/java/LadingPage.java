import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class LadingPage {
    private WebDriver webDriver;
    private WebElement inputNameForm;
    private WebElement inputPhoneForm;
    private WebElement signInButton;
    private WebElement codeVerification;
    private WebElement privacyPolicy;
    private WebElement buttonCodeVerification;
    private WebElement errorMassageCodeVerification;
    private List<WebElement> formList;

    public LadingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        inputNameForm = webDriver.findElement(By.xpath("//input [@class='block-name']"));
        inputPhoneForm = webDriver.findElement(By.xpath("//input [@class='block-phone']"));
        signInButton = webDriver.findElement(By.xpath("//button [@type='submit']"));
        codeVerification = webDriver.findElement(By.xpath("//input [@class='check__field']"));
        privacyPolicy = webDriver.findElement(By.xpath("//a [@target='_blank']"));
        buttonCodeVerification = webDriver.findElement(By.xpath("//div [@class='checkbtn check__btn hover-shadow']"));
        errorMassageCodeVerification = webDriver.findElement(By.xpath("//span [@class='check__result']"));
        formList = webDriver.findElements(By.xpath("//div [@class='clone']"));
    }

    public void form(String name, String phone) {
        inputNameForm.sendKeys(name);
        inputPhoneForm.sendKeys(phone);
        signInButton.click();
    }

    public void setCodeVerification(String code) {
        codeVerification.sendKeys(code);
        buttonCodeVerification.click();
    }

    public void privacyPolicy() {
        privacyPolicy.click();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTextErrorMassageCod() {
        return errorMassageCodeVerification.getText();
    }

    public void getTextFormList(String name, String phone) throws InterruptedException {
        for (WebElement formResult : formList) {
            String formResultText = formResult.getText();
            System.out.println(formResultText);
            System.out.println(formList.size());}
            inputNameForm.sendKeys(name);
            inputPhoneForm.sendKeys(phone);
            sleep (5000);
            signInButton.click();
            sleep (5000);
            webDriver.navigate().back();
            sleep (5000);
        }
}




//            Select select = new Select(webDriver.findElement(By.xpath("//select")));
//            select.getAllSelectedOptions();