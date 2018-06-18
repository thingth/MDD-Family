package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Q3 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q3);
    }

    //TODO change Result tO Q4.class after finished all questions
    public void nq4(View v)
    {
        Intent nq4 = new Intent(this, Q_Result.class);
        startActivity(nq4);
    }

    public void bq2(View v)
    {
        Intent bq2 = new Intent(this, Q2.class);
        startActivity(bq2);
    }
}