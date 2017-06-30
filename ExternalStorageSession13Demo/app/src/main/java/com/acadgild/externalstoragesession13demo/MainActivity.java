package com.acadgild.externalstoragesession13demo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {


    EditText editTextFileName,editTextData;
    Button saveButton,readButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFileName = (EditText)findViewById(R.id.editText1);

        editTextData = (EditText)findViewById(R.id.editText2);

        saveButton=(Button)findViewById(R.id.button1);
        readButton=(Button)findViewById(R.id.button2);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName= editTextFileName.getText().toString();
                String data=editTextData.getText().toString();

                FileOutputStream fos;
                try{
                    File myFile=new File(Environment.getExternalStorageDirectory()+
                            "/"+fileName+".txt");
                    myFile.createNewFile();
                    FileOutputStream fOut=new FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter= new OutputStreamWriter(fOut);
                    myOutWriter.append(data);
                    myOutWriter.close();
                    fOut.close();
                    Toast.makeText(getApplicationContext(),"File :"+fileName+".txt Saved !",Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fileName=editTextFileName.getText().toString();
                StringBuffer stringBuffer=new StringBuffer();

                String aDataRow="";
                String aBuffer="";

                try{
                    File myfile=new File("/sdcard/"+fileName);
                    FileInputStream fIn= new FileInputStream(myfile);
                    BufferedReader myReader= new BufferedReader(new InputStreamReader(fIn));

                    while((aDataRow=myReader.readLine())!=null){
                        aBuffer+=aBuffer+"\n";
                    }
                    myReader.close();
                    Toast.makeText(getApplicationContext(),aBuffer,Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
