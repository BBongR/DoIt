package org.techtown.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);

        editText  = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        adapter = new SingerAdapter();

        // 데이터 추가
        adapter.addItem(new SingerItem("소녀시대"  , "010-1000-1000", R.drawable.singer ));
        adapter.addItem(new SingerItem("걸스데이"  , "010-2000-2000", R.drawable.singer2));
        adapter.addItem(new SingerItem("여자친구"  , "010-3000-3000", R.drawable.singer3));
        adapter.addItem(new SingerItem("티아라"    , "010-4000-4000", R.drawable.singer4));
        adapter.addItem(new SingerItem("애프터스쿨", "010-5000-5000", R.drawable.singer5));

        listView.setAdapter(adapter);

        // 리스트뷰 클릭한 부분 리스너 호출
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택: " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        // 추가
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name   = editText.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new SingerItem(name, mobile, R.drawable.face));
                adapter.notifyDataSetChanged();
            }
        });
    }

    class SingerAdapter extends BaseAdapter {

        // 데이터를 담을수 있는 것만 정의
        ArrayList<SingerItem> items = new ArrayList();

        @Override
        public int getCount() {
            return items.size();
        }

        // 밖에서 데이터를 추가하기 위해 addItem 메서드 만들기
        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // 어댑터가 데이터를 관리하기 때문에
        // 데이터를 관리하는 어댑터가 화면에 보여질 각각의 아이템을 위한 뷰를 만들어야한다.
        // 부분화면을 정의 - layout 생성
        // 하나의 item 을 위한 레이아웃 생성
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView view = null; // 어떤 뷰든 context 객체를 받게 되어있다

            // 뷰의 재사용 (이 코드를 안해주면 데이터가 많을때 끊어지는 현상 발생)
            if (convertView == null) {
                view = new SingerItemView(getApplicationContext());
            } else {
                view = (SingerItemView) convertView;
            }

            SingerItem item = items.get(position);
            view.setName  (item.getName()  );
            view.setMobile(item.getMobile());
            view.setImage (item.getResId() );

            return view;
        }
    }
}
