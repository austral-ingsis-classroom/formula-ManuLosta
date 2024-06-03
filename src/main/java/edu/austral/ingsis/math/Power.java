package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public class Power implements Expression {
    final private Expression base;
    final private Expression exponent;

    public Power(Expression base, Expression exponent) {
        this.base = base;
        this.exponent = exponent;
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
