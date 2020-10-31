package com.example.woof.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.woof.R;

import static android.view.View.OnClickListener;

public class ChatViewHolders extends RecyclerView.ViewHolder implements OnClickListener {
    public TextView nMessage;
    public LinearLayout nContainer;

    public TextView mMatchId,mMatchName;
    public ImageView mMatchImage;

    public ChatViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mMatchId = (TextView) itemView.findViewById(R.id.Matchid);
        mMatchName = (TextView) itemView.findViewById(R.id.MatchName);
        mMatchImage = (ImageView) itemView.findViewById(R.id.MatchImage);
        nMessage = itemView.findViewById(R.id.message);
        nContainer = itemView.findViewById(R.id.container);

    }

    @Override
    public void onClick(View view ) {
        Intent intent = new Intent(view.getContext(), ChatActivity.class);
        Bundle b = new Bundle();
        b.putString("matchId", mMatchId.getText().toString());
        intent.putExtras(b);
        view.getContext().startActivity(intent);
    }
}
