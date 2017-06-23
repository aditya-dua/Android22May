package com.acadgild.android.databaseexample;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.acadgild.android.databaseexample.database.DBHelper;
import com.acadgild.android.databaseexample.model.BookData;
import com.acadgild.android.databaseexample.utils.CommonUtilities;
import com.acadgild.android.databaseexample.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    List<BookData> dataList;
    DBHelper dbHelper;

    String [] book_names=new String[]{
            "My Experiments with Truth",
            "The Secret",
            "The Alchemist",
            "Stay Hungry , Stay Foolish",
            "Steve Jobs",
            "Green Computing"
    };
    String [] author_names=new String[]{
            "M.K.Gandhi",
            "Dont Remember",
            "Paul Coehelo",
            "Rashmi Bansal",
            "William ",
            "Green Computing"
    };
    String [] ids=new String[]{
            "1234",
            "2345",
            "3456",
            "4567",
            "5678",
            "6789"
    };

    ListView list;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper= CommonUtilities.getDBObject(this);
        list =(ListView)findViewById(R.id.list);
        //int count=dbHelper.getFullCount(Constants.BOOK_RECORD,null);
        //if(count==0){
            insertBookCreate();

       // }
        list.setOnItemClickListener(this);

        dataList =dbHelper.getAllBooks();
        List<String> listTitle=new ArrayList<String>();

        for(int i=0;i<dataList.size();i++){
            listTitle.add(i,dataList.get(i).getBookName());
        }

        myAdapter = new ArrayAdapter<String>(this,R.layout.row_layout,R.id.textView,listTitle);
        myAdapter.notifyDataSetChanged();
        list.setOnItemClickListener(this);
        list.setAdapter(myAdapter);
    }
    public void insertBookCreate(){
        for(int i=0;i<book_names.length;i++){
            ContentValues cv=new ContentValues();
            cv.put(Constants.BOOK_ID,ids[i]);
            cv.put(Constants.BOOK_AUTHOR,author_names[i]);
            cv.put(Constants.BOOK_NAME,book_names[i]);

            dbHelper.insertContentValues(Constants.BOOK_RECORD,cv);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i = new Intent(this,BookDetail.class);
        i.putExtra(Constants.BOOK_ID,ids[position]);
        startActivity(i);

    }


}
