package com.example.yash_patel_blue_calculator;

public class CalculatorModel {

    double firstNumber = 0.0;
    double secondNumber = 0.0;
    double result = 0.0;

    boolean firstNumberSet = false;
    boolean secondNumberSet = false;
    boolean operatorSet = false;

    String operator = "";

    public void setFirstNumber(double num){
        firstNumber = num;
        firstNumberSet = true;
    }

    public void setSecondNumber(double num){
        secondNumber = num;
        secondNumberSet = true;
    }

    public double getResult(){
        computeResult();
        return result;
    }

    public void computeResult(){
        if(firstNumberSet && secondNumberSet && operatorSet) {
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;

                case "-":
                    result = firstNumber - secondNumber;
                    break;

                case "X":
                    result = firstNumber * secondNumber;
                    break;

                case "/":
                    result = firstNumber / secondNumber;
                    break;

                case "%":
                    result = firstNumber % secondNumber;
                    break;

                case "^3":
                    result = firstNumber * firstNumber * firstNumber;
                    break;
            }
        }else{
            // Do
            // nothing
        }
    }

    public void setOperator(String op){
        operator = op;
        operatorSet = true;
    }

    public void clear() {
        firstNumber = 0.0;
        secondNumber = 0.0;
        result = 0.0;
        firstNumberSet = false;
        secondNumberSet = false;
        operatorSet = false;
        operator = "";
    }
}
