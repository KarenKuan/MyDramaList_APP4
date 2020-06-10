package sg.edu.rp.c347.mydramalist_app4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    EditText etName, etDesc, etRY;
    Button btnAdd, btnCancel;
    Drama drama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        etDesc = findViewById(R.id.editTextDescription);
        etName = findViewById(R.id.editTextName);
        etRY = findViewById(R.id.editTextYear);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etName.getText().toString().trim();
                String desc = etDesc.getText().toString().trim();
                String date = etRY.getText().toString().trim();

                //Prompt error if the Text FIeld is empty
                if (title.length() == 0) {
                    etName.setError("Please input a title");
                }
                //Prompt error if the Text FIeld is empty
                if (date.length() == 0) {
                    etRY.setError("Please input the release date");
                }
                //Prompt error if the Text FIeld is empty
                if (desc.length() == 0) {
                    etDesc.setError("Please give some description");
                }

                //If all Text field is filled up, add into Database
                if (title.length() != 0 && date.length() !=0 && desc.length() != 0) {
                    DBHelper db = new DBHelper(ThirdActivity.this);
                    db.insertDrama(title, desc, date);
                    db.close();

                    Intent i = new Intent();
                    setResult(RESULT_OK, i);
                    finish();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                Intent i = new Intent(ThirdActivity.this, MainActivity.class);

                startActivity(i);
                return true;
        }
        switch (item.getItemId()) {
            case R.id.add:
                return true;
        }
        switch (item.getItemId()) {
            case R.id.del:
                Intent i = new Intent(ThirdActivity.this, DelistActivity.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
