package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Q4 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q4);
    }

    public void nq5(View v)
    {
        Intent next = new Intent(this, Q5.class);
        startActivity(next);
    }

    public void bq3(View v)
    {
        Intent back = new Intent(this, Q3.class);
        startActivity(back);
    }
}