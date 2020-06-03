package sg.edu.rp.c347.mydramalist_app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvType;
    ArrayList<String> alDramas;
    ArrayAdapter<String> aa;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvType = findViewById(R.id.lvType);
        btnAdd = findViewById(R.id.btnAdd);

        alDramas = new ArrayList<String>();
        alDramas.add("Life on the Line (跳躍生命線)");
        alDramas.add("Deep in the Realm of Conscience (宮心計2: 深宮計)");
        alDramas.add("Flying Tiger (飛虎之潛行極戰)");
        alDramas.add("Big White Duel (白色強人)");
        alDramas.add("Wonder Women (多功能老婆)");
        alDramas.add("Guardian Angel (守護神之保險調查)");
        alDramas.add("Our Unwinding Ethos (十二傳說)");
        alDramas.add("Voice");

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
