package sg.edu.rp.c347.mydramalist_app4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvDrama;
    TextView tvDrama;
    ArrayList<Drama> dramas;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvDrama = (ListView) findViewById(R.id.lvDrama);
        tvDrama = (TextView) findViewById(R.id.tvDrama);

        Intent i = getIntent();
        String dramas = i.getStringExtra("dramas");
        tvDrama.setText(dramas);

    }
}
