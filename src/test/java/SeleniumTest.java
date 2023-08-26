import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(SeleniumTest.class);

    public static ChromeOptions options;
    public static WebDriver driver;

    @BeforeTest

    public static void Setup(){

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://flights-app.pages.dev/");


    }

    @Test
    void teststeps(){

        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:Rq9lla:\"]")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-option-:r0:\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:Rqhlla:\"]")).sendKeys("Los Angeles");
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-options-:R1qhlla:\"]")).click();

    }
    @Test
    void teststeps2(){

        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:Rq9lla:\"]")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-option-:r0:\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:Rqhlla:\"]")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-options-:R1qhlla:\"]")).click();
        LOGGER.info("There is an error in the teststeps2");
        System.out.println("Error! You cannot insert same city. Please select another city!");

    }
    @Test
    void teststeps3(){

        try{

            teststeps();
            driver.findElement(By.xpath("/html/body/main/div[2]/div/p"));


            // Find the two items in the automation codes.
            WebElement item1 = driver.findElement(By.xpath("/html/body/main/div[2]/div/ul/li[1]"));
            WebElement item2 = driver.findElement(By.xpath("/html/body/main/div[2]/div/ul/li[2]"));

            // Click on the two items.
            item1.click();
            item2.click();


            // Verify that two lists are listed on the page.
            //List<WebElement> lists = driver.findElements(By.className("grid grid-cols-1 gap-x-6 gap-y-8 lg:grid-cols-3 xl:gap-x-8"));

            //Assert.assertEquals(lists.size(), 1);


        }catch(Exception e) {

            Assert.fail("There is no match!Found X items and flight tickets");
        }
        }
    }

