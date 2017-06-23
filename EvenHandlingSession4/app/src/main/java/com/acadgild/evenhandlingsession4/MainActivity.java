package com.acadgild.evenhandlingsession4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    static int clickCounter=0;
    final String CLASS_NAME="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String METHOD_NAME="onCreate";
        Log.i("Execution started of ::",CLASS_NAME+"  "+METHOD_NAME);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button click=(Button)findViewById(R.id.button);
        click.setOnClickListener(new View.OnClickListener() {
            /**
             * First I create a button in my XML file...
             * Once the button is created in XML file it will have a reference in R.java
             * public static int button = 0x078797989;
             * Creating the Object of the Button....
             * Button b = (Button) findViewById(R.id.button);
             * R.id.button => int value........
             *
             * Whenever the button is clicked I have to perform operation...
             * it will be a link code which will wait till the button is clicked.....
             *
             * Now , image there are 3 button () which button is clicked ... it will fetch the view
             * and pass
             *
             *
             *
             * Anonymonous Inner Class Declaration
             * @param v
             */
            @Override
            public void onClick(View v) {

                TextView tv = (TextView)findViewById(R.id.textview);
                String text = tv.getText().toString();
                clickCounter++;
                try {
                    tv.setText("Text Changed " + clickCounter);
                    Log.i("Event Handler Info", "Text Changed " + clickCounter);
                }catch (Exception e){
                    Log.e("Exception",e.toString());
                }
                tv.setBackground(getDrawable(R.mipmap.ic_launcher));
                int i = v.getId();
                String id= " "+i;
                Log.i("Event Handler Info",id);
            }
        });
        Log.i("End Of Execution::",CLASS_NAME+"  "+METHOD_NAME);
    }


    public void buttonClicked(View v){
        Toast.makeText(getApplicationContext(),"Button Clicked",Toast.LENGTH_LONG).show();

    }

}
