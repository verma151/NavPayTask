package com.example.navpaytask.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navpaytask.R;
import com.example.navpaytask.MainScreen;
import com.example.navpaytask.data;
import com.example.navpaytask.empty;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {
    Context context;
    List<data> dataList;

    public UpcomingAdapter(Context context, List<data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UpcomingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upcoming_item_layout, parent, false);
        return new UpcomingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingAdapter.ViewHolder holder, int position) {
        data model= dataList.get(position);
        holder.imageView.setImageDrawable(context.getDrawable(R.drawable.person));
        holder.nameTV.setText(model.getName());
        holder.userNameTV.setText("Re: "+model.getFromUser());
        holder.dateTV.setText(model.getDate());
        holder.amountTV.setText(model.getAmount());
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
        TextView nameTV,userNameTV,dateTV,amountTV;
        CircleImageView imageView;
        RelativeLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.layout);
            nameTV=itemView.findViewById(R.id.nameTV);
            userNameTV=itemView.findViewById(R.id.userName);
            dateTV=itemView.findViewById(R.id.dateTV);
            amountTV=itemView.findViewById(R.id.amountTV);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
