package com.calculator.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText getTextNumber1;
    private EditText getTextNumber2;
    private EditText resultTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getTextNumber1 = findViewById(R.id.getTextNumber1);
        getTextNumber2 = findViewById(R.id.getTextNumber2);
        resultTextNumber = findViewById(R.id.resultTextNumber);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ProcessAdded(View v){
        int result = getNumber1() + getNumber2();

        printResult(result);
        setResultTextNumberReadOnly();
    }

    public void ProcessOuted(View v){
        int result = getNumber1() - getNumber2();

        printResult(result);
        setResultTextNumberReadOnly();
    }

    public void ProcessMultiply(View v){
        int result = getNumber1() * getNumber2();

        printResult(result);
        setResultTextNumberReadOnly();
    }

    public void ProcessDivision(View v){
        int result = getNumber1() / getNumber2();

        printResult(result);
        setResultTextNumberReadOnly();
    }

    public void ProcessSquareRoot(View v){
        double result = Math.sqrt(getNumber1());

        printDoubleResult(result);
        setResultTextNumberReadOnly();
    }

    public void ProcessPower(View v){
        double result = Math.pow(getDoubleNumber1(), getDoubleNumber2());

        printDoubleResult(result);
        setResultTextNumberReadOnly();
    }

    public void ProcessPercentage(View v){
        double resultPercentage = getDoubleNumber1() * (getDoubleNumber2() / 100);

        printDoubleResult(resultPercentage);
        setResultTextNumberReadOnly();
    }

    private int getNumber1() {
        return Integer.parseInt(getTextNumber1.getText().toString());
    }

    private int getNumber2() {
        return Integer.parseInt(getTextNumber2.getText().toString());
    }

    private double getDoubleNumber1() {
        return Double.parseDouble(getTextNumber1.getText().toString());
    }

    private double getDoubleNumber2() {
        return Double.parseDouble(getTextNumber2.getText().toString());
    }

    @SuppressLint("SetTextI18n")
    private void printResult(int result){
        resultTextNumber.setText("Result " + result);
    }

    @SuppressLint("SetTextI18n")
    private void printDoubleResult(double result){
        resultTextNumber.setText("Result " + result);
    }

    private void setResultTextNumberReadOnly() {
        resultTextNumber.setKeyListener(null);
        resultTextNumber.setFocusable(false);
        resultTextNumber.setClickable(false);
    }
}
