package com.acadgild.materialdesigndemosession14demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.System.in;

/**
 * Created by AdityaDua on 03/07/17.
 */

public class FloatingButtonActivity extends AppCompatActivity{

    private EditText inputName,inputEmail,inputPassword;
    private TextInputLayout inputLayoutName,inputLayoutEmail,inputLayoutPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_button_layout);

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);

        inputName =(EditText) findViewById(R.id.input_name);
        inputEmail =(EditText) findViewById(R.id.input_email);
        inputPassword=(EditText) findViewById(R.id.input_password);

        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));


        btnSignUp=(Button)findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

    }

    private void submitForm(){
        if(!validateName()){
            return;
        }
        if(!validatePassword()){
            return;
        }
        if(!validateEmail()){
            return;
        }

        Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
    }

    private boolean validateName(){
        if(inputName.getText().toString().trim().isEmpty()){
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            //btnSignUp.setEnabled(false);
            return  false;
        }else if(inputName.getText().toString().length()<5){
            inputLayoutName.setError("Name cannot be less than 5 Chars");
            requestFocus(inputName);
            return  false;
        }else{
            inputLayoutName.setErrorEnabled(false);
           return  true;
        }
    }

    private boolean validateEmail(){
        if(inputEmail.getText().toString().trim().isEmpty()){
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return  false;
        }else{
            inputLayoutEmail.setErrorEnabled(false);
            return  true;
        }
    }

    private boolean validatePassword(){
        if(inputPassword.getText().toString().trim().isEmpty()){
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return  false;
        }else{
            inputLayoutPassword.setErrorEnabled(false);
            return  true;
        }
    }

    private void requestFocus(View view){

        if(view.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

    }
    private class MyTextWatcher implements TextWatcher{

        private View view;

        public MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            /** Validation Will be Done Over Here **/
            switch(view.getId()){
                case R.id.input_name : validateName(); break;
                case R.id.input_email : validateEmail(); break;
                case R.id.input_password : validatePassword(); break;
            }

        }
    }
}
