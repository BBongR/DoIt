package org.techtown.myparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private static final String KEY_NAMES = "names";
    private static final String KEY_DATA = "data";

    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra(KEY_NAMES);
            if (names != null) {
                Toast.makeText(getApplicationContext(), "전달받은 이름 리스트 개수: " + names.size(), Toast.LENGTH_SHORT).show();
            }

            SimpleData data = intent.getParcelableExtra(KEY_DATA);
            if (data != null) {
                Toast.makeText(getApplicationContext(), "전달받은 SimpleData: " + data.number + "," + data.message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
