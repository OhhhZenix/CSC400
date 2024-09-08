import java.util.Stack;

public class InfixCalculator {
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

  private boolean isValidToken(char character) {
    return Character.isDigit(character)
        || isOperator(character)
        || character == '('
        || character == ')'
        || Character.isWhitespace(character);
  }

  private String sanitize(String expression) throws Exception {
    if (expression.isEmpty()) {
      throw new Exception("Empty expression");
    }

    StringBuilder sanitizedExpression = new StringBuilder();
    boolean lastWasOperator = true; // Start true to handle leading digits properly

    for (char character : expression.toCharArray()) {
      if (!isValidToken(character)) {
        throw new Exception(String.format("Invalid character detected: %s", character));
      }

      if (Character.isWhitespace(character)) {
        continue; // Skip whitespace
      }

      if (isOperator(character)) {
        if (lastWasOperator) {
          throw new Exception("Invalid operator sequence detected");
        }
        lastWasOperator = true;
      } else {
        lastWasOperator = false;
      }

      sanitizedExpression.append(character);
    }

    if (lastWasOperator) {
      throw new Exception("Expression cannot end with an operator");
    }

    return sanitizedExpression.toString();
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
        throw new Exception("Unsupported operator: " + operator);
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
      char character = expression.charAt(i);

      // Extract digits
      if (Character.isDigit(character)) {
        StringBuilder number = new StringBuilder();

        while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
          number.append(expression.charAt(i));
          i++;
        }
        // Adjust for loop increment
        i--;

        operandTokens.push(Integer.parseInt(number.toString()));
      }
      // Extract operator
      else if (isOperator(character)) {
        while (!operatorTokens.isEmpty()
            && precedence(character) <= precedence(operatorTokens.peek())) {
          int b = operandTokens.pop();
          int a = operandTokens.pop();
          int result = calculate(a, b, operatorTokens.pop());
          operandTokens.push(result);
        }
        operatorTokens.push(character);
      } else if (character == '(') {
        operatorTokens.push(character);
      } else if (character == ')') {
        if (!operatorTokens.contains('(')) {
          throw new Exception(String.format("Mismatched parentheses"));
        }

        while (operatorTokens.peek() != '(') {
          int b = operandTokens.pop();
          int a = operandTokens.pop();
          int result = calculate(a, b, operatorTokens.pop());
          operandTokens.push(result);
        }

        // Remove '('
        operatorTokens.pop();
      }
    }

    while (!operatorTokens.isEmpty()) {
      if (operatorTokens.peek() == '(') {
        throw new Exception("Mismatched parentheses");
      }
      int b = operandTokens.pop();
      int a = operandTokens.pop();
      int result = calculate(a, b, operatorTokens.pop());
      operandTokens.push(result);
    }

    if (operandTokens.size() != 1) {
      throw new Exception("Invalid expression");
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
