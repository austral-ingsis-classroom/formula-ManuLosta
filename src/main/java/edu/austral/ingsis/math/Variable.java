package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public class Variable implements Expression {
    final private String name;
    final private Expression value;

    public Variable(String name, Expression value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Double calculate() {
        return value.calculate();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitVariable(this);
    }

    public String getName() {
        return name;
    }
}
