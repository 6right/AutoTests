using NUnit.Framework;
using OpenQA.Selenium;


namespace CianTest
{
    public class Tests
    {
        private IWebDriver driver;

        private readonly By signInButton = By.XPath("//span[text()='Войти']");
        private readonly By loginInputButton = By.XPath("//input[@name='username']");
        private readonly By otherLoginButton = By.XPath("//span[text()='Другим способом']");

        private const string loginMail = "kiwik950@mail.ru";

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
        }

        [TearDown]
        public void TearDown()
        {

        }
    }
}