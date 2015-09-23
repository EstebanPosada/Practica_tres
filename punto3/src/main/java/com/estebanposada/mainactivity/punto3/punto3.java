package com.estebanposada.mainactivity.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.transform.Result;

public class punto3 extends AppCompatActivity {

    EditText quiz;
    EditText expo;
    EditText plab;
    EditText pfin;
    Button calc;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto3);

        quiz = (EditText) findViewById(R.id.eQuiz);
        expo = (EditText) findViewById(R.id.eexpo);
        plab = (EditText) findViewById(R.id.ePlab);
        pfin = (EditText) findViewById(R.id.epfin);
        calc = (Button) findViewById(R.id.bcalc);
        resultado = (TextView) findViewById(R.id.tres);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quiz.getText().toString().equals("")) {
                    resultado.setText("Quiz is miss");
                } else if (expo.getText().toString().equals("")) {
                    resultado.setText("Expo is miss");
                } else if (plab.getText().toString().equals("")) {
                    resultado.setText("Labs practice is miss");
                } else if (pfin.getText().toString().equals(""))
                    resultado.setText("Final proyect is miss");
                else {

                    double q, e, l, f;

                    q = Double.parseDouble(quiz.getText().toString());
                    e = Double.parseDouble(expo.getText().toString());
                    l = Double.parseDouble(plab.getText().toString());
                    f = Double.parseDouble(pfin.getText().toString());

                    if (q > 5) resultado.setText("Incorrect quiz value");
                    else if (e > 5) resultado.setText("Incorrect expo value");
                    else if (l > 5) resultado.setText("Incorrect labs prac value");
                    else if (f > 5) resultado.setText("Incorrect final proy value");
                    else {
                        double res = q * 0.15 + e * 0.1 + l * 0.4 + f * 0.35;
                        resultado.setText(String.valueOf(res));
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto3, menu);
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
