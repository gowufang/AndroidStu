package com.project.ics.mybroadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import com.project.ics.day0821rememberpassword.ActivityCollector;
import com.project.ics.day0821rememberpassword.LoginActivity;

import static android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;

/**
 * Created by Administrator on 2017/8/21.
 */

public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d("foreoffline","OnReceive");
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
                dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCollector.finishAll(); // 销毁所有活动
                        Intent intent = new Intent(context,
                                LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//需要把对话框的类型设为
                        //TYPE_SYSTEM_ALERT，不然它将无法在广播接收器里弹出
                        context.startActivity(intent); // 重新启动LoginActivity
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
// 需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(TYPE_SYSTEM_ALERT);
        alertDialog.show();


    }

}
