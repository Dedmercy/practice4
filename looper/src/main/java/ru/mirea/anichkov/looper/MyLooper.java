package ru.mirea.anichkov.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.TimeUnit;


public class MyLooper extends Thread{
    private int number;
    Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Log.d("MyLooper", number + ":"+ msg.getData().getString("KEY"));
                number++;
            }
        };
        Looper.loop();
    }
}
