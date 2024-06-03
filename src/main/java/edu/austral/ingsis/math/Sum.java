package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public class Sum implements Expression {
    private final Expression left;
    private final Expression right;

    public Sum(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Double calculate() {
        return left.calculate() + right.calculate();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSum(this);
    }
}
