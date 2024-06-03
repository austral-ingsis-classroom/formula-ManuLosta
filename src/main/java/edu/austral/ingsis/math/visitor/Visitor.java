package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.*;
import edu.austral.ingsis.math.Number;

public interface Visitor {
    void visitNumber(Number number);
    void visitSum(Sum sum);
    void visitDivide(Divide divide);
    void visitMultiply(Multiply multiply);
    void visitPower(Power power);
    void visitModulus(Modulus modulus);
}
