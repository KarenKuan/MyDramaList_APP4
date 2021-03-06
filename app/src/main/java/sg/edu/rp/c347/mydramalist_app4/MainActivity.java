package sg.edu.rp.c347.mydramalist_app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvType;
    ArrayList<Drama> alDramas;
    ArrayAdapter<Drama> aa;
    Button btnAdd;

    //When Screen is started / is shown / appear
    @Override
    protected void onStart() {
        super.onStart();

        lvType = findViewById(R.id.lvType);

        alDramas = new ArrayList<Drama>();
        alDramas.clear();
        DBHelper db = new DBHelper(MainActivity.this);
        alDramas = db.getAllDrama();

        aa = new ArrayAdapter<Drama>(this,  android.R.layout.simple_list_item_1, alDramas);

        lvType.setAdapter(aa);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvType = findViewById(R.id.lvType);

        alDramas = new ArrayList<Drama>();
        DBHelper db = new DBHelper(MainActivity.this);
        alDramas = db.getAllDrama();

        aa = new ArrayAdapter<Drama>(this,  android.R.layout.simple_list_item_1, alDramas);

        lvType.setAdapter(aa);

        lvType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drama dramas = alDramas.get(position);
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("dramas", dramas);
                startActivityForResult(i, 123);
            }
        });
    }

    //Menu Item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.dl:
                return true;
        }
        switch (item.getItemId()) {
            case R.id.add:
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);

                startActivityForResult(i, 123);
                return true;
        }
        switch (item.getItemId()) {
            case R.id.del:
                Intent i = new Intent(MainActivity.this, DelistActivity.class);

                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (requestCode == 123) {
                DBHelper db = new DBHelper(MainActivity.this);
                alDramas.clear();
                alDramas.addAll(db.getAllDrama());
                db.close();
                aa.notifyDataSetChanged();
            }
        }
    }
}
