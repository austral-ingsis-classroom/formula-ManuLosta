package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.*;
import edu.austral.ingsis.math.Number;
import java.util.ArrayList;
import java.util.List;

public class VariableCollector implements Visitor {
  private final List<String> variables;

  private VariableCollector() {
    this.variables = new ArrayList<>();
  }

  @Override
  public void visitNumber(Number number) {}

  @Override
  public void visitSum(Sum sum) {
    sum.left().accept(this);
    sum.right().accept(this);
  }

  @Override
  public void visitSubtract(Subtract subtract) {
    subtract.left().accept(this);
    subtract.right().accept(this);
  }

  @Override
  public void visitDivide(Divide divide) {
    divide.numerator().accept(this);
    divide.denominator().accept(this);
  }

  @Override
  public void visitMultiply(Multiply multiply) {
    multiply.left().accept(this);
    multiply.right().accept(this);
  }

  @Override
  public void visitPower(Power power) {
    power.base().accept(this);
    power.exponent().accept(this);
  }

  @Override
  public void visitModulus(Modulus modulus) {
    modulus.value().accept(this);
  }

  @Override
  public void visitVariable(Variable variable) {
    variables.add(variable.name());
  }

  public static List<String> getVariables(Expression expression) {
    VariableCollector variableCollector = new VariableCollector();
    expression.accept(variableCollector);
    return variableCollector.variables;
  }
}
