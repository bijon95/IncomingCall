package com.appstcit.incomingcall;

import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Bj on 02-12-17.
 */

public class CallReceiver extends PhonecallReceiver {

    Context context;
    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
        Toast.makeText(ctx, "Called Incomming.......", Toast.LENGTH_LONG).show();
        Intent buttonUp = new Intent(Intent.ACTION_MEDIA_BUTTON);
        buttonUp.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(
                KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
        try {
            context.sendOrderedBroadcast(buttonUp,
                    "android.permission.CALL_PRIVILEGED");

            // startRecording();
        } catch (Exception e) {


        }
        context.startActivity(buttonUp);
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
    }


}