package com.qa.guru;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

/*
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open page https://github.com", () -> {

        });
        step("Find repository selenide", () -> {
            $("[placeholder=\"Search or jump to...\"]").click();
            $("[id=query-builder-test]").setValue("selenide").pressEnter();
            $(linkText("selenide/selenide")).click();
        });
        step("Check issue tab", () -> {
            $("#issues-tab").shouldHave(text("issues"));
        });
 */
public class WebSteps {
    @Step("Open page {Url}")
    public void openWebSite(String Url) {
        open(Url);
    }

    @Step("Find repository {repository}")
    public void findRepository(String repository) {
        $("[placeholder=\"Search or jump to...\"]").click();
        $("[id=query-builder-test]").setValue(repository).pressEnter();
    }

    @Step("Click on repository {text}")
    public void clickOnRepository(String text) {
        $(linkText(text)).click();
    }

    @Step("Check tab {tab}")
    public void checkPageTab(String tab) {
        $("#issues-tab").shouldHave(text(tab));
    }

}
