package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.GoogleResultImagesPage;
import pages.GoogleResultPage;
import pages.GoogleSearchPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.PropertiesUtils.valueProperties;

public class BaseTest {

    GoogleSearchPage googleSearchPage;
    GoogleResultPage googleResultPage;
    GoogleResultImagesPage googleResultImagesPage;

    @BeforeEach
    public void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1750x950";
        open(valueProperties("url"));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
        googleSearchPage = new GoogleSearchPage();
        googleResultPage = new GoogleResultPage();
        googleResultImagesPage = new GoogleResultImagesPage();
    }

    @AfterEach
    public void tearDown() {
        if (getWebDriver() != null) {
            clearBrowserCookies();
            clearBrowserLocalStorage();
            closeWebDriver();
        }
    }
}
