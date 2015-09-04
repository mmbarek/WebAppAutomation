import CommonApi.BaseClass;

/**
 * Created by mounssif on 9/3/2015.
 */
public class navigateWebApp extends BaseClass {

        public void navigateTo()throws InterruptedException{
            clickByCss("html/body/header/div/div/div/div[4]/div[2]/div[2]/a[2]");
            sleepFor(5000);
            driver.navigate().back();
            sleepFor(5000);
            clickByCss("html/body/header/div/div/div/div[4]/div[2]/div[2]/a[7]");
            sleepFor(5000);

        }

    }
