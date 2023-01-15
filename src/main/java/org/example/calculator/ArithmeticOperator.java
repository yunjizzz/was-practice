package org.example.calculator;


public interface ArithmeticOperator {
    boolean supports(String operator);
    int calculate(final PositiveNumber operand1, final PositiveNumber operand2);
}
