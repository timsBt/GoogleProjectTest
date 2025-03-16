package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI tests")
public class GoogleResultTest extends BaseTest {

    @BeforeEach
    public void searchSetUp() {
        googleSearchPage.search("Selenide Java")
                .captchaClick()
                .allText.shouldBe(visible, ofSeconds(10));
    }

    @Test
    @Tag("googleResult")
    @DisplayName("Тест проверки результата")
    @Description("Проверка, что заголовки всех результатов содержат слово 'Selenide'")
    @Feature("Автоматизация поиска в Google")
    @Story("Проверка, что заголовки всех результатов содержат слово 'Selenide'")
    public void resultTest() {
        for (SelenideElement element : googleResultPage.searchResults.filter(visible))
            element.shouldHave(text("Selenide"));
    }

    @Test
    @Tag("googleResult")
    @DisplayName("Тест проверки пагинации")
    @Description("Проверка выбора страницы. Проверка, что на второй странице отображаются результаты поиска")
    @Feature("Проверка пагинации")
    @Story("Проверка выбора страницы. Проверка, что на второй странице отображаются результаты поиска")
    public void paginationTest() {
        googleResultPage.pageButtonClick(2)
                .selectedPage.shouldBe(visible, ofSeconds(10)).shouldHave(text("2"));
        googleResultPage.searchResults.shouldHave(size(10));
    }

    @Test
    @Tag("googleResult")
    @DisplayName("Тест проверки изображений")
    @Description("Проверка отображения изображений. Проверка открытия увеличенного отображения изображения")
    @Feature("Проверка изображений на странице поиска")
    @Story("Проверка отображения изображений. Проверка открытия увеличенного отображения изображения")
    public void imageTest() {
        googleResultPage.tabClick("Картинки")
                .imagesResults.filter(visible).forEach(element -> element.shouldBe(visible));
        googleResultImagesPage.imagesResults.first().click();
        googleResultImagesPage.imageOpen.shouldBe(visible);
        assertEquals(
                googleResultImagesPage.imagesResults.first().getAttribute("alt"),
                googleResultImagesPage.imageOpen.getAttribute("alt"),
                "Изображения не совпадают");
    }
}
