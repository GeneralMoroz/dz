package ru.stqa.pft.Alexander;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test

  public void testArea() {
    Square s = new Square (5);
    assert s.area() == 25;
  }
}