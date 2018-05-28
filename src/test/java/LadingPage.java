import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class LadingPage {
    private WebDriver webDriver;

    @FindBy (xpath ="//input [@class='block-name']" )
    private List<WebElement> inputNameForm;

    @FindBy (xpath = "//input [@class='block-phone']")
    private List<WebElement> inputPhoneForm;

    @FindBy (xpath = "//button [@type='submit']")
    private List<WebElement> signInButton;

    @FindBy(xpath ="//input [@class='check__field']" )
    private WebElement codeVerification;

    @FindBy (xpath ="//a [@target='_blank']")
    private WebElement privacyPolicy;

    @FindBy(xpath ="//div [@class='checkbtn check__btn hover-shadow']")
    private WebElement buttonCodeVerification;

    @FindBy(xpath ="//span [@class='check__result']")
    private WebElement errorMassageCodeVerification;

    @FindBy(xpath ="//div [@class='clone']")
    private List<WebElement> formList;

    public LadingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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
        for (WebElement formResult : formList) {
            String formResultText = formResult.getText();
            System.out.println(formResultText);
            System.out.println(formList.size());}
//            if (formList.contains("Ваши данные не будут переданы третьим лицам!"));
//                else {}
            inputNameForm.get(0).sendKeys(name);
            inputPhoneForm.get(0).sendKeys(phone);
            sleep (5000);
            signInButton.get(0).click();
            sleep (5000);
            webDriver.navigate().back();
            sleep (5000);

// Нашел как обратиться к каждой форме, но код получается огромный.
// Уверен что должен быть цикличный метод.

        inputNameForm.get(1).sendKeys(name);
        inputPhoneForm.get(1).sendKeys(phone);
        sleep (5000);
        signInButton.get(1).click();
        sleep (5000);
        webDriver.navigate().back();
        sleep (5000);

        inputNameForm.get(2).sendKeys(name);
        inputPhoneForm.get(2).sendKeys(phone);
        sleep (5000);
        signInButton.get(2).click();
        sleep (5000);
        webDriver.navigate().back();
        sleep (5000);

        inputNameForm.get(3).sendKeys(name);
        inputPhoneForm.get(3).sendKeys(phone);
        sleep (5000);
        signInButton.get(3).click();
        sleep (5000);
        webDriver.navigate().back();
        sleep (5000);
        }
}




//            Select select = new Select(webDriver.findElement(By.xpath("//select")));
//            select.getAllSelectedOptions();