package sg.edu.rp.c347.mydramalist_app4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView tvDramaTitle1, tvDramaDesc1, tvDramaReleaseDate1;
    ArrayList<Drama> dramas;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvDramaTitle1 = findViewById(R.id.tvDramaTitle);
        tvDramaDesc1 = findViewById(R.id.tvDramaDescription);
        tvDramaReleaseDate1 = findViewById(R.id.tvDramaReleaseDate);

        dramas = new ArrayList<Drama>();

        tvDramaTitle1.setText("Drama Title: Life on the Line (跳躍生命線)");
        tvDramaDesc1.setText("Drama Description: Life on the Line (Chinese: 跳躍生命線) is a 2018 medical drama produced by TVB. The story mainly focuses on the career of ambulance personnel, as well as the fight against time in emergency situations.");
        tvDramaReleaseDate1.setText("Drama Release Date: 8 October - 9 November 2018");


        /* dramas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SecondActivity.this);
                dramas.clear();
                dramas.addAll(dbh.getAllDrama());
                dbh.close();

                String txt = "";
                for (int i = 0; i < dramas.size(); i++) {
                    Drama tmp = dramas.get(i);
                    txt += "Drama Title: " + tmp.getDramaTitle();
                }
                tvDramaTitle.setText(txt);
                aa.notifyDataSetChanged();
            }
        }); */
    }
}
