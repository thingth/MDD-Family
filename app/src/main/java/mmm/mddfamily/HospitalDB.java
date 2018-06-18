package mmm.mddfamily;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HospitalDB extends SQLiteOpenHelper
{
    private static final String DB_NAME = "HospitalDB";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Hospital";
    public static final String COL_NAME = "name";
    public static final String COL_TEL = "contact";

    public HospitalDB (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, " + COL_TEL + " TEXT);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_TEL + ") VALUES ('โรงพยาบาลกล้วยน้ำไท', '02-7692-000');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_TEL + ") VALUES ('โรงพยาบาลกรุงเทพ', '02-310-3000');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_TEL + ") VALUES ('โรงพยาบาลกรุงเทพคริสเตียน', '02-625-9000');");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
