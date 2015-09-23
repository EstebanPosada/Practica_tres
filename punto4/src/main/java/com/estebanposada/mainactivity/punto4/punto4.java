package com.estebanposada.mainactivity.punto4;

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

public class punto4 extends AppCompatActivity {

    RadioGroup figure;
    EditText lado;
    EditText base;
    EditText altura;
    EditText radio;
    Button calc;
    TextView result;
    int param=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto4);

        figure = (RadioGroup) findViewById(R.id.rgFig);
        lado = (EditText) findViewById(R.id.eSide);
        base = (EditText) findViewById(R.id.ebase);
        altura = (EditText) findViewById(R.id.eh);
        radio = (EditText) findViewById(R.id.erad);
        calc = (Button) findViewById(R.id.bcalc);
        result = (TextView) findViewById(R.id.tshow);

        lado.setEnabled(false);
        base.setEnabled(false);
        altura.setEnabled(false);
        radio.setEnabled(false);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double la=0,ba=0,al=0,rad=0;
                switch(param){
                    case 1:
                        if(lado.getText().toString().equals(""))
                            result.setText("Side is miss");
                        else {
                            la = Double.parseDouble(lado.getText().toString());
                            result.setText(String.valueOf(la * la));
                        }
                        break;
                    case 2:
                        if(base.getText().toString().equals(""))
                            result.setText("Base is miss");
                        else    if(altura.getText().toString().equals(""))
                            result.setText("Height is miss");
                        else {
                            ba = Double.parseDouble(base.getText().toString());
                            al = Double.parseDouble(altura.getText().toString());
                            result.setText(String.valueOf(ba * al / 2));
                        }
                        break;
                    case 3:
                        if(base.getText().toString().equals(""))
                            result.setText("Base is miss");
                        else    if(altura.getText().toString().equals(""))
                            result.setText("Height is miss");
                        else {
                            ba = Double.parseDouble(base.getText().toString());
                            al = Double.parseDouble(altura.getText().toString());
                            result.setText(String.valueOf(ba * al));
                        }
                        break;
                    case 4:
                        if(radio.getText().toString().equals(""))
                            result.setText("Radio is miss");
                        else {
                            rad = Double.parseDouble(radio.getText().toString());
                            result.setText(String.valueOf(rad * Math.PI));
                        }
                        break;
                    default:
                        result.setText("Figure not selected");
                        break;
                }
            }
        });


    }

    public void selfig(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){

                case R.id.rSq:
                    if(checked) {
                        lado.setEnabled(true);
                        base.setEnabled(false);
                        altura.setEnabled(false);
                        radio.setEnabled(false);
                        param = 1;
                    }
                    break;
                case R.id.rtr:
                    if(checked) {
                        lado.setEnabled(false);
                        base.setEnabled(true);
                        altura.setEnabled(true);
                        radio.setEnabled(false);
                        param = 2;
                    }
                    break;
                case R.id.rre:
                    if (checked) {
                        lado.setEnabled(false);
                        base.setEnabled(true);
                        altura.setEnabled(true);
                        radio.setEnabled(false);
                        param = 3;
                    }
                    break;
                case R.id.rci:
                    if (checked) {
                        lado.setEnabled(false);
                        base.setEnabled(false);
                        altura.setEnabled(false);
                        radio.setEnabled(true);
                        param = 4;
                    }
                    break;
                default:
                    result.setText("Figure not selected");
                    break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto4, menu);
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
