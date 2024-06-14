package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

import java.util.Map;

public record Variable(String name) implements Expression {
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
