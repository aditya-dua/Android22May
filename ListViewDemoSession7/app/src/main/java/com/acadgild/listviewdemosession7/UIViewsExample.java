package com.acadgild.listviewdemosession7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by AdityaDua on 07/06/17.
 */

public class UIViewsExample extends AppCompatActivity implements View.OnClickListener{

    EditText name,phone;
    RadioGroup gender;
    Button submitbtn;
    CheckBox engChkbx,fluencyChkbx,ieltsChkbx,toeflChkbx;
    //RadioButton male,female;
    Spinner age_group;
    String[] age=new String[]{"15-18","19-22","23-30","31 & Still Alive"};
    String selected_age_group;
    String selected_gender;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        gender=(RadioGroup)findViewById(R.id.gender_group);
        engChkbx=(CheckBox)findViewById(R.id.english_chk);
        fluencyChkbx=(CheckBox)findViewById(R.id.fluency_chk);
        ieltsChkbx=(CheckBox)findViewById(R.id.ielts_chk);
        toeflChkbx=(CheckBox)findViewById(R.id.toefl_chk);
        age_group=(Spinner) findViewById(R.id.age_grup);

        submitbtn=(Button)findViewById(R.id.submit);
        submitbtn.setOnClickListener(this);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_dropdown_item,age);

        age_group.setAdapter(adapter);

        age_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_age_group=age[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.male){
                    selected_gender="Male";
                }
                else{
                    selected_gender="Female";
                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        String form="Name :"+name.getText().toString()+"\n"+
                "Phone :"+phone.getText().toString()+"\n"+
                "Gender:"+selected_gender+"\n"+
                "Age   :"+selected_age_group+"\n"+
                "Eng   :"+engChkbx.isChecked()+"\n"+
                "Fluency:"+fluencyChkbx.isChecked()+"\n"+
                "IELTS  :"+ieltsChkbx.isChecked()+"\n"+
                "TOEFL  :"+toeflChkbx.isChecked();

        Toast.makeText(getApplicationContext(),form,Toast.LENGTH_LONG).show();
    }
}
