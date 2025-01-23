package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{

    TextView result;
    String operationButton;
    Boolean isOperation=false;
    int num1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById((R.id.textViewResult));
        result.setText("");
    }

    public void ActsFunc(View view)
    {
        if (result.getText().toString().isEmpty())
        {
            return;
        }
        if(isOperation)
        {
            EqualFunc(view);
        }
        Button oper = (Button) view;
        operationButton=oper.getText().toString();
        num1 = Integer.parseInt(result.getText().toString());
        result.setText("");
        isOperation = true;
    }

    public void NumFunc(View view)
    {
        Button button = (Button) view;
        result.append(button.getText().toString());
    }

    public void EqualFunc(View view)
    {
        if (result.getText().toString().isEmpty())
        {
            return;
        }
        int num2=Integer.parseInt(result.getText().toString());
        isOperation=false;
        switch(operationButton)
        {
            case "+" :
                result.setText(String.valueOf(num1+num2));
                break;
            case "-" :
                result.setText(String.valueOf(num1-num2));
                break;
            case "x" :
                result.setText(String.valueOf(num1*num2));
                break;
            case "÷" :
                if(num2==0)
                {
                    break;
                }
                result.setText(String.valueOf(num1/num2));
                break;

        }
    }

    public void PlusMinusFunc(View view)
    {
        if (result.getText().toString().isEmpty())
        {
            return;
        }
        int num=Integer.parseInt(result.getText().toString());
        result.setText(String.valueOf(num *= -1));
    }

    public void ClearFunc(View view)
    {
        result.setText("");
        isOperation=false;

    }

    public void ClearOneCharFunc(View view)
    {
        if (result.getText().toString().isEmpty())
        {
            return;
        }
        String currentText = result.getText().toString();
        result.setText(currentText.substring(0,currentText.length()-1));
    }
}

