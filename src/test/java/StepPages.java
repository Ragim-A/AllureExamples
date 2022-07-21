import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StepPages {
    @Step("Open profile page")
    public StepPages openProfilePage(String value) {
        Selenide.open(value);
        return this;
    }
    @Step("Look for repo")
    public StepPages openRepo (String value) {
        $$(".repo").find(text (value)).click();
        return this;
    }
    @Step("Check visibility of determined object")
    public StepPages checkVisibility (String value) {
        $("[class='UnderlineNav-body list-style-none']").shouldHave(text(value)).shouldBe(visible);
        return this;
    }
}
