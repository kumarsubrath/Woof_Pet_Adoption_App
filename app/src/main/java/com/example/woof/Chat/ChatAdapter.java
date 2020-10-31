package com.example.woof.Chat;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.woof.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolders> {
    private List<ChatObject> chatList;
    private Context context;

    public ChatAdapter(List<ChatObject> matchesList, Context context){
        this.chatList = matchesList;
        this.context= context;
    }
    @Override
    public ChatViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);
        ChatViewHolders rcv = new ChatViewHolders((layoutView));
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolders holder, int position) {

        holder.nMessage.setText(chatList.get(position).getMessage());
            if(chatList.get(position).getCurrentUser()){
                holder.nMessage.setGravity(Gravity.END);
                holder.nMessage.setTextColor(Color.parseColor("#404040"));
                holder.nContainer.setBackgroundColor(Color.parseColor("#F4F4F4"));

            }else{
                holder.nMessage.setGravity(Gravity.START);
                holder.nMessage.setTextColor(Color.parseColor("#FFFFFF"));
                holder.nContainer.setBackgroundColor(Color.parseColor("#2DB4CB"));

            }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
}
