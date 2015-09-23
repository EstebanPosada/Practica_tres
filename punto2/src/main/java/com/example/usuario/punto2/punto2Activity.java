package com.example.usuario.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class punto2Activity extends AppCompatActivity {

    EditText Numero1;
    EditText Numero2;
    //RadioGroup Opera;
    Button Calc;
    TextView Resultado;
    int selrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);

        final RadioGroup groupsel = (RadioGroup) findViewById(R.id.rgOps);
        Numero1 = (EditText) findViewById(R.id.eNum1);
        Numero2 = (EditText) findViewById(R.id.eNum2);
        //Opera = (RadioGroup) findViewById(R.id.rgOps);
        Calc = (Button) findViewById(R.id.bCalc);
        Resultado = (TextView) findViewById(R.id.tShow);



        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int selId = groupsel.getCheckedRadioButtonId();

                if (Numero1.getText().toString().equals(""))
                    Resultado.setText("Num1 is missing");
                else if (Numero2.getText().toString().equals(""))
                    Resultado.setText("Num2 is missing");
                else{
                    double valor1, valor2;
                valor1 = Double.parseDouble(Numero1.getText().toString());
                valor2 = Double.parseDouble(Numero2.getText().toString());

                /*else if (Numero2.getText().toString().equals(""))
                    Resultado.setText("Num2 inválido");*/



                    switch (selId) {
                        case R.id.rbAdd:
                            Resultado.setText(String.valueOf(valor1 + valor2));
                            break;
                        case R.id.rbSubs:
                            Resultado.setText(String.valueOf(valor1 - valor2));
                            break;
                        case R.id.rbMul:
                            Resultado.setText(String.valueOf(valor1 * valor2));
                            break;
                        case R.id.rbDiv:
                            Resultado.setText(String.valueOf(valor1 / valor2));
                            break;
                        default:
                            Resultado.setText("Select Op");
                        break;
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
