using NUnit.Framework;
using OpenQA.Selenium;


namespace CianTest
{
    public class Tests
    {
        private IWebDriver driver;

        private readonly By signInButton = By.XPath("//span[text()='Войти']");
        private readonly By loginInputButton = By.XPath("//input[@name='username']");
        private readonly By otherLoginButton = By.XPath("//button[@data-name='SwitchToEmailAuthBtn']");
        private readonly By continueButton = By.XPath("//button[@data-name='ContinueAuthBtn']");
        private readonly By passButton = By.XPath("//input[@name='password']");
        private readonly By userAvatar = By.XPath("//a[@data-name='UserAvatar']");
        private readonly By actualId = By.XPath("//div[@class='_25d45facb5--user-name--oMFPn']");



        private const string loginMail = "tester18000@mail.ru";
        private const string cianpw = "cianpassw";
        private const string myId = "ID 92178388";


        [SetUp]
        public void Setup()
        {
            driver = new OpenQA.Selenium.Chrome.ChromeDriver();
            driver.Navigate().GoToUrl("https://cian.ru");
            driver.Manage().Window.Maximize();
        }

        [Test]
        public void Test1()
        {
            var signIn = driver.FindElement(signInButton);
            signIn.Click();

            var otherBut = driver.FindElement(otherLoginButton);
            otherBut.Click();

            var login = driver.FindElement(loginInputButton);
            login.SendKeys(loginMail);

            var continueBut = driver.FindElement(continueButton);
            continueBut.Click();

            Thread.Sleep(1500);
            var pass = driver.FindElement(passButton);
            pass.SendKeys(cianpw);
            
            var signInFin = driver.FindElement(continueButton);
            signInFin.Click();

            Thread.Sleep(1500);
            var userAva = driver.FindElement(userAvatar);
            userAva.Click();

            var myActualId = driver.FindElement(actualId).Text;

            Assert.AreEqual(myId, myActualId, "Login is wrong.");   


        }

        [TearDown]
        public void TearDown()
        {

        }
    }
}