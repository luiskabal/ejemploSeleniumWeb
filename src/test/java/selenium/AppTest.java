package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.google.com");
    }

    @Test
    public void test01()
    {
        System.out.println("Iniciando Pruebas...");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        assertEquals("HandBook Devops - Buscar con Google", driver.getTitle());
        WebElement link  = driver.findElement(By.linkText("Imágenes"));
        link.click();
        String path="https://www.buscalibre.cl/libro-the-devops-handbook-how-to-create-world-class-agility-reliability-and-security-in-technology-organizations-libro-en-ingles-gene-kim-it-revolution-press/9781942788003/p/48451046";
        driver.findElement(By.xpath("(//a[contains(@href,'"+path+"')])")).click();
    }
    
     @Test
    public void test02()
    {
    	driver.get("https://www.amazon.com");
        System.out.println("Iniciando Pruebas...");
        WebElement searchbox = driver.findElement(By.name("field-keywords"));
        searchbox.sendKeys("The Phoenix Project");
        searchbox.submit();
        assertEquals("Amazon.com - The Phoenix Project", driver.getTitle());
    }
   
}
