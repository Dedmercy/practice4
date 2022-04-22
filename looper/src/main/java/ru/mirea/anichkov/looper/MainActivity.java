package ru.mirea.anichkov.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private MyLooper myLooper;
    private Message msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLooper = new MyLooper();
        myLooper.start();

    }

    public void onClick(View view) {

        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", "Student");
        msg.setData(bundle);
        if (myLooper != null) {
            try {
                TimeUnit.SECONDS.sleep(18);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLooper.handler.sendMessage(msg);
        }
    }
}

