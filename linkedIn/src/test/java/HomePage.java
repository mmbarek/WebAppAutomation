import CommonApi.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Created by mounssif on 8/28/2015.
 */
public class HomePage extends BaseClass {
    @Test
    //Test to create an account in Linkedin!!!!!!!!!!!
//    public void createAccount()throws InterruptedException{
//        typeByCss("#first-name", "Nick");
//        sleepFor(1);
//        typeByCss("#last-name", "Body");
//        sleepFor(1);
//        typeByCss("#join-email", "NBody123@yahoo.com");
//        sleepFor(1);
//        typeByCss("#join-password", "Qwert1234");
//        sleepFor(1);
//        clickByCss("#pagekey-uno-reg-guest-home > div.main > div.fodal.join-container.reg-content-container > div > div.content-container > div > div > div > form > fieldset > button > span");
//        sleepFor(3);
//    }
    // Test to login to Linkedin after the creation of an account.
    public void singIn()throws InterruptedException {
        typeByCss("#login-email", "NBody123@yahoo.com");
        sleepFor(1);
        typeByCss("#login-password", "Qwert1234");
        sleepFor(1);
        clickByCss("#pagekey-uno-reg-guest-home > div.header > div > form > input[type=\"submit\"]:nth-child(8)");
        sleepFor(2);
        // To select an option from the Linkedin dropdown
        Select option = new Select(driver.findElement(By.id("main-search-category")));
        // select by text
        option.selectByValue("people");
        sleepFor(3);

       // driver.findElement(By.id("main-search-category")).clear();

    }






}
