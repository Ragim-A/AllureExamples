import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


public class GithubTest {
    @BeforeAll
    public static void openMainPage() {
        Configuration.baseUrl = ("https://github.com/");
        Configuration.browserSize = "1920x1080";
    }

    @DisplayName("Check link visibility Issue. Selenide")
    @Test
    public void checkIssueSelenide() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            Selenide.open("Ragim-A");
            $$(".repo").find(text ("ParamTests")).click();
            $("[class='UnderlineNav-body list-style-none']").shouldHave(text("Issues")).shouldBe(visible);
        }
    @DisplayName("Проверка наличия ссылки Issue в репозитории, лямбда степы")
    @Test
    public void checkIssueLSteps() {
        step("Open profile page", () -> Selenide.open("Ragim-A"));
        step("Look for repository by Name", () -> $$(".repo").find(text ("ParamTests")).click());
        step("Check link`s 'Issue' visibility", ()-> {$("[class='UnderlineNav-body list-style-none']").shouldHave(text("Issues")).shouldBe(visible);
        });
    }
    @DisplayName("Проверка наличия 'Issue' в репозитории, Step")
    @Test
    public void checkIssueSteps() {
        StepPages step = new StepPages();
        step.openProfilePage("Ragim-A");
        step.openRepo("ParamTests");
        step.checkVisibility("Issue");
    }
}



