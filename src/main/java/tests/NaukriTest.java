package tests;

import base.BaseTest;
import utils.CredentialsReader;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.ResumeHeadlinePage;

public class NaukriTest extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        NaukriTest test = new NaukriTest();
        test.setUp();
        
        String email = CredentialsReader.getEmail();
        String password = CredentialsReader.getPassword();

        HomePage home = new HomePage(test.driver);
        LoginPage login = new LoginPage(test.driver);
        ProfilePage profile = new ProfilePage(test.driver);
        ResumeHeadlinePage resume = new ResumeHeadlinePage(test.driver);

        home.clickLogin();
        login.login(email, password);
        //Thread.sleep(5000); // Optional wait

        profile.navigateToProfile();
        resume.updateHeadline();

        test.tearDown();
    }
}
