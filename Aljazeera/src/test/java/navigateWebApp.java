import CommonApi.BaseClass;

/**
 * Created by mounssif on 9/3/2015.
 */
public class navigateWebApp extends BaseClass {

        public void navigateTo()throws InterruptedException{
            clickByXpath("html/body/header/div/div/div/div[4]/div[2]/div[2]/a[4]");
            sleepFor(1);
            navigateBack();
            sleepFor(1);
            //navigate to sport page
            clickByXpath("html/body/header/div/div/div/div[4]/div[2]/div[2]/a[7]");
            sleepFor(1);
            typeAndEnterByCss(".header-search-input.media-body", "Real Madrid");
            sleepFor(1);

        }

    }
