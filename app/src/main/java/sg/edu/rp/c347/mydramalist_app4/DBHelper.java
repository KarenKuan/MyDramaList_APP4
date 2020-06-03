package sg.edu.rp.c347.mydramalist_app4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "drama.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_DRAMA = "Drama";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_RELEASE_DATE = "releasedate";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDramaTableSql = "CREATE TABLE " + TABLE_DRAMA + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_RELEASE_DATE + " TEXT )";
        db.execSQL(createDramaTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRAMA);
        // Create table(s) again
        onCreate(db);
    }

    public void insertTask(String title, String description, String releasedate) {

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        // the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_TITLE, title);
        // Store the column name as key and the date as value
        values.put(COLUMN_DESCRIPTION, description);
        // Store the column name as key and the date as value
        values.put(COLUMN_RELEASE_DATE, releasedate);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_DRAMA, null, values);
        // Close the database connection
        db.close();
    }

    public ArrayList<Drama> getAllDrama() {

        // Create an ArrayList that holds String objects
        ArrayList<Drama> dramas = new ArrayList<Drama>();
        // Select all the tasks' description
        String selectQuery = "SELECT " + COLUMN_ID + ", "
                + COLUMN_TITLE + ", "
                + COLUMN_DESCRIPTION + ", "
                + COLUMN_RELEASE_DATE
                + " FROM " + TABLE_DRAMA;

        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);

        // moveToFirst() moves to first row, null if no records
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  getString(0) retrieves first column data
                //  getString(1) return second column data
                //  getInt(0) if data is an integer value
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String description = cursor.getString(2);
                String releasedate = cursor.getString(3);
                Drama obj = new Drama(id, title, description, releasedate);
                dramas.add(obj);
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return dramas;
    }
}
