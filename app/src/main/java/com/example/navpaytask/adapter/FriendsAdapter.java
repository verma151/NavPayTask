package com.example.navpaytask.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navpaytask.R;
import com.example.navpaytask.MainScreen;
import com.example.navpaytask.data;
import com.example.navpaytask.empty;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {
    Context context;
    List<data> dataList;

    public FriendsAdapter(Context context, List<data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public FriendsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.return_user, parent, false);
        return new FriendsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsAdapter.ViewHolder holder, int position) {
        data model= dataList.get(position);
        holder.imageView.setImageDrawable(context.getDrawable(R.drawable.person));
        holder.usernametv.setText(model.getFromUser());
        holder.dateTV.setText("last interacted: "+model.getDate());
        holder.amounttv.setText(model.getAmount());


        holder.infoTV.setText("due");

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainScreen.current_name=model.getFromUser();
                context.startActivity(new Intent(context, empty.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView usernametv,dateTV, amounttv,infoTV;
        CircleImageView imageView;
        CardView layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.layout);
            infoTV=itemView.findViewById(R.id.tv);
            usernametv =itemView.findViewById(R.id.userName);
            dateTV=itemView.findViewById(R.id.dateTV);
            amounttv =itemView.findViewById(R.id.amountTV);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
