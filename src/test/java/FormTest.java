import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @Test
    public void testSuccessfulForm() {
        open("http://localhost:9999");
        $("form").$("[data-test-id=name] input").setValue("Иван Иванов");
        $("form").$("[data-test-id=phone] input").setValue("+79123456789");
        $("form").$("[data-test-id=agreement]").click();
        $("form").$("[type=button]").click();

        $("[data-test-id=order-success]").shouldHave(exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}