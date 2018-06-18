package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Q9 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q9);
    }

    public void gotoresult(View v)
    {
        Intent gotoresult = new Intent(this, Q_Result.class);
        startActivity(gotoresult);
    }

    public void bq8(View v)
    {
        Intent bq8 = new Intent(this, Q8.class);
        startActivity(bq8);
    }
}