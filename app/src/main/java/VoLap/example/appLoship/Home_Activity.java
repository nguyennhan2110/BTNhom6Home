package VoLap.example.appLoship;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.circleview.R;

import java.util.ArrayList;
import java.util.List;

public class  Home_Activity extends AppCompatActivity {
Button bt_GiaoDoAn;
    GridView gvHinhAnh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bt_GiaoDoAn=(Button)findViewById(R.id.bt_GiaoDoAn);
        bt_GiaoDoAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Dis2=new Intent(Home_Activity.this,GiaoDoAn_activity.class);
                startActivity(Dis2);
            }
        });
        //Gridview
        List<HinhAnhHome> image_details = AnhXa();
        final GridView gridView = (GridView) findViewById(R.id.gridviewHinhAnh);
        gridView.setAdapter(new HinhAnhHomeAdapter(this, image_details));
    }
    public List<HinhAnhHome> AnhXa(){
        List<HinhAnhHome> arrayImage = new ArrayList<>();
        arrayImage.add(new HinhAnhHome("Giao Đồ Ăn",R.drawable.ic_loship_circle));
        arrayImage.add(new HinhAnhHome("Gọi Xe",R.drawable.ic_loxe));
        arrayImage.add(new HinhAnhHome("Đi chợ",R.drawable.ic_lomart));
        arrayImage.add(new HinhAnhHome("Gửi hàng",R.drawable.ic_losend));
        arrayImage.add(new HinhAnhHome("Giặt ủi",R.drawable.ic_lozat));
        arrayImage.add(new HinhAnhHome("Mua thuốc",R.drawable.ic_lomed));
        arrayImage.add(new HinhAnhHome("Mua gì cũng có",R.drawable.ic_lozi_landing));
        arrayImage.add(new HinhAnhHome("Mua đồ thú cưng",R.drawable.ic_lopet));
        arrayImage.add(new HinhAnhHome("Mua hoa",R.drawable.ic_lohoa));
        return arrayImage;
    }
}
