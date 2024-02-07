import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        $(".month--dropdown, [value=\"6\"]").click();
        $(".year-dropdown, [value=\"1988\"]").click();
        $("[aria-label=\"Choose Sunday, July 24th, 1988\"]").click();
        // Заполняем блок Subjects
        $("[id=\"subjectsContainer\"]").click();
        $("[id=\"subjectsInput\"]").setValue("E");
        $("[id=\"subjectsContainer\"]").$$(".subjects-auto-complete__menu").first().click(); // Вопрос по выбору позиции в выпадающем списке
        // Заполняем блок Hobbies
        $("[id=\"hobbiesWrapper\"]").click(); // Разобраться с выбором значени чек-бокса
        // Выполняем прикрепление файла
        File file1 = new File("src/test/resources/readme.txt");
        $("[id=\"uploadPicture\"]").uploadFile(file1);
        $("[id=\"uploadPicture\"]").uploadFromClasspath("readme.txt");
        // Заполняем поле Current Address
        $("[id=\"currentAddress\"]").setValue("TEST");
        // Заполняем поля State and City
        $("[id=\"state\"]").click();
       // $$("[id=\"state\"]").shouldBe(CollectionCondition.texts("NCR"));





        sleep(3000);


    }
}
