package Domilexus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Domilexus.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    AssertJUnit.assertFalse("".equals(homepage.header.getText()));
  }
}
