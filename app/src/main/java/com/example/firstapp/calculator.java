package com.example.firstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class calculator extends AppCompatActivity {
    TextView calculation,result;
    String curr,res;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnplus,btnminus,btnmulty,btndiv,btnequal,btndot,btnclear,btndel;
    boolean dot_inserted,operator_inserted;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        curr="";
        res="";
        dot_inserted=false;
        operator_inserted=false;


        calculation=findViewById(R.id.calculation);
        result=findViewById(R.id.result);
        btnplus=findViewById(R.id.btnplus);
        btnminus=findViewById(R.id.btnminus);
        btnmulty=findViewById(R.id.btnmulty);
        btndiv=findViewById(R.id.btndiv);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btndot=findViewById(R.id.btndot);
        btnequal=findViewById(R.id.btnequal);
        btnclear=findViewById(R.id.clear);
        btndel=findViewById(R.id.del);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"0";
                displayCalculation();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"1";
                displayCalculation();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"2";
                displayCalculation();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"3";
                displayCalculation();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"4";
                displayCalculation();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"5";
                displayCalculation();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"6";
                displayCalculation();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"7";
                displayCalculation();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"8";
                displayCalculation();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+"9";
                displayCalculation();
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(curr.isEmpty()){
                   curr="0.";
                   dot_inserted = true;
               }


                if(dot_inserted==false){
                    curr=curr+".";
                    dot_inserted = true;
                }
                displayCalculation();
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               clear();
               displayResult();
                displayCalculation();
            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
                displayCalculation();
            }
        });


        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        delete();
                    }
                    if(operator_inserted==false){
                        curr=curr+" + ";
                        operator_inserted=true;
                    }
                }

                displayCalculation();
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        delete();
                    }
                    if(operator_inserted==false){
                        curr=curr+" - ";
                        operator_inserted=true;
                    }
                }

                displayCalculation();
            }
        });
        btnmulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        delete();
                    }
                    if(operator_inserted==false){
                        curr=curr+" * ";
                        operator_inserted=true;
                    }
                }

                displayCalculation();
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        delete();
                    }
                    if(operator_inserted==false){
                        curr=curr+" / ";
                        operator_inserted=true;
                    }
                }

                displayCalculation();
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator_inserted == true && !curr.substring(curr.length()-1, curr.length()).equals(" ")){
                    String[]  tokens = curr.split(" ");

                    if(tokens[1].charAt(0) == '+'){
                        res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                    }
                    if(tokens[1].charAt(0) == '-'){
                        res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                    }
                    if(tokens[1].charAt(0) == '*'){
                        res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                    }
                    if(tokens[1].charAt(0) == '/'){
                        res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                    }
                }
                displayResult();
            }
        });
    }
    public void displayCalculation(){
        calculation.setText(curr);
    }
    public void displayResult(){
        result.setText(res);
    }
    public void clear(){
        curr="";
        res="";
        dot_inserted=false;
        operator_inserted=false;
    }
    public void delete(){
        if(!curr.isEmpty()){
            curr=curr.substring(0,curr.length()-1);
        }
    }

}