package com.estebanposada.mainactivity.punto5;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.DatagramPacket;

public class punto5 extends AppCompatActivity {

    EditText name;
    EditText lastn;
    EditText ident;
    //int showgen=0;
    RadioGroup rggen;
    DatePicker bdate;
    Spinner bcity;
    Button info;
    CheckBox hoby1;
    CheckBox hoby2;
    CheckBox hoby3;
    CheckBox hoby4;
    CheckBox hoby5;
    CheckBox hoby6;
    TextView sname;
    TextView slname;
    TextView sid;
    TextView sdate;
    TextView sgen;
    TextView scity;
    TextView shobies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto5);

        name = (EditText) findViewById(R.id.ename);
        lastn = (EditText) findViewById(R.id.elname);
        ident = (EditText) findViewById(R.id.eid);
        bdate = (DatePicker) findViewById(R.id.dpdate);
        bdate.init(1980,0,1,null);
        bcity = (Spinner) findViewById(R.id.spcity);
        rggen = (RadioGroup) findViewById(R.id.rgsex);
        info = (Button) findViewById(R.id.bshow);
        hoby1 = (CheckBox) findViewById(R.id.cbhob1);
        hoby2 = (CheckBox) findViewById(R.id.cbhob2);
        hoby3 = (CheckBox) findViewById(R.id.cbhob3);
        hoby4 = (CheckBox) findViewById(R.id.cbhob4);
        hoby5 = (CheckBox) findViewById(R.id.cbhob5);
        hoby6 = (CheckBox) findViewById(R.id.cbhob6);
        sname = (TextView) findViewById(R.id.tshname);
        slname = (TextView) findViewById(R.id.tshlname);
        sid = (TextView) findViewById(R.id.tshid);
        sgen = (TextView) findViewById(R.id.tshgend);
        sdate = (TextView) findViewById(R.id.tshbirth);
        scity = (TextView) findViewById(R.id.tshcity);
        shobies = (TextView) findViewById(R.id.tshhob);

        sname.setVisibility(View.INVISIBLE);
        slname.setVisibility(View.INVISIBLE);
        sid.setVisibility(View.INVISIBLE);
        sgen.setVisibility(View.INVISIBLE);
        sdate.setVisibility(View.INVISIBLE);
        scity.setVisibility(View.INVISIBLE);
        shobies.setVisibility(View.INVISIBLE);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String varname,varlname,varid,date,city,hobb;
                sname.setVisibility(View.VISIBLE);
                slname.setVisibility(View.VISIBLE);
                sid.setVisibility(View.VISIBLE);
                sgen.setVisibility(View.VISIBLE);
                sdate.setVisibility(View.VISIBLE);
                scity.setVisibility(View.VISIBLE);
                shobies.setVisibility(View.VISIBLE);

                if(name.getText().toString().equals(""))
                    sname.setText("Name is miss");
                else{
                    varname=name.getText().toString();
                    sname.setText(varname);
                }
                if(lastn.getText().toString().equals(""))
                    slname.setText("Last Name is miss");
                else{
                    varlname=lastn.getText().toString();
                    slname.setText(varlname);
                }
                if(ident.getText().toString().equals(""))
                    sid.setText("Identification is miss");
                else{
                    varid=ident.getText().toString();
                    sid.setText(varid);
                }

                int selgen = rggen.getCheckedRadioButtonId();
                switch(selgen){
                    case R.id.rbf:
                        sgen.setText("Female");
                        break;
                    case R.id.rbm:
                        sgen.setText("Male");
                        break;
                    default:
                        sgen.setText("Gender is miss");
                        break;
                }


                date = String.valueOf(bdate.getDayOfMonth()+"/"+(bdate.getMonth()+1)+"/"+bdate.getYear());
                city = String.valueOf(bcity.getSelectedItem());

                hobb="Hobbies: ";
                if (hoby1.isChecked())
                    hobb+="\n\r"+hoby1.getText().toString();
                if(hoby2.isChecked())
                    hobb+="\n\r"+hoby2.getText().toString();
                if (hoby3.isChecked())
                    hobb+="\n\r"+hoby3.getText().toString();
                if(hoby4.isChecked())
                    hobb+="\n\r"+hoby4.getText().toString();
                if (hoby5.isChecked())
                    hobb+="\n\r"+hoby5.getText().toString();
                if(hoby6.isChecked())
                    hobb+="\n\r"+hoby6.getText().toString();

                sdate.setText(date);
                scity.setText(city);
                shobies.setText(hobb);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto5, menu);
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
