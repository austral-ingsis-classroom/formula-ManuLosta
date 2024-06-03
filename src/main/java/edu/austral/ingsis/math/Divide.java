package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public class Divide implements Expression {
    final private Expression numerator;
    final private Expression denominator;

    public Divide(Expression numerator, Expression denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Double calculate() {
        return numerator.calculate() / denominator.calculate();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDivide(this);
    }
}
