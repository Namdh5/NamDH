import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Autotest
{
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Mo trang web

        driver.navigate().to("https://www.amazon.com/");

        driver.manage().window().maximize();

        // Tìm chữ Iphone 12
        WebElement element1=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        element1.sendKeys("Iphone 12");

        Thread.sleep(2000);

        WebElement element2=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        element2.click();

        Thread.sleep(2000);

        //Validate ket qua tim kiem
        List<WebElement> results = driver.findElements(By.xpath("//body/div[@id='a-page']/div[@id='search']/span[1]/div[1]/h1[1]/div[1]/div[1]/div[1]/div[1]"));
        String expected="Iphone 12";
        for (int i = 0; i < results.size(); i++) {
            Assert.assertTrue(results.get(i).getText().toLowerCase().contains(expected.toLowerCase()));;
        }
        System.out.println("Matched");


        //Lua chon Item thu 5
        WebElement element5 = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 12, 256GB, Blue - Unlocked (Renewed P')]"));
        element5.click();

        //Validate ket qua
        List<WebElement> Price = driver.findElements(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]"));
        List<WebElement> DetailPrice = driver.findElements(By.xpath("//tbody/tr[1]/td[2]/span[1]/span[2]"));
        for (int i = 0; i < Price.size(); i++)
            Assert.assertEquals(Price.get(i).getText(),DetailPrice.get(i).getText());
        System.out.println("Matched Price");


        Thread.sleep(2000);

        //Add Item vào cart
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        //Vao gio hang
        driver.findElement(By.xpath("//a[contains(text(),'Go to Cart')]")).click();
        driver.findElement(By.name("proceedToRetailCheckout")).click();

        Thread.sleep(1000);
        System.out.println("Thanh toan di");
    }
}
