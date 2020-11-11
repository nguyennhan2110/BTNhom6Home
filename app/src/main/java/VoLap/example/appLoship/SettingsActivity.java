package VoLap.example.appLoship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.circleview.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    Button btlogout;
    ImageView imgBackChat;
    TextView tvamnhac;
    ListView lview;
    ListViewBaseAdapterProfile adapter, adapter_private;
    ArrayList<ListViewBeanProfile> arr_bean;
    ArrayList<ListViewBeanProfile> arr_bean_private;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        lview = (ListView)findViewById(R.id.list_profile);

        arr_bean = new ArrayList<ListViewBeanProfile>();

        arr_bean.add(new ListViewBeanProfile(R.drawable.ic_user, "Họ và tên : Trần Võ Lập"));
        arr_bean.add(new ListViewBeanProfile(R.drawable.ic_simple, "Ngày sinh : 30/04/2000"));
        arr_bean.add(new ListViewBeanProfile(R.drawable.ic_idea,"Trình độ học vấn : 12/12"));
        arr_bean.add(new ListViewBeanProfile(R.drawable.ic_mail, "SĐT: 0989 989899"));
        arr_bean.add(new ListViewBeanProfile(R.drawable.ic_country, "Địa chỉ : Cát Hưng - Phù Cát - Bình Định"));
        arr_bean.add(new ListViewBeanProfile(R.drawable.ic_private, "Sở thích: Chơi game và học lập trình"));
        arr_bean.add(new ListViewBeanProfile(R.drawable.icon_game, "Thành tích: Đạt top 1 ao làng Liên quân"));

        adapter = new ListViewBaseAdapterProfile(arr_bean,this);
        lview.setAdapter(adapter);

        imgBackChat = (ImageView)findViewById(R.id.backchat);
        imgBackChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, GameHomeActivity.class);
                startActivity(intent);
            }
        });
        btlogout = (Button)findViewById(R.id.logout);
        btlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView btnview;
        btnview = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        btnview.setSelectedItemId(R.id.canhan);
        btnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.service:
                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), GameHomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.canhan:
                        return true;
                }
                return false;
            }
        });
    }
}