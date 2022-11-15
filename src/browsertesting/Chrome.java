package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Chrome {

    public static void main(String[] args) {
        String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Launch the URL
        driver.get(baseUrl);
        //Maximise window
        driver.manage().window().maximize();
        //we give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Get the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is : " + title);

        //Get current URL
        System.out.println("Current URL : " + driver.getCurrentUrl());

        //Get page Source
        System.out.println("Page source: " + driver.getPageSource());

        //Navigate to Login page
        // String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        //driver.navigate().to(loginUrl);

        //Navigate to Login page by clicking on login Link
        //WebElement loginLink = driver.findElement(By.linkText("Log in"));
        //loginLink.click();

        //Find the email field element abd send the email
        WebElement userField = driver.findElement(By.name("user[email]"));
        //Type email to send email
        userField.sendKeys("test123@gmail.com");

        //Find the password field element
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("test123");

        //Close the browser
        driver.close();

    }
}
