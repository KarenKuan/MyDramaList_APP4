package sg.edu.rp.c347.mydramalist_app4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DelActivity extends AppCompatActivity {

    EditText etName, etDesc, etRY;
    Button btnEdit, btnCancel, btnDel;
    Drama drama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del);

        etDesc = findViewById(R.id.editTextDescriptiondel);
        etName = findViewById(R.id.editTextNamedel);
        etRY = findViewById(R.id.editTextYeardel);
        btnEdit = findViewById(R.id.btnEdit);
        btnDel = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCanceldel);

        Intent i = getIntent();
        drama = (Drama) i.getSerializableExtra("dramas");

        etDesc.setText(drama.getDramaDescription());
        etName.setText(drama.getDramaTitle());
        etRY.setText(drama.getDramaReleaseDate());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(DelActivity.this);
                db.deleteDrama(drama.getId());
                db.close();

                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(DelActivity.this);
                String title = etName.getText().toString();
                String desc = etDesc.getText().toString();
                String date = etRY.getText().toString();
                drama.setDramaTitle(title);
                drama.setDramaDescription(desc);
                drama.setDramaReleaseDate(date);
                db.updateDrama(drama);
                db.close();

                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
