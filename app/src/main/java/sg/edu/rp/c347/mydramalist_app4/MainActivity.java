package sg.edu.rp.c347.mydramalist_app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvType;
    ArrayList<String> alDramas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvType = findViewById(R.id.lvType);

        alDramas = new ArrayList<String>();
        alDramas.add("Dramas");
    }
}
