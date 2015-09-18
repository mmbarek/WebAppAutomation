import CommonApi.BaseClass;
import Util.DataReader;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by mounssif on 9/12/2015.
 */
public class SearchLinkedinApp extends linkedInBase{
    DataReader dr = new DataReader();
    String path ="linkedIn\\Data\\file1.xls";

    @Test

    public void searchItem() throws InterruptedException, IOException {

        typeByCss("#login-email", "NBody123@yahoo.com");
        sleepFor(1);
        typeByCss("#login-password", "Qwert1234");
        sleepFor(1);
        clickByCss("#pagekey-uno-reg-guest-home > div.header > div > form > input[type=\"submit\"]:nth-child(8)");
        sleepFor(2);
       /* typeAndEnterByCss("#main-search-box","Hanip");
        sleepFor(2);*/

       String [][] itemLocator = dr.fileReader(path);
        for (int i =1; i<itemLocator.length;i++){
            typeAndEnterByCss(itemLocator[i][0], itemLocator[i][1]);
            sleepFor(3);
        }



    }
}
