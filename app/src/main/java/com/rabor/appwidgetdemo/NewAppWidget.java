package com.rabor.appwidgetdemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Created by Joy on 10/3/2016.
 */

public class NewAppWidget extends AppWidgetProvider {

    public void onUpdate (Context context, AppWidgetManager appWidgetManager,
                          int[] appWidgetIds) {

        for(int i = 0; i < appWidgetIds.length; i++) {
            int currentWidgetId = appWidgetIds[i];
            Intent intent = new Intent(Intent.ACTION_VIEW);  // displays the widget
            intent.setData(Uri.parse("sms:"));  // sends an intent to open a specific URI
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0); // pending intent is a token that you give a foreign applicatio which allows the foreign application to use your application's permissions to execute a predefined piece of code.
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.activity_main); // Remote views (known as the RemoteView class in the Android platform) allow your application to programmatically supply a remote UI to the home screen in another process.
            views.setOnClickPendingIntent(R.id.msgImageView, pendingIntent);  // launches the provided pending intent
            appWidgetManager.updateAppWidget(currentWidgetId, views);
        }

    }

}
