package com.acadgild.storageexamplesession13demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    EditText text;
    static final int READ_BLOCK_SIZE=100;
    Button readBtn,writeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView)findViewById(R.id.textView);
        text = (EditText) findViewById(R.id.editText2);
        readBtn = (Button) findViewById(R.id.button);
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFile();
            }
        });
        writeBtn =(Button)findViewById(R.id.button2);
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });

    }

    public void writeFile(){
        try{
            FileOutputStream fileout= openFileOutput("myTextFile.txt",MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileout);
            outputStreamWriter.write(text.getText().toString());
            outputStreamWriter.close();
            textview.setText("Written to File");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void readFile(){
        try{
            FileInputStream fileInputStream= openFileInput("myTextFile.txt");
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);

            char [] inputBuffer=new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while((charRead=inputStreamReader.read(inputBuffer))>0){
                String readString=String.copyValueOf(inputBuffer,0,charRead);
                s+=readString;
            }
            inputStreamReader.close();

            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
