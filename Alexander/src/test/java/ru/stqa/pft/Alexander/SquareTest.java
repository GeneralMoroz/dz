package ru.stqa.pft.Alexander;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTest {
@Test

  public void testArea () {
    Square s = new Square(5);
  Assert.assertEquals(s.area(),24);
  }
}
