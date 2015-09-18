import CommonApi.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by mounssif on 8/27/2015.
 */
public class AljHomePage extends BaseClass{
    @Test
    public void navigate() throws InterruptedException{
        //driver.findElement(By.cssSelector(".header-sections-link")).click();
        //Thread.sleep(2);
        //navigate to tech page
        clickByXpath("html/body/header/div/div/div/div[4]/div[2]/div[2]/a[4]");
        sleepFor(2);
        navigateBack();
        //sleepFor(3000);
        //navigate to sport page
        clickByXpath("html/body/header/div/div/div/div[4]/div[2]/div[2]/a[7]");
        sleepFor(2);
        typeAndEnterByCss(".header-search-input.media-body","Real Madrid");
        sleepFor(2);




    }
}
