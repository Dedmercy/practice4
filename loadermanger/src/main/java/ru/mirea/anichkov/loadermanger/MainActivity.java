package ru.mirea.anichkov.loadermanger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    public final String TAG = this.getClass().getSimpleName();
    private int LoaderID = 1234;
    private EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle bundle){
        if (id == LoaderID){
            Toast.makeText(this, "onCreateLoader" + id, Toast.LENGTH_SHORT).show();
            return new MyLoader(this, bundle);
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (loader.getId() == LoaderID){
            Log.d(TAG, "onLoadFinished" + data);
            Toast.makeText(this, "onLoadFinished" + data, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        Log.d(TAG, "onLoaderReset");
    }

    public void onClick(View view) {
        myEditText = findViewById(R.id.editText);
        Bundle bundle = new Bundle();
        bundle.putString(MyLoader.AGS_WORD ,myEditText.getText().toString());
        getSupportLoaderManager().initLoader(LoaderID, bundle, this);
        myEditText.setText("");
    }
}