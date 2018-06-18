package mmm.mddfamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class QuestionnaireActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire);
    }

    public void Start(View v)
    {
        Intent gotoQ1 = new Intent(this, Q1.class);
        startActivity(gotoQ1);
    }

    public void Skip(View v)
    {
        Intent skip_to_chat = new Intent(this, AI_choose.class);
        startActivity(skip_to_chat);
    }

}
