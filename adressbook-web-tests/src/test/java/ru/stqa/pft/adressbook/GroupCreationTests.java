package ru.stqa.pft.adressbook;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://testadress.ru/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("/html/body/div/div[4]/form/input[3]")).click();
  }

  @Test
  public void testGroupCreation() throws Exception {
    gotogrouppage();
    //зайти на вкладку группы
    initgroupcreation();
    //нажать кнопку создать новую группу
    fillgroupform(new GroupData("test11", "test22", "test33"));
    //вписать информацию
    submitgroupcreation();
    //нажать добавить информацию
    returntogrouppage();
    //нажать на вкладку группы
    marksecondgroup();
    //выдедить из списка вторую группу, которая повторно создалась
    deletegroupcreation();
    //нажать кнопку удалить выделенную группу
    returntogrouppage();
    //вернуться в вкладку группы
  }

  private void deletegroupcreation() {
    wd.findElement(By.xpath("/html/body/div/div[4]/form/input[2]")).click();
  }

  private void marksecondgroup() {
    wd.findElement(By.xpath("/html/body/div/div[4]/form/input[7]")).click();
  }

  private void returntogrouppage() {
    wd.findElement(By.xpath("/html/body/div/div[3]/ul/li[3]/a")).click();
  }

  private void submitgroupcreation() {
    wd.findElement(By.xpath("/html/body/div/div[4]/form/input[2]")).click();
  }

  private void fillgroupform(@NotNull GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initgroupcreation() {
    wd.findElement(By.name("new")).click();
  }

  private void gotogrouppage() {
    wd.findElement(By.xpath("/html/body/div/div[3]/ul/li[3]/a")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
