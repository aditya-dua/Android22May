package com.acadgild.widgetexamplesession12;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by AdityaDua on 28/06/17.
 */

public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new WidgetDataProvider(this,intent);
    }
}
