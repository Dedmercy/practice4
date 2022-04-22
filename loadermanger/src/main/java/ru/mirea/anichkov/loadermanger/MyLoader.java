package ru.mirea.anichkov.loadermanger;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class MyLoader extends AsyncTaskLoader<String> {

    private String name;
    public static final String AGS_WORD = "word";


    public MyLoader(@NonNull Context context, Bundle bundle) {
        super(context);
        if(bundle != null){
            name = bundle.getString(AGS_WORD);
        }
    }
    @Override
    public void onStartLoading(){
        super.onStartLoading();
        forceLoad();
    }
    @Nullable
    @Override
    public String loadInBackground() {
        SystemClock.sleep(5000);
        return name;
    }
}
