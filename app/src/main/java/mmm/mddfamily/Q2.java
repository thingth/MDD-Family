package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Q2 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q2);
    }

    public void nq3(View v)
    {
        Intent nq3 = new Intent(this, Q3.class);
        startActivity(nq3);
    }

    public void bq1(View v)
    {
        Intent bq1 = new Intent(this, Q1.class);
        startActivity(bq1);
    }
}