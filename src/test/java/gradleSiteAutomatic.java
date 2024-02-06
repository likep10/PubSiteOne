import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class gradleSiteAutomatic {
    @Test
    public void pubSet() {
        Configuration.browserSize = "1920x1080";
        // Открываем сайт https://demoqa.com/automation-practice-form
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"));
        // Заполняем блок формы userName
        $("#firstName").sendKeys("Igor");
        $("#lastName").sendKeys("Ka");
        // Заполняем блок фломы userEmail
        $("#userEmail").sendKeys(("likep@mail.ru"));
        // Заполняем блок формы genter
        //$("[name=\"gender\"]").selectRadio("Male"); --Вопрос!!!
        $(".custom-radio").shouldBe(Condition.text("Male")).click();
        // Заполняем блок формы userNumber
        $("#userNumber").sendKeys("9000000000");
        // Запоняем блок формы dateOfBirth
        $("#dateOfBirth .react-datepicker-wrapper").click();
        sleep(2000);


    }
}
