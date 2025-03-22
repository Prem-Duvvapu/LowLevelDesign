package CalculatorLLD;

public class Expression implements ArithmeticExpression {
    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    Operation operation;

    Expression(ArithmeticExpression leftExpression,ArithmeticExpression rightExpression,Operation operation) {
        this.leftExpression=leftExpression;
        this.rightExpression=rightExpression;
        this.operation=operation;
    }

    public int evaluate() {
        int value=0;

        switch(operation) {
            case ADD:
                value=leftExpression.evaluate()+rightExpression.evaluate();
                break;
            case SUBTRACT:
                value=leftExpression.evaluate()-rightExpression.evaluate();
                break;
            case MULTIPLY:
                value=leftExpression.evaluate()*rightExpression.evaluate();
                break;
            case DIVISION:
                value=leftExpression.evaluate()*rightExpression.evaluate();
                break;
            default:
                System.out.println("Invalid operation");
        }


        return value;
    }
}
