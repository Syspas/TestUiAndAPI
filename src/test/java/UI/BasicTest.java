package UI;
import library.ui.Methods;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


import java.io.File;


public class BasicTest extends Methods {
    /**
     * Адрес сайта, к которому осуществляется подключение.
     */
    String URL = "https://dzen.ru";


    //плагин подписи загружается тогда когда ресурс поддерживает подписание
    private static final String GECKODRIVER_PATH = "D:\\VCS\\GitHub\\Java\\TestUI\\geckodriver.exe";
    private static final String FIREFOX_EXTENSION_PATH = "D:\\VCS\\GitHub\\Java\\TestUI\\src\\main\\resources\\firefox_cryptopro_extension_latest.xpi";
    //private static final String FIREFOX_EXTENSION_PATH = "src/main/resources/firefox_cryptopro_extension_latest.xpi";

    /**
     * Метод для настройки параметров браузера перед каждым тестом.
     * В данном случае настраивается браузер Firefox.
     * Можно закомментировать строку с настройкой Firefox и раскомментировать строку с настройкой Chrome,
     * чтобы использовать браузер Chrome.
     */
    @BeforeAll
    public static void setBrowser() {
        // Установка веб-драйвера для Firefox из репозитория WebDriverManager
        WebDriverManager.firefoxdriver().setup(); // Для использования Firefox
        // Установка веб-драйвера для Chrome (раскомментируйте, если используете Chrome)
        // WebDriverManager.chromedriver().setup();
        // Если раскоментирована строка 39 строка 43 будет закоментирована
        System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);

        // Создаем объект File, представляющий расширение Firefox
        File file = new File(FIREFOX_EXTENSION_PATH);

        // Создаем новый профиль Firefox и добавляем в него расширение
        FirefoxProfile profile = new FirefoxProfile();
        profile.addExtension(file);

        // Создаем опции для Firefox и устанавливаем профиль
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);

        // Присваиваем опции Firefox для конфигурации браузера Selenide
        Configuration.browserCapabilities = firefoxOptions;

        // Установка браузера для тестирования
        Configuration.browser = "firefox"; // Выбор браузера: "chrome" или "firefox"

        // Установка размера окна браузера
        Configuration.browserSize = "1920x1080";

        // Быстрое заполнение полей
        Configuration.fastSetValue = true;

        // Запуск браузера в режиме "headless" (раскомментируйте для использования)
        // Configuration.headless = true;

    }



    }



