package org.techtown.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MENU = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showBtn = findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MenuActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {
            Toast toast = Toast.makeText(getBaseContext(), "onActivityResult 메소드가 호출됨. 요청 코드 : " + requestCode + ",결과 코드 : " + resultCode, Toast.LENGTH_SHORT);
            toast.show();

            if (resultCode == RESULT_OK) {
                String name = data.getExtras().getString("name");
                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 name : " + name, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
