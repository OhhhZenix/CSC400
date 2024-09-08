import java.util.Stack;

public class InfixCalculator {

  private String sanitize(String expression) {
    String[] tokens = expression.split("\\s+");
    StringBuilder santizedExpression = new StringBuilder();
    for (String token : tokens) {
      santizedExpression.append(token);
    }
    return santizedExpression.toString();
  }

  private boolean isOperator(char character) {
    switch (character) {
      case '+':
      case '-':
      case '*':
      case '/':
      case '%':
        return true;
      default:
        return false;
    }
  }

  private Integer calculate(int a, int b, char operator) throws Exception {
    switch (operator) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        if (b == 0) throw new Exception("Cannot divide by zero");
        return a / b;
      case '%':
        return a % b;
      default:
        return null;
    }
  }

  private int precedence(char operator) {
    switch (operator) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
      case '%':
        return 2;
      default:
        return -1;
    }
  }

  private int evaluate(String rawExpression) throws Exception {
    String expression = sanitize(rawExpression);
    Stack<Integer> operandTokens = new Stack<>();
    Stack<Character> operatorTokens = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      Character character = expression.charAt(i);

      // extract digits
      if (Character.isDigit(character)) {
        StringBuilder number = new StringBuilder();

        while (i < expression.length()) {
          character = expression.charAt(i);

          if (!Character.isDigit(character)) {
            break;
          }

          number.append(character);
          i += 1;
        }
        i -= 1;

        operandTokens.push(Integer.parseInt(number.toString()));
      }
      // extract operator
      else if (isOperator(character)) {
        while (!operatorTokens.isEmpty()
            && precedence(character) <= precedence(operatorTokens.peek())) {
          operandTokens.push(
              calculate(operandTokens.pop(), operandTokens.pop(), operatorTokens.pop()));
        }
        operatorTokens.push(character);
      } else if (character == '(') {
        operatorTokens.push(character);
      } else if (character == ')') {
        if (!operatorTokens.contains('(')) {
          throw new Exception("Missing '(', remove ')' or balance the expression");
        }

        while (operatorTokens.peek() != '(') {
          int b = operandTokens.pop();
          int a = operandTokens.pop();
          int result = calculate(a, b, operatorTokens.pop());
          operandTokens.push(result);
        }

        operatorTokens.pop();
      }
    }

    if (operatorTokens.contains('(')) {
      throw new Exception("Missing ')', add '(' or balance the expression");
    }

    if (operatorTokens.size() < operandTokens.size() - 1) {
      throw new Exception("Too few operators");
    }

    if (operatorTokens.size() > operandTokens.size() - 1) {
      throw new Exception("Too many operators");
    }

    while (!operatorTokens.isEmpty()) {
      int b = operandTokens.pop();
      int a = operandTokens.pop();
      int result = calculate(a, b, operatorTokens.pop());
      operandTokens.push(result);
    }

    // The top of the values stack is the result
    return operandTokens.pop();
  }

  public void compute(String expression) {
    try {
      int result = evaluate(expression);
      System.out.println(String.format("The result of %s is %d.", expression, result));
    } catch (Exception e) {
      System.out.println(String.format("Error: %s.", e.getMessage()));
    }
  }
}
