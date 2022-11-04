package HepsiBurada.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class finally_case {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--acceptInsecureCerts");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void SingInTest() throws InterruptedException {
        driver.get("https://www.hepsiburada.com/");
        WebElement signInButtonBefore = driver.findElement(By.xpath("//*[@id=\"myAccount\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(signInButtonBefore).perform();
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        signInButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("giris"));
        WebElement mailInput = driver.findElement(By.xpath("//*[@id=\"txtUserName\"]"));
        mailInput.sendKeys("d.rabia1907@gmail.com");
        WebElement signInEmailBtn = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        signInEmailBtn.click();
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        passwordInput.sendKeys("Rabia.123456");
        WebElement signInBtn = driver.findElement(By.xpath("//*[@id=\"btnEmailSelect\"]"));
        signInBtn.click();
        String productOneName;
        String productTwoName;
        WebElement search = driver.findElement(By.className("desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b"));
        search.sendKeys("laptop");
        WebElement searchBtn = driver.findElement(By.className("SearchBoxOld-cHxjyU99nxdIaAbGyX7F"));
        searchBtn.click();
        WebElement productOne = driver.findElement((By.xpath("//*[@id=\"i0\"]/div/a")));
        driver.get(productOne.getAttribute("href"));
        String seller = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[3]/div/div[4]/div[1]/div[2]/div/div[1]/div[5]/div[1]/span/span[2]/a")).getText();
        productOneName = driver.findElement(By.xpath("//*[@id=\"product-name\"]")).getText();
        WebElement addSales = driver.findElement(By.xpath("//*[@id=\"addToCart\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addSales);
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        int i = 1;
        while (true) {
            WebElement productTwo = driver.findElement(By.xpath("//*[@id=\"i" + i + "\"]/div/a"));
            driver.get(productTwo.getAttribute("href"));
            TimeUnit.SECONDS.sleep(5);
            String controlSeller = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[3]/div/div[4]/div[1]/div[2]/div/div[1]/div[5]/div[1]/span/span[2]/a")).getText();
            if (!seller.contains(controlSeller)) {
                productTwoName = driver.findElement(By.xpath("//*[@id=\"product-name\"]")).getText();
                WebElement addSalesTwo = driver.findElement(By.xpath("//*[@id=\"addToCart\"]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addSalesTwo);
                TimeUnit.SECONDS.sleep(2);
                break;
            }else {
                i++;
                driver.navigate().back();
            }

        }
        driver.get("https://checkout.hepsiburada.com/sepetim");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"df05846a-d55c-40e5-a164-9f238a1bbf16\"]/div/div/div[1]/div[2]/div[2]")).getText().contains(productTwoName));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"d2d2e5cf-b55d-44b8-9b53-d542dc66104f\"]/div/div/div[1]/div[2]/div[2]/a")).getText().contains(productOneName));

    }

    @Test
    public void SingOutTest() throws InterruptedException {
        driver.get("https://www.hepsiburada.com/");
        String productOneName;
        String productTwoName;
        WebElement search = driver.findElement(By.className("desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b"));
        search.sendKeys("laptop");
        WebElement searchBtn = driver.findElement(By.className("SearchBoxOld-cHxjyU99nxdIaAbGyX7F"));
        searchBtn.click();
        WebElement productOne = driver.findElement((By.xpath("//*[@id=\"i0\"]/div/a")));
        driver.get(productOne.getAttribute("href"));
        String seller = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[3]/div/div[4]/div[1]/div[2]/div/div[1]/div[5]/div[1]/span/span[2]/a")).getText();
        productOneName = driver.findElement(By.xpath("//*[@id=\"product-name\"]")).getText();
        WebElement addSales = driver.findElement(By.xpath("//*[@id=\"addToCart\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addSales);
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        int i = 1;
        while (true) {
            WebElement productTwo = driver.findElement(By.xpath("//*[@id=\"i" + i + "\"]/div/a"));
            driver.get(productTwo.getAttribute("href"));
            TimeUnit.SECONDS.sleep(5);
            String controlSeller = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[3]/div/div[4]/div[1]/div[2]/div/div[1]/div[5]/div[1]/span/span[2]/a")).getText();
            if (!seller.contains(controlSeller)) {
                productTwoName = driver.findElement(By.xpath("//*[@id=\"product-name\"]")).getText();
                WebElement addSalesTwo = driver.findElement(By.xpath("//*[@id=\"addToCart\"]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addSalesTwo);
                TimeUnit.SECONDS.sleep(2);
                break;
            }else {
                i++;
                driver.navigate().back();
            }

        }
        driver.get("https://checkout.hepsiburada.com/sepetim");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"df05846a-d55c-40e5-a164-9f238a1bbf16\"]/div/div/div[1]/div[2]/div[2]")).getText().contains(productTwoName));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"d2d2e5cf-b55d-44b8-9b53-d542dc66104f\"]/div/div/div[1]/div[2]/div[2]/a")).getText().contains(productOneName));

    }
}