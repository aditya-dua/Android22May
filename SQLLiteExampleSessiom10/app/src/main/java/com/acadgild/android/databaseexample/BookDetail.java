package com.acadgild.android.databaseexample;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.acadgild.android.databaseexample.database.DBHelper;
import com.acadgild.android.databaseexample.utils.CommonUtilities;
import com.acadgild.android.databaseexample.utils.Constants;

/**
 * Created by AdityaDua on 21/06/17.
 */

public class BookDetail extends AppCompatActivity {


    TextView bookTitle;
    TextView authorName;
    EditText title_edt;
    EditText author_edt;

    DBHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        bookTitle =(TextView) findViewById(R.id.title);
        authorName =(TextView) findViewById(R.id.author);


        title_edt= (EditText) findViewById(R.id.titleEdit);
        author_edt =(EditText)findViewById(R.id.authorEdit);

        Intent intent=getIntent();
        String id=intent.getStringExtra(Constants.BOOK_ID);

        db= CommonUtilities.getDBObject(this);

        String bookName=db.getValue(Constants.BOOK_RECORD,Constants.BOOK_NAME,Constants.BOOK_ID+"  = '"+id+"'");
        String author_Name=db.getValue(Constants.BOOK_RECORD,Constants.BOOK_AUTHOR,Constants.BOOK_ID+"  = '"+id+"'");


        bookTitle.setText(bookName);
        authorName.setText(author_Name);
    }

    public void update(View v){
        ContentValues cv= new ContentValues();
        //cv.put(Constants.BOOK_ID,ids[i]);
        cv.put(Constants.BOOK_AUTHOR,author_edt.getText().toString());
        cv.put(Constants.BOOK_NAME,title_edt.getText().toString());


        db.updateRecords(Constants.BOOK_RECORD,cv,Constants.BOOK_ID+" ='"+getIntent().getExtras().getString(Constants.BOOK_ID)+"'",null);

        Toast.makeText(getApplicationContext(),"Book Updated",Toast.LENGTH_LONG).show();
        finish();
    }

    public void delete(View v){
        db.deleteRecords(Constants.BOOK_RECORD,Constants.BOOK_ID+" ='"+getIntent().getExtras().getString(Constants.BOOK_ID)+"'",null);
        finish();
    }


}
