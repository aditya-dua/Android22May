package com.acadgild.widgetexamplesession12;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;

import java.io.Console;

/**
 * Created by AdityaDua on 28/06/17.
 */

public class CollectionWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context,AppWidgetManager appWidgetManager,int appWidgetId){
        RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.collection_widget);

        Log.i("updateAppWidget","RemoteViews : if will start");
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            Log.i("updateAppWidget","RemoteViews : In IF");
            setRemoteAdaptor(context,views);
        }else{
            setRemoteAdaptorV11(context,views);
        }
        Log.i("updateAppWidget","RemoteViews : IF Executed");
        appWidgetManager.updateAppWidget(appWidgetId,views);

    }
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.i("onUpdate","STARTED");
        for(int appWidgetId:appWidgetIds){
            updateAppWidget(context,appWidgetManager,appWidgetId);
            Log.i("onUpdate","for :::"+appWidgetId);
        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    /** two methods to
     * set the view Adaptor
     */
    private static void setRemoteAdaptor(Context context,final RemoteViews views){
        views.setRemoteAdapter(R.id.widget_list,new Intent(context,WidgetService.class));
    }

    private static void setRemoteAdaptorV11(Context context,final RemoteViews views){
        views.setRemoteAdapter(0,R.id.widget_list,new Intent(context,WidgetService.class));
    }
}
