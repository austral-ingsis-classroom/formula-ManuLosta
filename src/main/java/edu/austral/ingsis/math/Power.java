package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;
import java.util.Map;

public class Power implements Expression {
  private final Expression base;
  private final Expression exponent;

  public Power(Expression base, Expression exponent) {
    this.base = base;
    this.exponent = exponent;
  }

  public Expression getBase() {
    return base;
  }

  public Expression getExponent() {
    return exponent;
  }

  @Override
  public Double calculate(Map<String, Expression> variables) {
    return Math.pow(base.calculate(variables), exponent.calculate(variables));
  }

  @Override
  public Double calculate() {
    return Math.pow(base.calculate(), exponent.calculate());
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitPower(this);
  }
}
