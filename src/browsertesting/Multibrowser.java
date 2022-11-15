package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Multibrowser {



    static String browser = "edge";
    static String baseUrl =  "https://courses.ultimateqa.com/users/sign_in";;
    static WebDriver driver;

    public static void main(String[] args) {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();

        } else {
            System.out.println("Wrong Browser Name");

        }
        //Launch the URL
        driver.get(baseUrl);
        //Maximise window
        driver.manage().window().maximize();
        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is :"+title);


        //Get current Url
        System.out.println("Current URL : "+driver.getCurrentUrl());

        //Get page Source
        System.out.println("Page Source : "+driver.getPageSource());

        //Navigate to Login page by clicking on login Link
        // WebElement loginLink = driver.findElement(By.linkText("Log in"));
        // loginLink.click();
        //Find the email field element and send the email
        WebElement emailField = driver.findElement(By.name("user[email]"));
        //Type email to end email
        emailField.sendKeys("test123@gmail.com");

        //Find the password field element
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("test123");

        //Close the browser
       driver.close();

    }
}

