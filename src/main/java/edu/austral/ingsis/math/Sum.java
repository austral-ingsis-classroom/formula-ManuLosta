package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;
import java.util.Map;

public record Sum(Expression left, Expression right) implements Expression {
  @Override
  public Double calculate(Map<String, Expression> variables) {
    return left.calculate(variables) + right.calculate(variables);
  }

  @Override
  public Double calculate() {
    return left.calculate() + right.calculate();
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitSum(this);
  }
}
