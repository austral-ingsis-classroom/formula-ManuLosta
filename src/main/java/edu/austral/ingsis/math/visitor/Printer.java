package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.*;
import edu.austral.ingsis.math.Number;
import java.util.Stack;

public class Printer implements Visitor {
  private final StringBuilder stringBuilder;
  private final Stack<Boolean> needsParenthesesStack;

  private Printer() {
    this.stringBuilder = new StringBuilder();
    this.needsParenthesesStack = new Stack<>();
  }

  @Override
  public void visitNumber(Number number) {
    stringBuilder.append(number.getValue());
  }

  @Override
  public void visitSum(Sum sum) {
    handleBinaryOperation(sum.getLeft(), sum.getRight(), "+");
  }

  @Override
  public void visitSubtract(Subtract subtract) {
    handleBinaryOperation(subtract.getLeft(), subtract.getRight(), "-");
  }

  @Override
  public void visitDivide(Divide divide) {
    handleBinaryOperation(divide.getNumerator(), divide.getDenominator(), "/");
  }

  @Override
  public void visitMultiply(Multiply multiply) {
    handleBinaryOperation(multiply.getLeft(), multiply.getRight(), "*");
  }

  @Override
  public void visitPower(Power power) {
    handleBinaryOperation(power.getBase(), power.getExponent(), "^");
  }

  @Override
  public void visitModulus(Modulus modulus) {
    stringBuilder.append("|");
    modulus.getValue().accept(this);
    stringBuilder.append("|");
  }

  @Override
  public void visitVariable(Variable variable) {
    stringBuilder.append(variable.getName());
  }

  private void handleBinaryOperation(Expression left, Expression right, String operator) {
    boolean needsParentheses = !needsParenthesesStack.isEmpty() && needsParenthesesStack.peek();
    if (needsParentheses) stringBuilder.append("(");

    needsParenthesesStack.push(true);

    needsParenthesesStack.push(true);
    left.accept(this);
    stringBuilder.append(" ");
    stringBuilder.append(operator);
    stringBuilder.append(" ");
    right.accept(this);
    needsParenthesesStack.pop();

    if (needsParentheses) stringBuilder.append(")");
  }

  public static String print(Expression expression) {
    final Printer printer = new Printer();
    expression.accept(printer);
    return printer.stringBuilder.toString();
  }
}
