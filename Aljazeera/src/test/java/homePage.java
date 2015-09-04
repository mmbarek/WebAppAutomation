import CommonApi.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by mounssif on 8/27/2015.
 */
public class homePage extends BaseClass{
    @Test
    public void navigate() throws InterruptedException{
        driver.findElement(By.cssSelector(".header-nav-link")).click();
        Thread.sleep(3000);
        //navigate to tech page
        clickByXpath("html/body/header/div/div/div/div[4]/div[2]/div[2]/a[4]");
        sleepFor(3000);
        navigateBack();
        //sleepFor(3000);
        //navigate to sport page
        clickByXpath("html/body/header/div/div/div/div[4]/div[2]/div[2]/a[7]");
        sleepFor(2000);
        typeAndEnterByCss(".header-search-input.media-body","Real Madrid");
        sleepFor(3000);




    }
}
