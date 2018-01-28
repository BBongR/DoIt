package org.techtown.myparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MENU = 1001;
    private static final String KEY_NAMES = "names";
    private static final String KEY_DATA = "data";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                ArrayList<String> names = new ArrayList();
                names.add("김진수");
                names.add("황수연");
                intent.putExtra(KEY_NAMES, names);

                SimpleData data = new SimpleData(100, "Hello");
                intent.putExtra(KEY_DATA, data);

                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }
}
