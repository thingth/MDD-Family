package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Q5 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q5);
    }

    public void nq6(View v)
    {
        Intent next = new Intent(this, Q6.class);
        startActivity(next);
    }

    public void bq4(View v)
    {
        Intent back = new Intent(this, Q4.class);
        startActivity(back);
    }
}