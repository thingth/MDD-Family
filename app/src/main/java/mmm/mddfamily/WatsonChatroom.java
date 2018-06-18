package mmm.mddfamily;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

public class WatsonChatroom extends AppCompatActivity
{
    private final String TAG = "Ai D. Famille";

    private EditText EditMessage;
    private FloatingActionButton ic_send;
    private FloatingActionButton ic_mic;

    private static ConversationService conversationService;

    private Handler handler = new Handler();
    public ListView msgView;
    public ArrayAdapter<String> msgList;
    Map context = new HashMap();

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watsonchatroom);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        conversationService = initConversationService();
        //Workspace ID for WCS
        final String inputWorkspaceId = getString(R.string.conversation_workspaceId);

        msgView = (ListView) findViewById(R.id.msgList);
        msgList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        msgView.setAdapter(msgList);

        EditMessage = (EditText) findViewById(R.id.msgInput);
        ic_send = (FloatingActionButton) findViewById(R.id.ic_msg_send);

        MessageResponse response = null;
        conversationAPI(String.valueOf(EditMessage.getText()), context, inputWorkspaceId);

        ic_send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String input = EditMessage.getText().toString();
                msgList.add(input);
                MessageResponse response = null;
                conversationAPI(String.valueOf(EditMessage.getText()), context, inputWorkspaceId);
                EditMessage.setText("");
            }
        });
    }

    private void showError(final Exception e)
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                Toast.makeText(WatsonChatroom.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }

    private ConversationService initConversationService()
    {
        ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03);
        String username = getString(R.string.conversation_username);
        String password = getString(R.string.conversation_password);
        service.setUsernameAndPassword(username, password);
        service.setEndPoint(getString(R.string.conversation_url));
        return service;
    }

    private abstract class EmptyTextWatcher implements TextWatcher
    {
        private boolean isEmpty = true;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            if (s.length() == 0)
            {
                isEmpty = true;
                onEmpty(true);
            }
            else if (isEmpty)
            {
                isEmpty = false;
                onEmpty(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {}

        public abstract void onEmpty(boolean empty);
    }

    /**
     * @param requestCode the request code
     * @param resultCode the result code
     * @param data the data
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void conversationAPI(String input, Map context, String workspaceId) {
        MessageRequest newMessage = new MessageRequest.Builder().inputText(input).context(context).build();

        conversationService.message(workspaceId, newMessage).enqueue(new ServiceCallback<MessageResponse>()
        {
            @Override
            public void onResponse(MessageResponse response)
            {
                //For verification
                System.out.println(response);
                displayMsg(response);
            }

            @Override
            public void onFailure(Exception e)
            {
                showError(e);
            }
        });
    };

    public void displayMsg(MessageResponse msg)
    {
        final MessageResponse mssg=msg;
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                String text = mssg.getText().get(0);

                //Show text in UI
                msgList.add(text);
                msgView.setAdapter(msgList);
                msgView.smoothScrollToPosition(msgList.getCount() - 1);

                context = mssg.getContext();
            }
        });

    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.menu_info)
        {
            Intent info = new Intent(this, Information.class);
            startActivity(info);
        }
        if (id == R.id.menu_content)
        {
            Intent content = new Intent(this, Content.class);
            startActivity(content);
        }
        if (id == R.id.menu_switch_msg_type)
        {
            Intent switch_msg_type = new Intent(this, WatsonChatroom_ani.class);
            startActivity(switch_msg_type);
        }
        if (id == R.id.menu_settings)
        {
            Intent settings = new Intent(this,AppSettings.class);
            startActivity(settings);
        }
        return super.onOptionsItemSelected(item);
    }

}
