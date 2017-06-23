package com.acadgild.listviewdemosession7;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;
import org.w3c.dom.Text;

import java.util.List;

/** All my app has permissions => Share the code for SMS
 * SORT by timestamp
 * Read and search for OTP ...contains("OTP")
 *
 * PDU... text.. sender .. timestamp...ORDER  String**/
/**
 * STEPS TO CREATE A LISTVIEW ::
 * 1. Create a ListView in XML File
 * 2. Create the string arrays that are to be shown in the List View.....
 *                  Options : In string.xml
 *                          : Where in the user will enter
 *                          : Create a string array itself
 *                          : You are fetching the array as an API reponse
 *                          : You are fetching the results from Database(SQLLITE| CREATE | query(...sleection , contions, groupby)
 * 3. Create a Adaptor with parameters as :
 *                  Parameters : Context
 *                             : Row item
 *                             : Array or the resource
 * 4. Set adaptor method is called
 * 5. Set the OnItemClickListener....
 *
 *
 *
 *
 */

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] subject=new String[]{
            "English"
    };
   // ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmsManager sms =SmsManager.getDefault();
        sms.sendTextMessage("8826661888",null,"HI! TESTING",null,null);
        /**
         * Initialize the listView


        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView)findViewById(R.id.textView2);
                String elemnet = tv.getText().toString();
                subject=new String[]{
                        "English",
                        "Hindi",
                        "Maths",
                        "Science",
                        "Social Science",
                        "Computers",
                         elemnet
                };

                list.setAdapter(adapter);
            }
        });
         */

        list=(ListView)findViewById(R.id.list);

        Bitmap[] image=new Bitmap[4];

        //ArrayAdapter<Bitmap> adapter=new ArrayAdapter<Bitmap>(getApplicationContext(),R.layout.example,image);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getApplicationContext(),android.R.layout.simple_list_item_1,subject);
        list.setAdapter(adapter);

        /**
         * List View's Listener :
         * OnItemCLickListener....
         * onClick()
         */
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,"Item clicked is ::"+subject[position],Toast.LENGTH_LONG).show();
            }
        });


    }

}
