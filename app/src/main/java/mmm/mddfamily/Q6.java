package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Q6 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q6);
    }

    public void nq7(View v)
    {
        Intent next = new Intent(this, Q7.class);
        startActivity(next);
    }

    public void bq5(View v)
    {
        Intent back = new Intent(this, Q5.class);
        startActivity(back);
    }
}