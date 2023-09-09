package com.qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class testGeetHubIssue {

    @Test
    public void testGitHubIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $("[placeholder=\"Search or jump to...\"]").click();
        $("[id=query-builder-test]").setValue("selenide").pressEnter();
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").shouldHave(text("issues345"));
        sleep(5000);
    }

    @Test
    public void testGitHubIssuesLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open page https://github.com", () -> {
            open("https://github.com");
        });
        step("Find repository selenide", () -> {
            $("[placeholder=\"Search or jump to...\"]").click();
            $("[id=query-builder-test]").setValue("selenide").pressEnter();
            $(linkText("selenide/selenide")).click();
        });
        step("Check issue tab", () -> {
            $("#issues-tab").shouldHave(text("issues"));
        });
        sleep(5000);
    }

    @Test
    public void testGitHubIssuesAnnotaitedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openWebSite("https://github.com");
        steps.findRepository("selenide");
        steps.clickOnRepository("selenide/selenide");
        steps.checkPageTab("issues");
    }

}
