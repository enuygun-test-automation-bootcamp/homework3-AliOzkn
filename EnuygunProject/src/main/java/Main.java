public class Main {
    public static void main(String[] args) {
        try {
            SignupPageTest signupPageTest = new SignupPageTest();
            signupPageTest.checkOpenMainPage();
            signupPageTest.checkOpenSignupPage();
            signupPageTest.close();


            LoginPageTest loginPage = new LoginPageTest();
            loginPage.checkOpenMainPage();
            loginPage.checkOpenLoginPage();
            loginPage.close();

        } catch (IllegalStateException e) {
            System.out.println("Install driver \n " + "Error: " + e.getMessage());
        }
    }
}
