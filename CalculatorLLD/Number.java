package CalculatorLLD;

public class Number implements ArithmeticExpression {
    public int value;

    Number(int value) {
        this.value=value;
    }

    public int evaluate() {
        System.out.println("The number value is: "+value);
        return value;
    }
}
