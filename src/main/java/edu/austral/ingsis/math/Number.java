package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;
import java.util.Map;

public class Number implements Expression {
  private final Double value;

  public Number(Double value) {
    this.value = value;
  }

  public Double getValue() {
    return value;
  }

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
