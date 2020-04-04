package com.example.sensor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import android.util.Log;

public class ScreenReceiver extends BroadcastReceiver {
    public static boolean wasScreenOn = true;
    int Count=0;

    @Override
    public void onReceive(final Context context, final Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            // do whatever you need to do here
            Log.e("LOB","onReceive");
            Count++;
            Log.e("COUNT",""+Count);
            if(Count==2){
                //Send SMS code..

                wasScreenOn = true;
                Intent MyIntentService = new Intent(context, BackgroundSoundService.class);
                context.startService(MyIntentService);
                Log.e("LOB","wasScreenOn"+wasScreenOn);

                Log.e("lskbdvjkbsdf",""+Count);

                Log.e("fjkvfskj",""+Count);
            }
            else if (Count == 3)
            {
                wasScreenOn = true;
                Intent MyIntentService = new Intent(context, BackgroundSoundService.class);
                context.stopService(MyIntentService);
                Count = 0;
            }


        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            // and do whatever you need to do here

            Count ++;
            Log.e("COUNT",""+Count);
            if (Count==3)
            {
                Log.e("fdkhlkbjdfl",""+Count);
                wasScreenOn = true;
                Intent MyIntentService = new Intent(context, BackgroundSoundService.class);
                context.stopService(MyIntentService);
                Count = 0;
            }



        } else if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
            Log.e("LOB","userpresent");
            Log.e("LOB","wasScreenOn"+wasScreenOn);




        }
    }

}
