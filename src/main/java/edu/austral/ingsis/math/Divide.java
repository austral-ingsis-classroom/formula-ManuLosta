package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;
import java.util.Map;

public record Divide(Expression numerator, Expression denominator) implements Expression {
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
