package com.example.my_calculator;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private EditText data;
    TextView output;
    Button addorsub, division, subtraction, brackets, percentage, addition, multiplication ,clear,dot,equal,number1,number2,number3,number4,number5,number6,number7,number8,number9,number0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output=findViewById(R.id.output);

        data=findViewById(R.id.data);

        data.setShowSoftInputOnFocus(false);


        addorsub=findViewById(R.id.addorsub);
        division=findViewById(R.id.division);
        subtraction=findViewById(R.id.subtraction);
        brackets=findViewById(R.id.brackets);
        percentage=findViewById(R.id.percentage);
        addition=findViewById(R.id.addition);
        multiplication=findViewById(R.id.multiplication);
        clear=findViewById(R.id.clear);
        dot=findViewById(R.id.dot);
        equal=findViewById(R.id.equal);
        number0=findViewById(R.id.number0);
        number2=findViewById(R.id.number2);
        number3=findViewById(R.id.number3);
        number4=findViewById(R.id.number4);
        number5=findViewById(R.id.number5);
        number6=findViewById(R.id.number6);
        number7=findViewById(R.id.number7);
        number8=findViewById(R.id.number8);
        number9=findViewById(R.id.number9);
        number1=findViewById(R.id.number1);
    }

    private void updateText(String strToAdd){
        String oldStr=data.getText().toString();
        int cursorPos=data.getSelectionStart();
        String leftStr=oldStr.substring(0, cursorPos);
        String rightStr=oldStr.substring(cursorPos);
        data.setText(String.format("%s%s%s",leftStr,strToAdd, rightStr));
        data.setSelection(cursorPos + 1);
    }

    public void onTap1(View view){
        updateText("1");
    }

    public void onTap2(View view){
        updateText("2");
    }

    public void onTap3(View view) {
        updateText("3");
    }

    public void onTap4(View view){
        updateText("4");
    }

    public void onTap5(View view){
        updateText("5");
    }

    public void onTap6(View view){
        updateText("6");
    }

    public void onTap7(View view){
        updateText("7");
    }

    public void onTap8(View view){
        updateText("8");
    }

    public void onTap9(View view){
        updateText("9");
    }

    public void onTap0(View view){
        updateText("0");
    }

    public void onTapDot(View view){
        updateText(".");
    }

    public void onTapAddition(View view){
        int cursorPos = data.getSelectionStart();
        int textLen = data.getText().length();

        if (textLen!=0 && cursorPos !=0
                && !data.getText().toString().substring(textLen-1).endsWith("÷")
                && !data.getText().toString().substring(textLen-1).endsWith("×")
                && !data.getText().toString().substring(textLen-1).endsWith("%")
                && !data.getText().toString().substring(textLen-1).endsWith("-")
                && !data.getText().toString().substring(textLen-1).endsWith("+")){
            updateText("+");

        }
    }

    public void onTapSubtraction(View view){
        int cursorPos = data.getSelectionStart();
        int textLen = data.getText().length();
        if (textLen!=0 && cursorPos !=0
                && !data.getText().toString().substring(textLen-1).endsWith("÷")
                && !data.getText().toString().substring(textLen-1).endsWith("×")
                && !data.getText().toString().substring(textLen-1).endsWith("%")
                && !data.getText().toString().substring(textLen-1).endsWith("-")
                && !data.getText().toString().substring(textLen-1).endsWith("+")){
            updateText("-");

        }

    }

    public void onTapMultiplication(View view){
        int cursorPos = data.getSelectionStart();
        int textLen = data.getText().length();
        if (textLen!=0 && cursorPos !=0
                && !data.getText().toString().substring(textLen-1).endsWith("÷")
                && !data.getText().toString().substring(textLen-1).endsWith("×")
                && !data.getText().toString().substring(textLen-1).endsWith("%")
                && !data.getText().toString().substring(textLen-1).endsWith("-")
                && !data.getText().toString().substring(textLen-1).endsWith("+")){
            updateText("×");

        }
    }

    public void onTapDivision(View view){
        int cursorPos = data.getSelectionStart();
        int textLen = data.getText().length();
        if (textLen!=0 && cursorPos !=0
            && !data.getText().toString().substring(textLen-1).endsWith("÷")
            && !data.getText().toString().substring(textLen-1).endsWith("×")
            && !data.getText().toString().substring(textLen-1).endsWith("%")
            && !data.getText().toString().substring(textLen-1).endsWith("-")
            && !data.getText().toString().substring(textLen-1).endsWith("+")){
                updateText("÷");

            }
    }

    public void onTapPercentage(View view){
        int cursorPos = data.getSelectionStart();
        int textLen = data.getText().length();
        if (textLen!=0 && cursorPos !=0
                && !data.getText().toString().substring(textLen-1).endsWith("÷")
                && !data.getText().toString().substring(textLen-1).endsWith("×")
                && !data.getText().toString().substring(textLen-1).endsWith("%")
                && !data.getText().toString().substring(textLen-1).endsWith("-")
                && !data.getText().toString().substring(textLen-1).endsWith("+")){
            updateText("%");

        }
    }


    public void onTapBrackets(View view){
        int cursorPos = data.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = data.getText().length();

        for (int i=0; i<cursorPos;++i){
            if (data.getText().toString().substring(i,i+1).equals("(")){
                openPar += 1;
            }
            if (data.getText().toString().substring(i,i+1).equals(")")){
                closePar += 1;
            }
        }
        if (closePar == openPar || data.getText().toString().substring(textLen-1).equals("(")){
            updateText("(");

        }
        else if (closePar < openPar && !data.getText().toString().substring(textLen-1).equals("(")){
            updateText(")");
        }

    }

    public void onTapClear(View view) {
        int cursorPos = data.getSelectionStart();
        int textLen = data.getText().length();
        int outputLen = output.getText().length();
        if (textLen != 0 && cursorPos != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) data.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            data.setText(selection);
            data.setSelection(cursorPos - 1);
        }
        if (outputLen != 0){
            output.setText("");
        }

    }

    public void onTapEqual(View view){
        int cursorPos = data.getSelectionStart();
        int textLen = data.getText().length();
        if (textLen!=0 && cursorPos !=0
                && !data.getText().toString().substring(textLen-1).endsWith("÷")
                && !data.getText().toString().substring(textLen-1).endsWith("×")
                && !data.getText().toString().substring(textLen-1).endsWith("-")
                && !data.getText().toString().substring(textLen-1).endsWith("+")){
        String userExp = data.getText().toString();

        userExp =userExp.replaceAll("÷","/");
        userExp = userExp.replaceAll("×","*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        output.setText(result);
    }}

    public void onTapAddorSub(View view) {
        int cursorPos = data.getSelectionStart();
        updateText("(-");
        data.setSelection(cursorPos + 2);
    }

}
