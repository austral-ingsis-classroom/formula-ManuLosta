package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public class Number implements Expression {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double calculate() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
