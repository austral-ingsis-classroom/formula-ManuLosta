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
    sum.getLeft().accept(this);
    sum.getRight().accept(this);
  }

  @Override
  public void visitSubtract(Subtract subtract) {
    subtract.getLeft().accept(this);
    subtract.getRight().accept(this);
  }

  @Override
  public void visitDivide(Divide divide) {
    divide.getNumerator().accept(this);
    divide.getDenominator().accept(this);
  }

  @Override
  public void visitMultiply(Multiply multiply) {
    multiply.getLeft().accept(this);
    multiply.getRight().accept(this);
  }

  @Override
  public void visitPower(Power power) {
    power.getBase().accept(this);
    power.getExponent().accept(this);
  }

  @Override
  public void visitModulus(Modulus modulus) {
    modulus.getValue().accept(this);
  }

  @Override
  public void visitVariable(Variable variable) {
    variables.add(variable.getName());
  }

  public static List<String> getVariables(Expression expression) {
    VariableCollector variableCollector = new VariableCollector();
    expression.accept(variableCollector);
    return variableCollector.variables;
  }
}
