package org.techtown.picker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    DateTimePicker picker;

    SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        picker   = (DateTimePicker)findViewById(R.id.picker);

        picker.setOnDateTimeChangeListener(new OnDateTimeChangeListener() {
            @Override
            public void onDateTimeChange(DateTimePicker view, int year, int monthOfYear, int dayOfYear, int hour, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfYear, hour, minute);
                String curTime = format.format(calendar.getTime());

                textView.setText( curTime );
            }
        });
    }
}
