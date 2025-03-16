package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.visible;

@Epic("UI tests")
@ExtendWith({SoftAssertsExtension.class})
public class GoogleSearchTest extends BaseTest {

    @Test
    @Tag("googleSearch")
    @DisplayName("Тест проверки страницы поиска")
    @Description("Проверка поля поиска, кнопки 'Поиск в Google', элементов навигации и полей в выпадающем списке")
    @Feature("Проверка отображения других элементов на странице")
    @Story("Проверка поля поиска, кнопки 'Поиск в Google', элементов навигации и полей в выпадающем списке")
    public void searchTest() {
        Configuration.assertionMode = SOFT;
        googleSearchPage.searchField.shouldBe(visible);
        googleSearchPage.searchGoogleButton.shouldBe(visible);
        googleSearchPage.navigationButton.shouldHave(exactTexts(
                "Всё о Google",
                "Реклама", "Для бизнеса",
                "Как работает Google Поиск",
                "Наше третье десятилетие борьбы с изменением климата",
                "Конфиденциальность",
                "Условия"));
        googleSearchPage.settingsButton.shouldBe(visible).click();
        googleSearchPage.settingsDropDown.shouldHave(exactTexts(
                "Расширенный поиск",
                "Ваши данные в Поиске",
                "История поиска",
                "Поиск в справке",
                "Отправить отзыв",
                "Тёмная тема: откл."));
    }
}
