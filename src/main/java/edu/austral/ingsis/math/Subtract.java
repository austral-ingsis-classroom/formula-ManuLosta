package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public class Subtract implements Expression {
    final private Expression left;
    final private Expression right;

    public Subtract(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Double calculate() {
        return left.calculate() - right.calculate();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSubtract(this);
    }
}
