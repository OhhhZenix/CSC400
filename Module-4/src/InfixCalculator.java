import java.util.Stack;

/**
 * InfixCalculator evaluates arithmetic expressions in infix notation. It supports basic operators:
 * +, -, *, /, %, and parentheses for grouping.
 */
public class InfixCalculator {

  /**
   * Checks if the given character is a valid operator.
   *
   * @param character the character to check
   * @return true if the character is an operator (+, -, *, /, %), false otherwise
   */
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

  /**
   * Checks if the given character is a valid token in an arithmetic expression.
   *
   * @param character the character to check
   * @return true if the character is a digit, operator, parenthesis, or whitespace, false otherwise
   */
  private boolean isValidToken(char character) {
    return Character.isDigit(character)
        || isOperator(character)
        || character == '('
        || character == ')'
        || Character.isWhitespace(character);
  }

  /**
   * Sanitizes the input expression by removing whitespace and checking for invalid sequences.
   *
   * @param expression the expression to sanitize
   * @return the sanitized expression
   * @throws Exception if the expression is empty, contains invalid characters, or has invalid
   *     sequences
   */
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

  /**
   * Performs arithmetic calculation based on the operator.
   *
   * @param a the first operand
   * @param b the second operand
   * @param operator the operator
   * @return the result of the calculation
   * @throws Exception if division by zero or unsupported operator is encountered
   */
  private int calculate(int a, int b, char operator) throws Exception {
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
        throw new Exception(String.format("Unsupported operator: %s", operator));
    }
  }

  /**
   * Determines the precedence of an operator.
   *
   * @param operator the operator
   * @return the precedence level (1 for + and -, 2 for *, /, %)
   */
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

  /**
   * Evaluates the sanitized infix expression using the Shunting Yard algorithm.
   *
   * @param rawExpression the expression to evaluate
   * @return the result of the expression
   * @throws Exception if there are mismatched parentheses or invalid expressions
   */
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

  /**
   * Computes the result of the given arithmetic expression and prints it.
   *
   * @param expression the arithmetic expression to compute
   */
  public void compute(String expression) {
    try {
      int result = evaluate(expression);
      System.out.println(String.format("The result of %s is %d.", expression, result));
    } catch (Exception e) {
      System.out.println(String.format("Error: %s.", e.getMessage()));
    }
  }
}
