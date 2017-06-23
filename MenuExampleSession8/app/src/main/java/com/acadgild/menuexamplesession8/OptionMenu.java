package com.acadgild.menuexamplesession8;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by AdityaDua on 09/06/17.
 */

public class OptionMenu extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_menu);
        getSupportActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * This is used to add the resource file "menu" to the action bar
         */
        MenuInflater Menu=getMenuInflater();
        Menu.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int menuId=item.getItemId();
        if(menuId ==  R.id.Save){
            Toast.makeText(getApplicationContext(),"Values Saved Success!",Toast.LENGTH_LONG).show();
        }
        else if (menuId==R.id.Refresh)
        {
            Toast.makeText(getApplicationContext(),"Ok ! Please wait while the text is refreshed",Toast.LENGTH_LONG).show();
            TextView txt=(TextView)findViewById(R.id.textView2);
            txt.setText("Hello Android!");
        }
        return super.onOptionsItemSelected(item);
    }
}
