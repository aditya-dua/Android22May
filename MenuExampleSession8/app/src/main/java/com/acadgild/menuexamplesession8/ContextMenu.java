package com.acadgild.menuexamplesession8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by AdityaDua on 09/06/17.
 */

public class ContextMenu extends AppCompatActivity {

    ListView listView;
    ArrayList<String> contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_main);

        contacts=new ArrayList<String>();
        for(int i=0;i<10;i++){
            contacts.add(" VALUE :: "+i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contacts);
        listView =(ListView) findViewById(R.id.list1);
        listView.setAdapter(adapter);
        /** In relataion to a particular view context menu will operate**/
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Edit Value");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        /** for fields
         * List view 1
         *
         * groupid , item id ,order **/

        menu.add(0,100,2,"Context Menu 1");
        menu.add(0,101,1,"Context Menu 2");
        menu.add(0,101,3,"Context Menu 3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId()==100 && item.getGroupId()==0){
            Toast.makeText(getApplicationContext(),"Item is Clicked with ID "+item.getItemId(),Toast.LENGTH_LONG).show();

        }
        else if(item.getItemId()==101 && item.getGroupId()==0){
            Toast.makeText(getApplicationContext(),"Item is Clicked with ID "+item.getItemId(),Toast.LENGTH_LONG).show();

        }
        else
        {
            return  false;

        }
        return super.onContextItemSelected(item);
    }
}
