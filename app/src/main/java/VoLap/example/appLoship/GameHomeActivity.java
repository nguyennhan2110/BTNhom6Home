package VoLap.example.appLoship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.circleview.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class GameHomeActivity extends AppCompatActivity {

    ListView lview;
    ImageView imgsetting;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamehome);

        lview = (ListView)findViewById(R.id.listfriends);
        arr_bean=new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.game1, "Hải tặc đại chiến"));
        arr_bean.add(new ListViewBean(R.drawable.game2, "Garena Free Fire"));
        arr_bean.add(new ListViewBean(R.drawable.game4,"Asphalt 8"));
        arr_bean.add(new ListViewBean(R.drawable.game5, "Maverl"));
        arr_bean.add(new ListViewBean(R.drawable.game3, "Plane and Zombe"));
        arr_bean.add(new ListViewBean(R.drawable.game6, "Garena Liên Quân Mobile"));

        adapter = new ListViewBaseAdapter(arr_bean,this);
        lview.setAdapter(adapter);

        imgsetting = (ImageView)findViewById(R.id.setting);
        imgsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameHomeActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
        BottomNavigationView btnview;
        btnview = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        btnview.setSelectedItemId(R.id.home);

        btnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.service:
                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.canhan:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}