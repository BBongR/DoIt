package org.techtown.listview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-02-07.
 */

// 뷰를 정의할 때에는 디폴트 생성자가 2개
public class SingerItemView extends LinearLayout {

    TextView textView;
    TextView textView2;
    ImageView imageView;

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // 초기화를 위한 메서드 만들기
    // init() 메서드 안에서는 singer_item layout 을 인플레이션 메모리 객체화 해서 붙여 준다
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        textView  = findViewById(R.id.textView );
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
