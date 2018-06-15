package com.simple.maxt.simplecalc;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEdit;

    private List<Integer> buttonIds = Arrays.asList(
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button0,
            R.id.buttonPlus,
            R.id.buttonMinus,
            R.id.buttonDivide,
            R.id.buttonMultiply,
            R.id.buttonBLeft,
            R.id.buttonBRight,
            R.id.buttonDecimal
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdit = (EditText) findViewById(R.id.editText);
        mEdit.setEnabled(false);

        for (Integer id : buttonIds) {
            addClickEvent(id);
        }


    }

    private void addClickEvent(Integer buttonId) {
        final Button button = findViewById(buttonId);
        final String textToAdd = button.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Editable text = mEdit.getText();
                mEdit.setText(text + textToAdd);
            }
        });
    }

    public void Equal(View v){
        String text = mEdit.getText().toString().replace("×", "*").replace("÷", "/");
        Expression e = new ExpressionBuilder(text).build();
        Double result = e.evaluate();
        mEdit.setText(result.toString());

    }


    public void Clear(View v) {
        mEdit.setText(null);
    }

    public void Backspace(View v) {
        Editable text = mEdit.getText();

        if (text != null && !text.toString().equals("")) {


            mEdit.setText(text.subSequence(0, text.length() - 1));

        }
    }

}
