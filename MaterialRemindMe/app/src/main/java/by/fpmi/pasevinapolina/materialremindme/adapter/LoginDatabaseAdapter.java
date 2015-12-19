package by.fpmi.pasevinapolina.materialremindme.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import by.fpmi.pasevinapolina.materialremindme.DatabaseHelper;

public class LoginDatabaseAdapter
{
    public static final String DATABASE_NAME = "login.db";

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_CREATE = "create table " + "LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text, PASSWORD text, NAME text); ";

    public SQLiteDatabase db;
    private final Context context;
    private DatabaseHelper dbHelper;
    public  LoginDatabaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public  LoginDatabaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }


    public void insertEntry(String userName,String password, String name)
    {
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);
        newValues.put("NAME", name);
        db.insert("LOGIN", null, newValues);
        Toast.makeText(context, "User Info Saved", Toast.LENGTH_LONG).show();


    }

    public int deleteEntry(String UserName)
    {
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
        Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;

    }

    public String getPassword(String username)
    {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{username}, null, null, null);
        if(cursor.getCount() < 1)
            return "NOT EXIST";
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        return password;
    }

    public String getName(String username) {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{username}, null, null, null);
        if(cursor.getCount() < 1)
            return "NOT EXIST";
        cursor.moveToFirst();
        String name= cursor.getString(cursor.getColumnIndex("NAME"));
        return name;
    }

    public void  updateEntry(String userName,String password, String name)
    {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);
        updatedValues.put("NAME", name);
        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{userName});

    }


}