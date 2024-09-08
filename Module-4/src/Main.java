public class Main {

  public static void main(String[] args) {
    // Create a calculator instance
    InfixCalculator calculator = new InfixCalculator();
    // Sample testing
    calculator.compute("(4 + 2) * 3");
    calculator.compute("5 + (3 * 7)");
    calculator.compute("4 + 2 * 3");
    calculator.compute("1 + 2 * (3 + (4 * 5) + 6)");
    calculator.compute("10 / 0");
    calculator.compute("2x + 2");
    calculator.compute("6(7 + 8)");
    calculator.compute("6 ++ (7 + 8)");
    calculator.compute("2 + ( 3 * 4");
    calculator.compute("2 + 3 * 4)");
    calculator.compute("");
  }
}
