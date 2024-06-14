package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

import java.util.Map;

public class Modulus implements Expression {
    private final Expression value;

    public Modulus(Expression value) {
        this.value = value;
    }

    @Override
    public Double calculate(Map<String, Expression> variables) {
        return Math.abs(value.calculate(variables));
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
