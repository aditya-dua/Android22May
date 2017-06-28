package com.acadgild.widgetexamplesession12;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdityaDua on 28/06/17.
 */

public class WidgetDataProvider implements android.widget.RemoteViewsService.RemoteViewsFactory {

    List<String> mCollection=new ArrayList<String>();
    Context mContext;

    public WidgetDataProvider(Context context, Intent intent) {
        mContext=context;
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {

        return mCollection.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews view = new RemoteViews(mContext.getPackageName(),android.R.layout.simple_list_item_1);
        view.setTextViewText(android.R.id.text1,mCollection.get(position));
        return view;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    private void initData(){
        mCollection.clear();

        for(int i=0;i<=10;i++){
            mCollection.add("ListView Item"+i);
        }
    }
}
