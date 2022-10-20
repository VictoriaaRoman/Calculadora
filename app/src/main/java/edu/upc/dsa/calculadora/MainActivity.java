package edu.upc.dsa.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnSub,btnProd,btnDiv,btnSin,btnCos,btnTan,btnEqu,btnComa,btnClear;
    Switch gradRad;
    Operation operation;
    double numero1;
    double numero2;
    double resultado;
    boolean trigonometria = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textNumber);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnAdd = findViewById(R.id.buttonAdd);
        btnSub = findViewById(R.id.buttonSub);
        btnProd = findViewById(R.id.buttonProd);
        btnDiv = findViewById(R.id.buttonDiv);
        btnEqu = findViewById(R.id.buttonEquals);
        btnClear = findViewById(R.id.buttonDelete);
        btnComa = findViewById(R.id.buttonComa);
        btnSin = findViewById(R.id.buttonSin);
        btnCos = findViewById(R.id.buttonCos);
        btnTan = findViewById(R.id.buttonTan);
        gradRad = findViewById(R.id.switchRadGrad);
    }

    public void btn0Click (android.view.View v){text.setText(text.getText()+"0");}
    public void btn1Click (android.view.View v){text.setText(text.getText()+"1");}
    public void btn2Click (android.view.View v){text.setText(text.getText()+"2");}
    public void btn3Click (android.view.View v){text.setText(text.getText()+"3");}
    public void btn4Click (android.view.View v){text.setText(text.getText()+"4");}
    public void btn5Click (android.view.View v){text.setText(text.getText()+"5");}
    public void btn6Click (android.view.View v){text.setText(text.getText()+"6");}
    public void btn7Click (android.view.View v){text.setText(text.getText()+"7");}
    public void btn8Click (android.view.View v){text.setText(text.getText()+"8");}
    public void btn9Click (android.view.View v){text.setText(text.getText()+"9");}
    public void btnComaClick (android.view.View v){text.setText(text.getText()+".");}

    public void btnDeleteClick(android.view.View v){
        if (text.getText().length() > 0) {
            text.setText(text.getText().toString().substring(0, text.getText().toString().length() - 1));
        }
    }
    public void btnClearClick(android.view.View v){
        if (text.getText().length() > 0) {
            text.setText("");
        }
    }
    public void btnAddClick(android.view.View v){
        operation = new Add();
        Add add = (Add) operation;
        numero1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }
    public void btnSubClick(android.view.View v){
        operation = new Substract();
        Substract sub = (Substract) operation;
        numero1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }
    public void btnProdClick(android.view.View v){
        operation = new Product();
        Product prod = (Product) operation;
        numero1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }
    public void btnDivClick(android.view.View v){
        operation = new Division();
        Division div = (Division) operation;
        numero1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }
    public void btnSinClick(android.view.View v){
        operation = new Sin();
        Sin sin = (Sin) operation;
        trigonometria = true;
    }
    public void btnCosClick(android.view.View v){
        operation = new Cos();
        Cos cos = (Cos) operation;
        trigonometria = true;
    }
    public void btnTanClick(android.view.View v){
        operation = new Tan();
        Tan tan = (Tan) operation;
        trigonometria = true;
    }
    public void btnEqualsClick (android.view.View v){
        if (operation == null){
            return;
        }
        if (trigonometria){
            numero1 = Double.parseDouble(text.getText().toString());
            if (gradRad.isChecked()){//Trabajamos en grados
                numero2 = 1;
            }
            else {//Trabajamos en radianes
                numero2 = 0;
            }
            trigonometria = false;
        }
        else{
            numero2 = Double.parseDouble(text.getText().toString());
        }
        resultado = operation.operation(numero1, numero2);
        text.setText(String.valueOf(resultado));
    }


}