package utils;

import actions.HomePageActions;
import interfaces.HomePageInterface;

public class PageObjects_Base {

    public static HomePageInterface homePage;
    public static void pageObjectSetup() throws Exception {

        homePage = new HomePageActions();
    }
}
