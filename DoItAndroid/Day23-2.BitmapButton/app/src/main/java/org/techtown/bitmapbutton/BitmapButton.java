package org.techtown.bitmapbutton;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2018-02-07.
 */

public class BitmapButton extends AppCompatButton {

    public BitmapButton(Context context) {
        super(context);

        init(context);
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        setBackgroundResource(R.drawable.bitmap_button_normal);

        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(textSize);
        setTextColor(Color.WHITE);
        setPadding(30, 30, 30, 30);
    }

    @Override // 버튼을 클릭했을 때 호출되는 메서드
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(R.drawable.bitmap_button_clicked);
                setPadding(30, 30, 30, 30);
                break;

            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.bitmap_button_normal);
                setPadding(30, 30, 30, 30);
                break;

        }

        invalidate(); // 버튼을 다시 그리게 됨

        return true;
    }
}
