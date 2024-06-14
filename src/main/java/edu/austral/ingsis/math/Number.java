package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;
import java.util.Map;

public record Number(Double value) implements Expression {
  @Override
  public Double calculate(Map<String, Expression> variables) {
    return value;
  }

  @Override
  public Double calculate() {
    return value;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitNumber(this);
  }
}
