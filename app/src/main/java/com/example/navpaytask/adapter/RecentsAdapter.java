package com.example.navpaytask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navpaytask.OnClick;
import com.example.navpaytask.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.ViewHolder> {
    Context context;
    String names[];
    OnClick onClick;

    public RecentsAdapter(Context context, String[] names, OnClick onClick) {
        this.context = context;
        this.names = names;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public RecentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_layout, parent, false);
        return new RecentsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageDrawable(context.getDrawable(R.drawable.person));
        holder.name.setText(names[position]);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClick(names[holder.getAdapterPosition()]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CircleImageView imageView;
        RelativeLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.layout);
            name =itemView.findViewById(R.id.nameTextView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
