public class Main {

  public static void main(String[] args) {
    InfixCalculator calculator = new InfixCalculator();

    calculator.compute("(4 + 2) * 3");
    calculator.compute("5 + (3 * 7)");
    calculator.compute("4 + 2 * 3");

    // try (Scanner scanner = new Scanner(System.in)) {
    //   while (true) {
    //     System.out.println("Enter an infix expression or type 'q' to quit");
    //     String input = scanner.nextLine();
    //
    //     if (input.equalsIgnoreCase("q")) {
    //       break;
    //     }
    //
    //     calculator.compute(input);
    //   }
    // }
    //
    // System.out.println("Bye bye now!");
  }
}
