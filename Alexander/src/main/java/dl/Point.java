package dl;

public class Point {

  public static void main(String[] args) {

    double p1 = 1;
    double p2 = 3;

    System.out.println("Расстояние между точками " + p1 + " и " + p2 + " = " + distance(p1, p2));
  }

    public static double distance(double p1, double p2) {
      return p2 - p1;
    }
  }