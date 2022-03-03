package com.example.yash_patel_blue_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Printer;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean startNewNumber = true;
    boolean newExpression = true;

    CalculatorModel calculatorModel = new CalculatorModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(android.view.View view){

        Log.i("button","Button Clicked");
        //Identify Button
        Button button = (Button) view;

        //Convert to string
        String buttonText = button.getText().toString();
        Log.i("button","Button is: " + buttonText);

//        For displaying exact number
        TextView textView = (TextView) findViewById(R.id.numberDisplay);
        String currentNumber = textView.getText().toString();

        switch(buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                if(startNewNumber){
                    // This added
                    if(calculatorModel.firstNumberSet && calculatorModel.operatorSet && calculatorModel.secondNumberSet && newExpression){
                        calculatorModel.clear();
                    }
                    if(buttonText.equals(".")){
                        currentNumber = "0.";
                    }else {
                        currentNumber = buttonText;
                    }
                    startNewNumber = false;
                }else {
                    if(buttonText.equals(".") && currentNumber.contains(".")){
                        //do nothing
                    }else {
                        currentNumber = currentNumber + buttonText;
                    }
                }
                break;

            case "+":
            case "-":
            case "X":
            case "/":
            case "^3":
            case "%":
                if(calculatorModel.firstNumberSet && calculatorModel.operatorSet && !startNewNumber){
                    double secondNumber = Double.parseDouble(currentNumber);
                    calculatorModel.setSecondNumber(secondNumber);
                    String result = resultToString(calculatorModel.getResult());
                    currentNumber = result;
                }

                double firstNumber = Double.parseDouble(currentNumber);
                calculatorModel.setFirstNumber(firstNumber);

                calculatorModel.setOperator(buttonText);
                startNewNumber = true;
                newExpression = false;
                break;

            case "=":
                if(calculatorModel.firstNumberSet) {
                    double secondNumber = Double.parseDouble(currentNumber);
                    calculatorModel.setSecondNumber(secondNumber);

                    String result = resultToString(calculatorModel.getResult());

                    currentNumber = result;
                    startNewNumber = true;
                    newExpression = true;
                }
                break;

            case "C":
                calculatorModel.clear();
                currentNumber = "0.";
                startNewNumber = true;
                break;
        }

        textView.setText(currentNumber);
    }

    public String resultToString(double num){
        int numInt = (int) num;

        if(num == numInt){
            return Integer.toString(numInt);
        }else{
            return Double.toString(num);
        }
    }
}