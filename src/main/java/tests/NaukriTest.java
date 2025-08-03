package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.ResumeHeadlinePage;

public class NaukriTest extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        NaukriTest test = new NaukriTest();
        test.setUp();

        HomePage home = new HomePage(test.driver);
        LoginPage login = new LoginPage(test.driver);
        ProfilePage profile = new ProfilePage(test.driver);
        ResumeHeadlinePage resume = new ResumeHeadlinePage(test.driver);

        home.clickLogin();
        login.login("adityawankhade441@gmail.com", "Love@0406");
        //Thread.sleep(5000); // Optional wait

        profile.navigateToProfile();
        resume.updateHeadline();

        test.tearDown();
    }
}
