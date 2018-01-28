package org.techtown.lifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_ID = "pref";
    private static final int actMode = Activity.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate() 호출됨", Toast.LENGTH_SHORT).show();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart() 호출됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume() 호출됨", Toast.LENGTH_SHORT).show();

        SharedPreferences pref = getSharedPreferences(PREF_ID, actMode);
        if (pref != null && pref.contains("name")) {
            String name = pref.getString("name", "");
            Toast.makeText(this, "복구된 이름: " + name, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause() 호출됨", Toast.LENGTH_SHORT).show();

        SharedPreferences pref = getSharedPreferences(PREF_ID, actMode);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", "소녀시대");
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop() 호출됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy() 호출됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart() 호출됨", Toast.LENGTH_SHORT).show();
    }
}
