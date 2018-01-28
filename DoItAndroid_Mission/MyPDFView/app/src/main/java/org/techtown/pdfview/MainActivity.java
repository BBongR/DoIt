package org.techtown.pdfview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText edit01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit01 = findViewById(R.id.edit01);
        Button openBtn = findViewById(R.id.openBtn);
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = edit01.getText().toString();
                if (filename.length() > 0) {
                    openPDF(filename.trim());
                } else {
                    Toast.makeText(getApplicationContext(), "PDF 파일명을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openPDF(String contentsPath) {
        File file = new File(contentsPath);

        if (file.exists()) {
            Uri path = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(path, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(this, "PDF 파일을 보기 위한 뷰어 앱이 없습니다.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "PDF 파일이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
