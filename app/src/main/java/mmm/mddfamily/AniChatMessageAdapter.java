package mmm.mddfamily;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AniChatMessageAdapter extends ArrayAdapter<ChatMessage>
{
    private static final int USER_MESSAGE = 0, AI_MESSAGE = 1, USER_IMAGE = 2, AI_IMAGE = 3;
    public AniChatMessageAdapter(Context context, List<ChatMessage> data) {
        super(context, R.layout.ai_message_ani, data);
    }
    @Override
    public int getViewTypeCount()
    {
        return 2;
    }
    @Override
    public int getItemViewType(int position)
    {
        ChatMessage item = getItem(position);
        if (item.isMine() && !item.isImage()) return USER_MESSAGE;
        else if (!item.isMine() && !item.isImage()) return AI_MESSAGE;
        else if (item.isMine() && item.isImage()) return USER_IMAGE;
        else return AI_IMAGE;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        if (viewType == USER_MESSAGE) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_message_ani, parent, false);
            TextView textView = (TextView) convertView.findViewById(R.id.text);
            textView.setVisibility(View.INVISIBLE);
        } else if (viewType == AI_MESSAGE) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ai_message_ani, parent, false);
            TextView textView = (TextView) convertView.findViewById(R.id.text);
            textView.setText(getItem(position).getContent());
        } else if (viewType == USER_IMAGE) {
        //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user_image, parent, false);
        } else {
        //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_ai_image, parent, false);
}
        return convertView;
    }
}