import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(SeleniumTest.class);

    public static ChromeOptions options;
    public static WebDriver driver;

    @BeforeTest

    public static void Setup() {

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);//connecting web server via chromedriver that is shared
        driver.get("https://flights-app.pages.dev/");//it includes the URL of the flight site


    }

    @Test
    void teststeps() {
        //in order to automate the test we used xpath method that is able to call the elements on the UI
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:Rq9lla:\"]")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-option-:r0:\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:Rqhlla:\"]")).sendKeys("Los Angeles");
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-options-:R1qhlla:\"]")).click();
        //to write for the flight destinations automatically it is used 'sendKeys'
        //to click them automatically for selection it is used 'click'
    }

    @Test
    void teststeps2() {

        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:Rq9lla:\"]")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-option-:r0:\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:Rqhlla:\"]")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-options-:R1qhlla:\"]")).click();
        LOGGER.info("There is an error in the teststeps2");//warning message for the tester in the log
        System.out.println("Error! You cannot insert same city. Please select another city!");
        //when both of the destinations are the same, then it is printed out the error message on the running result screen


    }


        @Test
        void compareListElements() {

            teststeps();

            int expectedNumberOfItems = 2;
            int actualNumberOfItems = getNumberOfItemsInList(driver);

            if (actualNumberOfItems != expectedNumberOfItems) {
                throw new RuntimeException("The number of list elements does not match the expected number.");
            } else {
                System.out.println("X is equal to the expected value");
            }
        }

        private int getNumberOfItemsInList(WebDriver driver) {
            return driver.findElements(By.cssSelector("body > main > div.mt-24.max-w-5xl.w-full.justify-center.items-center.text-sm.lg\\:flex > div > ul > li:nth-child(1) body > main > div.mt-24.max-w-5xl.w-full.justify-center.items-center.text-sm.lg\\:flex > div > ul > li:nth-child(2)")).size();
        }
    }


