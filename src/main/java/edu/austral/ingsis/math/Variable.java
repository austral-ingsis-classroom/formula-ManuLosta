package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;
import java.util.Map;

public class Variable implements Expression {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public Double calculate(Map<String, Expression> variables) {
    return variables.get(name).calculate(variables);
  }

  @Override
  public Double calculate() {
    throw new RuntimeException("Variable not initialized");
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitVariable(this);
  }
}
