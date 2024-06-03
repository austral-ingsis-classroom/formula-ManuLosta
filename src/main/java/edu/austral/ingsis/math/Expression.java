package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

public interface Expression {
    Double calculate();
    void accept(Visitor visitor);
}
