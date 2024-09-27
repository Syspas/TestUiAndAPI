package UI;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class Open extends BasicTest {


    @Test
    public void Open() {
        open(URL);
        sleep(10000);


        Selenide.closeWebDriver();//закрыть браузер после выполнения теста
    }
}