package CalculatorLLD;

public class Main {
    //(2*(3+1))

    /*
                *
              /   \
             2     +
                  / \
                 3   1
     */

     public static void main(String[] args) {
         ArithmeticExpression number2=new Number(2);
         ArithmeticExpression number3=new Number(3);
         ArithmeticExpression number1=new Number(1);

         ArithmeticExpression addExpression=new Expression(number3, number1, Operation.ADD);
         ArithmeticExpression parentExpression=new Expression(number2,addExpression,Operation.MULTIPLY);

         System.out.println("The expression (2*(3+1)) value is: "+parentExpression.evaluate());
     }
}
