import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class LadingPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//input [@class='block-name']")
    private List<WebElement> inputNameForm;

    @FindBy(xpath = "//input [@class='block-phone']")
    private List<WebElement> inputPhoneForm;

    @FindBy(xpath = "//button[@type='submit']")
    private List<WebElement> signInButton;

    @FindBy(xpath = "//input [@class='check__field']")
    private WebElement codeVerification;

    @FindBy(xpath = "//a [@target='_blank']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//div [@class='checkbtn check__btn hover-shadow']")
    private WebElement buttonCodeVerification;

    @FindBy(xpath = "//span [@class='check__result']")
    private WebElement errorMassageCodeVerification;

    @FindBy(xpath = "//div[@class='clone']")
    private List<WebElement> submitOrderForms;

    public LadingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public int getSubmitOrderFormsCount() {
        return submitOrderForms.size();
    }

    public void fillOrderFormsInALoop(String name, String phoneNumber) {
        for (WebElement submitOrderForm : submitOrderForms) {
            submitOrderForm.findElement(By.name("name")).sendKeys(name);
            submitOrderForm.findElement(By.name("phone")).sendKeys(phoneNumber);
            //Submit will load another page
            //submitOrderForm.findElement(By.xpath("//button[@type='submit']")).click();
        }
    }


    public void form(String name, String phone) {
        inputNameForm.get(0).sendKeys(name);
        inputPhoneForm.get(0).sendKeys(phone);
        signInButton.get(0).click();
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
        System.out.println(submitOrderForms.size());
        for (WebElement submitOrderForm : submitOrderForms) {
            String formResultText = submitOrderForm.getText();
            System.out.println(formResultText);
        }


        inputNameForm.get(0).sendKeys(name);
        inputPhoneForm.get(0).sendKeys(phone);
        sleep(3000);
        signInButton.get(0).click();
        sleep(3000);
        webDriver.navigate().back();
        webDriver.navigate().refresh();
        sleep(3000);

// Нашел как обратиться к каждой форме, но код получается огромный.
// Уверен что должен быть цикличный метод.

        inputNameForm.get(1).sendKeys(name);
        inputPhoneForm.get(1).sendKeys(phone);
        sleep(3000);
        signInButton.get(1).click();
        sleep(3000);
        webDriver.navigate().back();
        webDriver.navigate().refresh();
        sleep(3000);

        inputNameForm.get(2).sendKeys(name);
        inputPhoneForm.get(2).sendKeys(phone);
        sleep(3000);
        signInButton.get(2).click();
        sleep(3000);
        webDriver.navigate().back();
        webDriver.navigate().refresh();
        sleep(3000);

        inputNameForm.get(3).sendKeys(name);
        inputPhoneForm.get(3).sendKeys(phone);
        sleep(3000);
        signInButton.get(3).click();
        sleep(3000);
        webDriver.navigate().back();
        webDriver.navigate().refresh();
        sleep(3000);
    }
}


//            Select select = new Select(webDriver.findElement(By.xpath("//select")));
//            select.getAllSelectedOptions();