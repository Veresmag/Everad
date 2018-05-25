import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static java.lang.Thread.sleep;


public class LadingPageTest {
WebDriver webDriver;

@BeforeMethod
public void before () {
    webDriver = new FirefoxDriver();
    webDriver.get("http://sustanols.ru/");
}

    @Test
    public void formTest () {
        LadingPage ladingPage = new LadingPage (webDriver);
        ladingPage.form("Test","0500000000");

        Assert.assertEquals(ladingPage.getCurrentUrl(),
                "http://sustanols.ru/subscribe.html",
                "The link is not correct");
    }

    @Test
    public void listFormTest () throws InterruptedException {
    LadingPage ladingPage = new LadingPage(webDriver);
    ladingPage.getTextFormList("Тест", "0500000000");
    }

    @Test
    public void subscribeTest () {
        LadingPage ladingPage = new LadingPage (webDriver);
        ladingPage.form("Test","0500000000");

        Assert.assertEquals(ladingPage.getCurrentUrl(),
                "http://sustanols.ru/subscribe.html",
                "The link is not correct");

        LadingSubscribePage ladingSubscribePage = new LadingSubscribePage(webDriver);
        ladingSubscribePage.setEmail("666@i.ua");
        Assert.assertEquals(ladingPage.getCurrentUrl(),
                "http://sustanols.ru/success.html",
                "The link is not correct");
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "", "0500000000"},
                {"Test",""},
                {"",""},
                {"T","1"},
                { "Test", "050"},
        };
    }

    @Test (dataProvider = "validDataProvider")
    public void negativFormTest(String name, String phone) throws InterruptedException {

        LadingPage ladingPage = new LadingPage (webDriver);
        ladingPage.form(name, phone);
        Assert.assertNotEquals(ladingPage.getCurrentUrl(),
                "http://sustanols.ru/subscribe.html",
                "The link is not correct");

        sleep(3000);
    }

    @DataProvider
    public Object[][] validCodeVerification() {
        return new Object[][]{
                { "123"},
                {"1234567891234565"},
        };
    }
    @Test (dataProvider = "validCodeVerification")
    public void negativCodeVerificationTest (String code) throws InterruptedException {
        LadingPage ladingPage = new LadingPage (webDriver);
        ladingPage.setCodeVerification(code);
        Assert.assertEquals(ladingPage.getTextErrorMassageCod(),
        "К сожалению, данный код не найден! Вероятнее всего, вы приобрели поддельный продукт.",
                "Failed to validate the code, passes with errors in the code");
        sleep(3000);

    }

    @Test ()
    public void codeVerificationTest () throws InterruptedException {
        LadingPage ladingPage = new LadingPage (webDriver);
        ladingPage.setCodeVerification("123456789123456");
        Assert.assertEquals(ladingPage.getTextErrorMassageCod(),
                "Данный код верен. Спасибо, что выбрали нашу продукцию!",
                "Failed to validate the code, passes with errors in the code");
        sleep(3000);
    }

    @Test
    public void privacyPolicyTest () throws InterruptedException {
        LadingPage ladingPage = new LadingPage (webDriver);
        ladingPage.privacyPolicy();
//        ArrayList tabs2 = new ArrayList (webDriver.getWindowHandles());
//        webDriver.switchTo().window(String.valueOf(tabs2.get(1)));
        sleep (2000);
    }

    @AfterMethod
    public void after ()    {
        webDriver.close();
    }

}


//    List<WebElement> searchResults = webDriver.findElements(By.xpath("//span [@class='money x_price_current']"));
//
//        System.out.println(searchResults.size());
//
//        for (WebElement searchResult : searchResults) {
//            String searchResultText = searchResult.getText();
//            if (searchResultText.contains("*")) {
//                System.out.println("Price found!!");
//            }
//            System.out.println(searchResultText);
//        }