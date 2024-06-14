package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.Visitor;

import java.util.Map;

public interface Expression {
    Double calculate(Map<String, Expression> variables);
    Double calculate();
    void accept(Visitor visitor);
}
