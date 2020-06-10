package sg.edu.rp.c347.mydramalist_app4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DelistActivity extends AppCompatActivity {

    ListView lvDel;
    ArrayList<Drama> alDramas;
    ArrayAdapter<Drama> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delist);

        lvDel = findViewById(R.id.lvDel);

        alDramas = new ArrayList<Drama>();
        DBHelper db = new DBHelper(DelistActivity.this);
        alDramas = db.getAllDrama();

        aa = new ArrayAdapter<Drama>(this, android.R.layout.simple_list_item_1, alDramas);

        lvDel.setAdapter(aa);

        lvDel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drama dramas = alDramas.get(position);
                Intent i = new Intent(DelistActivity.this, DelActivity.class);
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
                Intent i = new Intent(DelistActivity.this, MainActivity.class);

                startActivity(i);
                return true;
        }
        switch (item.getItemId()) {
            case R.id.add:
                Intent i = new Intent(DelistActivity.this, ThirdActivity.class);
                startActivity(i);
                return true;
        }
        switch (item.getItemId()) {
            case R.id.del:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Getting return response and update the arraylist
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (requestCode == requestCode) {
                DBHelper db = new DBHelper(DelistActivity.this);
                alDramas.clear();
                alDramas.addAll(db.getAllDrama());
                db.close();
                aa.notifyDataSetChanged();
            }
        }
    }
}
