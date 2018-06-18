package mmm.mddfamily;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AI_choose extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ai_choose);
    }

    public void button1(View v)
    {
        Intent next = new Intent(this, WatsonChatroom_ani.class);
        startActivity(next);
    }

    //TODO collapse button2 and 3 to button1
    public void button2(View v)
    {
        AlertDialog.Builder NullAlert = new AlertDialog.Builder(this);
        NullAlert.setMessage("ฟังก์ชั่นนี้ยังไม่เปิดใช้งาน")
                .setPositiveButton("ตกลง", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        NullAlert.show();
    }
}