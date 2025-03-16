package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleResultImagesPage {

    @Description("Изображения на странице")
    public ElementsCollection imagesResults = $$x("//img[@class = 'YQ4gaf']");

    @Description("Увеличенная версия изображения")
    public SelenideElement imageOpen = $x("//img[@jsname = 'kn3ccd']");
}
