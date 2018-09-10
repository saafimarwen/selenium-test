package newpackage;
import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MyClass {


    public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SAAFI-Marwen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https:\\chewie.one2team.com";
        String expectedTitle = "One2team - Connexion";
        String actualTitle = "";

        driver.get(baseUrl);

        //initier les élements de connexion
        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("passWord"));
        //WebElement domaine = driver.findElement(By.xpath(xpathExpression));

        username.sendKeys("candidat");
        password.sendKeys("Candidat1*");
        //domaine.sendKeys("telco");
        
        password.submit();
        
        actualTitle = driver.getTitle();
        //s'assurer de la connexion
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement slideboard = driver.findElement(By.id("img_slideboard"));
        slideboard.click();
        
        
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // les wait implicite peuvent être remplacées par des wait util element soit visible
        driver.switchTo().frame("slideboard");
        WebElement selectboard = driver.findElement(By.id("selectBoard"));
        selectboard.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement z_tache = driver.findElement(By.id("select2-results-2"));
        z_tache.click();
        
        //placer souris sur un élement pour rendre un autre element visible
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.className("containCol__col__plus"));
        action.moveToElement(we);
        
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.className("add-icon")).click();
        //création de la carte
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement cardName = driver.findElement(By.id("cardName"));
        cardName.sendKeys("test candidat");
        WebElement add_cart = driver.findElement(By.xpath("/html/body/div[1]/div/div/card-creation-popin-content-dumb/div[2]/div/button-with-status"));
        add_cart.click();
        
        //trouver la dernière carte crée
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ArrayList<WebElement> cols = (ArrayList<WebElement>) driver.findElements(By.className("containCol__col__card"));
        WebElement cards = driver.findElement(By.id("/ogp/6241980"));
        action.dragAndDrop(cards, cols.get(8)).build().perform();	
        
        

        //ferméture de Chrome
        //driver.close();
       
    }

}