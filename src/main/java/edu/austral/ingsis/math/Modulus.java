package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public class Modulus implements Expression {
    private final Expression value;

    public Modulus(Expression value) {
        this.value = value;
    }

    @Override
    public Double calculate() {
        return Math.abs(value.calculate());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitModulus(this);
    }
}
