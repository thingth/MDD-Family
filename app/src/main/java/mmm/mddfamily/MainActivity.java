package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        View startTxt = findViewById(R.id.startTxt);
        startTxt.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        int id = v.getId();
        if (id == R.id.startTxt)
        {
            Intent startTxt = new Intent(this, QuestionnaireActivity.class);
            startActivity(startTxt);
        }
    }
}