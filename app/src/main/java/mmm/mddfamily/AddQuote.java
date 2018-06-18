package mmm.mddfamily;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//TODO AddQuoteDB
public class AddQuote extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addquote_form);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.back_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.menu_back)
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void QuoteSubmit(View v)
    {
        AlertDialog.Builder NullAlert = new AlertDialog.Builder(this);
        NullAlert.setMessage("ฟังก์ชั่นนี้ยังไม่เปิดใช้งาน")
                .setPositiveButton("ตกลง", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        NullAlert.show();
        //add keyword and response into database
        /*AddQuoteDatabaseHelper db = new AddQuoteDatabaseHelper(this);
        db.addChatMessage(new AddQuoteDatabase("keyword", "response"));*/
    }

    public void CancelQuote(View v)
    {
        finish();
    }
}
