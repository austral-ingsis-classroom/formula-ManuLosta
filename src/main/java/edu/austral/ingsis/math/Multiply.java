package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

import java.util.Map;

public class Multiply implements Expression {
    private final Expression left;
    private final Expression right;

    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Double calculate(Map<String, Expression> variables) {
        return left.calculate(variables) * right.calculate(variables);
    }

    @Override
    public Double calculate() {
        return left.calculate() * right.calculate();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMultiply(this);
    }
}
