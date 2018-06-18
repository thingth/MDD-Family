package mmm.mddfamily;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AddQuoteDatabaseHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ChatMessageList";
    private static final String TABLE_QUOTE = "ChatMessage";
    private static final String KEY_ID = "id";
    private static final String KEY_KEYWORD = "keyword";
    private static final String KEY_RESPONSE = "response";

    public AddQuoteDatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_QUOTE_TABLE = "CREATE_TABLE" + TABLE_QUOTE + "(" + KEY_ID + "INTEGER PRIMARY KEY," + KEY_KEYWORD + " TEXT, " + KEY_RESPONSE + "Waiting" + ")";
        db.execSQL(CREATE_QUOTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUOTE);
        onCreate(db);
    }

    void addChatMessage(AddQuoteDatabase addQuoteDatabase)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("KEY_KEYWORD", addQuoteDatabase.getKeyword());
        values.put("KEY_RESPONSE", addQuoteDatabase.getResponse());

        db.insert(TABLE_QUOTE, null, values);
        db.close();
    }

    AddQuoteDatabase getAIChatDatabase(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_QUOTE, new String[] {KEY_ID, KEY_KEYWORD, KEY_RESPONSE}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }

        AddQuoteDatabase addQuoteDatabase = new AddQuoteDatabase(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2));
        return addQuoteDatabase;
    }

    public List<AddQuoteDatabase> getAllChatMessage()
    {
        List<AddQuoteDatabase> addQuoteDatabasesList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QUOTE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                AddQuoteDatabase addQuoteDatabase = new AddQuoteDatabase();
                addQuoteDatabase.setId(cursor.getInt(0));
                addQuoteDatabase.setKeyword(cursor.getString(1));
                addQuoteDatabase.setResponse(cursor.getString(2));

                addQuoteDatabasesList.add(addQuoteDatabase);
            } while(cursor.moveToNext());
        }
        return addQuoteDatabasesList;
    }

    public int updateAIMessageList(AddQuoteDatabase addQuoteDatabase)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("KEY_KEYWORD", addQuoteDatabase.getKeyword());
        values.put("KEY_RESPONSE", addQuoteDatabase.getResponse());

        return db.update(TABLE_QUOTE, values, KEY_ID + "=?", new String[]{String.valueOf(addQuoteDatabase.getId())});
    }

    public void deleteMessage(AddQuoteDatabase addQuoteDatabase)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_QUOTE, KEY_ID + "=?", new String[]{String.valueOf(addQuoteDatabase.getId())});
        db.close();
    }

    public int getAIMessageCount()
    {
        String countQuery = "SELECT * FROM " + TABLE_QUOTE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return  cursor.getCount();
    }
}
