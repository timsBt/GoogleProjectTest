package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

@Log4j2
public class GoogleResultPage {

    @Description("Вкладка 'Все' на странице результата поиска")
    public SelenideElement allText = $x("//div[text() = 'Все']");

    @Description("Заголовки результатов")
    public ElementsCollection searchResults = $$x("//h3[@class = 'LC20lb MBeuO DKV0Md']");

    @Description("Выбранная страница в пагинации")
    public SelenideElement selectedPage = $x("//td[@class = 'YyVfkd NKTSme']");

    String pageButton = "//td[@class = 'NKTSme']//a[@aria-label = 'Page %s']";
    String tab = "//div[text() = '%s']";

    @Step("Клик по номеру страницы: {page}")
    public GoogleResultPage pageButtonClick(int page) {
        log.info("Клик по номеру страницы: '{}'", page);
        $x(String.format(pageButton, page)).shouldBe(visible, ofSeconds(10)).click();
        return this;
    }

    @Step("Клик по вкладке: {tabName}")
    public GoogleResultImagesPage tabClick(String tabName) {
        log.info("Клик по вкладке: '{}'", tabName);
        $x(String.format(tab, tabName)).shouldBe(visible, ofSeconds(10)).click();
        return new GoogleResultImagesPage();
    }
}
