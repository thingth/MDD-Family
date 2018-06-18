package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AppSettings extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appsettings);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        View teachAi = findViewById(R.id.teach_ai);
        teachAi.setOnClickListener(this);
        View commenT = findViewById(R.id.comment);
        commenT.setOnClickListener(this);
        View appInfo = findViewById(R.id.app_info);
        appInfo.setOnClickListener(this);
        View devInfo = findViewById(R.id.developer_info);
        devInfo.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.back_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_back)
        {
            Intent msgAi = new Intent(this, WatsonChatroom_ani.class);
            startActivity(msgAi);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v)
    {
        int id = v.getId();
        if (id == R.id.teach_ai) {
            Intent teachAi = new Intent(this, AddQuote.class);
            startActivity(teachAi);
        }
        if (id == R.id.comment) {
            Intent commenT = new Intent(this, Comment.class);
            startActivity(commenT);
        }
        if (id == R.id.app_info) {
            Intent appInfo = new Intent(this, AppInfo.class);
            startActivity(appInfo);
        }
        if (id == R.id.developer_info){
            Intent devInfo = new Intent(this, DevInfo.class);
            startActivity(devInfo);
        }
    }
}
