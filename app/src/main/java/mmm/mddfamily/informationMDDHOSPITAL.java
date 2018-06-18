package mmm.mddfamily;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class informationMDDHOSPITAL extends Fragment
{
    View myView;
    SQLiteDatabase hDB;
    HospitalDB DBHelper;
    Cursor mCursor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.information_hospital, container, false);

        /*ListView hospital_list = (ListView) getView().findViewById(R.id.mdd_hospital_list);

        DBHelper = new HospitalDB(getActivity());
        hDB = DBHelper.getWritableDatabase();
        mCursor = hDB.rawQuery("SELECT " + HospitalDB.COL_NAME + ", " + HospitalDB.COL_TEL + " FROM " + HospitalDB.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            dirArray.add(mCursor.getString(mCursor.getColumnIndex(HospitalDB.COL_NAME)) + "\n"
                    + "เบอร์โทรศัพท์ : " + mCursor.getString(mCursor.getColumnIndex(HospitalDB.COL_TEL)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dirArray);
        hospital_list.setAdapter(adapterDir);*/

        return myView;
    }
}
