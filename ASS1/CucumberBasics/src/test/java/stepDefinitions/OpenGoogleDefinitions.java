package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


class OpenGoogleDefinitions
{
    private WebDriver driver;

    @Given("the user is on the Home page")
    public void openHomePage() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.example.com");
    }

    @When("the user navigates to the Login page")
    public void goToLoginPage() {
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();
    }

    @When("the user enters valid username and password")
    public void enterValidCredentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("valid_username");
        passwordField.sendKeys("valid_password");
        loginButton.click();
    }

    @Then("the successful login message is displayed")
    public void checkSuccessfulLoginMessage() {
        WebElement successMessage = driver.findElement(By.id("success-message"));
        String expectedMessage = "You have successfully logged into your account! There are multiple discount offers waiting for you!!";
        String actualMessage = successMessage.getText();

        assert actualMessage.equals(expectedMessage);
    }

    @Then("the error message {string} is displayed")
    public void checkErrorMessage(String expectedErrorMessage) {
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        String actualErrorMessage = errorMessage.getText();

        assert actualErrorMessage.equals(expectedErrorMessage);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}




