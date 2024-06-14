package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

import java.util.Map;

public record Power(Expression base, Expression exponent) implements Expression {
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
