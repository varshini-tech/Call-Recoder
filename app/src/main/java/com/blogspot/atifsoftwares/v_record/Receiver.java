package com.blogspot.atifsoftwares.v_record;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
     @Override
     public void onReceive(Context context, Intent intent) {

         if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
             Intent i = new Intent();
             i.setClassName("com.blogspot.atifsoftwares.v_record", "com.blogspot.atifsoftwares.v_record.Popup");
             i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             context.startActivity(i);


             showToast(context,"Call started");


         }

         else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)){
             showToast(context,"Recording ended");
         }
     }


     Void showToast(Context context, String message)
     {
         Toast toast=Toast.makeText(context,message,Toast.LENGTH_LONG);
         toast.show();
         return null;
     }

 }
