package com.example.profession;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

/**
 * Created by egordeev on 24.11.14.
 */
public class OpenProfessionActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_profession);
    }
    public void enterClick(View v){
        Toast.makeText(this, "enter", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplication(), ProfessionActivity.class);
        startActivity(intent);
    }

    public void cancelClick(View v){

        Toast.makeText(this, "cancel", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
    }


}