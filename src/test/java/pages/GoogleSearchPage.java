package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

@Log4j2
public class GoogleSearchPage {

    @Description("Поле поиска")
    public SelenideElement searchField = $(By.name("q"));

    @Description("Кнопка 'Поиск в Google'")
    public SelenideElement searchGoogleButton = $x("//div[@class = 'FPdoLc lJ9FBc']//input[@value = 'Поиск в Google']");

    @Description("Элементы навигации внизу страницы")
    public ElementsCollection navigationButton = $$x("//a[@class = 'pHiOh']");

    @Description("Элементы в выпадающем списке Настройки")
    public ElementsCollection settingsDropDown = $$x("//g-menu-item[@class = 'EpPYLd GZnQqe']");

    @Description("Кнопка 'Настройки'")
    public SelenideElement settingsButton = $x("//div[text() = 'Настройки']");

    @Description("iframe капчи")
    public SelenideElement iframeRecaptcha = $x("//iframe[@title = 'reCAPTCHA']");

    @Description("Чек бокс Капчи")
    public SelenideElement recaptchaCheckbox = $x("//div[@class = 'recaptcha-checkbox-border']");


    @Step("Ввод в поле: {text} и нажатие Enter")
    public GoogleSearchPage search(String text) {
        log.info("Ввод в поле: '{}' и нажатие Enter", text);
        searchField.setValue(text).pressEnter();
        return this;
    }

    @Step("Подтверждение капчи")
    public GoogleResultPage captchaClick() {
        log.info("Подтверждение капчи");
        switchTo().frame(iframeRecaptcha);
        recaptchaCheckbox.shouldBe(visible, ofSeconds(10)).click();
        switchTo().defaultContent();
        return new GoogleResultPage();
    }
}
