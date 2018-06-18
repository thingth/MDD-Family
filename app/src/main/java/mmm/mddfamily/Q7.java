package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Q7 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q7);
    }

    public void nq8(View v)
    {
        Intent next = new Intent(this, Q8.class);
        startActivity(next);
    }

    public void bq6(View v)
    {
        Intent back = new Intent(this, Q6.class);
        startActivity(back);
    }
}