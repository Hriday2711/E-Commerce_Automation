package stepDefination;

import io.cucumber.java.en.And;
import org.testng.annotations.Test;
import utils.PageObjects_Base;

public class CommonStepDefinations extends PageObjects_Base {

    @Test
    @And("Common - Refresh the Web-Page")
    public void refreshTheBrowserPage() throws Exception {
        common.refreshTheBrowserPage();
    }
}
