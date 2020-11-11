package VoLap.example.appLoship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.circleview.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    GridView gridHinhAnh;
    ArrayList<GridViewBean> arrayList;
    GridViewBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Anhxa();

        adapter = new GridViewBaseAdapter(this,R.layout.activity_picture,arrayList);
        gridHinhAnh.setAdapter(adapter);

        BottomNavigationView btnview;
        btnview = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        btnview.setSelectedItemId(R.id.service);

        btnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), GameHomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.service:
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
    private void Anhxa(){
        gridHinhAnh = (GridView)findViewById(R.id.gridviewServices);
        arrayList = new ArrayList<>();
        arrayList.add(new GridViewBean("Nghe nhạc",R.drawable.app1));
        arrayList.add(new GridViewBean("Học lập trình",R.drawable.app2));
        arrayList.add(new GridViewBean("Edit Video",R.drawable.app3));
        arrayList.add(new GridViewBean("Edit ảnh",R.drawable.app4));
        arrayList.add(new GridViewBean("chơi game",R.drawable.game6));
        arrayList.add(new GridViewBean("xem Youtobe",R.drawable.app6));
    }

}
