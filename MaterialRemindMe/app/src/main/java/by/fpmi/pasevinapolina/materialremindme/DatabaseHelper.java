package by.fpmi.pasevinapolina.materialremindme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import by.fpmi.pasevinapolina.materialremindme.adapter.LoginDatabaseAdapter;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public DatabaseHelper(Context context, String name,SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(LoginDatabaseAdapter.DATABASE_CREATE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        onCreate(db);
    }
}