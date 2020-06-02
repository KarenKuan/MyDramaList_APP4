package sg.edu.rp.c347.mydramalist_app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvType;
    ArrayList<String> alDramas;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvType = findViewById(R.id.lvType);

        alDramas = new ArrayList<String>();
        alDramas.add("Dramas");

        aa = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, alDramas);

        lvType.setAdapter(aa);

        lvType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                String a = lvType.getItemAtPosition(position).toString();
                i.putExtra("dramas", a);
                startActivity(i);
            }
        });
    }
}
