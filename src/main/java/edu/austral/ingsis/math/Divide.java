package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;
import java.util.Map;

public class Divide implements Expression {
  private final Expression numerator;
  private final Expression denominator;

  public Divide(Expression numerator, Expression denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Expression getNumerator() {
    return numerator;
  }

  public Expression getDenominator() {
    return denominator;
  }

  @Override
  public Double calculate(Map<String, Expression> variables) {
    return numerator.calculate(variables) / denominator.calculate(variables);
  }

  @Override
  public Double calculate() {
    return numerator.calculate() / denominator.calculate();
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitDivide(this);
  }
}
