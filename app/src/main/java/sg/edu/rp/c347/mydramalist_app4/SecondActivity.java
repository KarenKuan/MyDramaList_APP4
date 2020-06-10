package sg.edu.rp.c347.mydramalist_app4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView tvDramaTitle1, tvDramaDesc1, tvDramaReleaseDate1;
    Drama dramas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvDramaTitle1 = findViewById(R.id.tvDramaTitle);
        tvDramaDesc1 = findViewById(R.id.tvDramaDescription);
        tvDramaReleaseDate1 = findViewById(R.id.tvDramaReleaseDate);

        tvDramaTitle1.setText("Drama Title: Life on the Line (跳躍生命線)");
        tvDramaDesc1.setText("Drama Description: Life on the Line (Chinese: 跳躍生命線) is a 2018 medical drama produced by TVB. The story mainly focuses on the career of ambulance personnel, as well as the fight against time in emergency situations.");
        tvDramaReleaseDate1.setText("Drama Release Date: 8 October - 9 November 2018");

        Intent i = getIntent();
        dramas = (Drama)i.getSerializableExtra("dramas");

        tvDramaTitle1.setText(dramas.getDramaTitle());
        tvDramaDesc1.setText(dramas.getDramaDescription());
        tvDramaReleaseDate1.setText(dramas.getDramaReleaseDate());
    }
}
