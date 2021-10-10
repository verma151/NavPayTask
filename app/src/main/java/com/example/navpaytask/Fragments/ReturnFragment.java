package com.example.navpaytask.Fragments;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.navpaytask.R;
import com.example.navpaytask.adapter.FriendsAdapter;
import com.example.navpaytask.data;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReturnFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReturnFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReturnFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReturnFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReturnFragment newInstance(String param1, String param2) {
        ReturnFragment fragment = new ReturnFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView freindsReturnRV;
    ImageView open,close;
    RelativeLayout relate;
    ImageView progressImageView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_return, container, false);
        freindsReturnRV=view.findViewById(R.id.freindsReturnRV);
        open=view.findViewById(R.id.freindsOpen);
        close=view.findViewById(R.id.freindsClose);
        relate=view.findViewById(R.id.relate);
        progressImageView=view.findViewById(R.id.progressImageView);
        drawCircle(progressImageView);


        relate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close.setVisibility(View.VISIBLE);
                freindsReturnRV.setVisibility(View.VISIBLE);
                open.setVisibility(View.GONE);
                relate.setVisibility(View.INVISIBLE);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close.setVisibility(View.GONE);
                freindsReturnRV.setVisibility(View.GONE);
                open.setVisibility(View.VISIBLE);
                relate.setVisibility(View.VISIBLE);
            }
        });

        List<data> dataList =new ArrayList<>();
        data data =new data("name","Ananya Rao","7d ago",getResources().getString(R.string.rupee)+"3,332");
        dataList.add(data);
        data =new data("name","Rajashi Prakash","3d ago",getResources().getString(R.string.rupee)+"800");
        dataList.add(data);
        data =new data("name","Harshada Nikam","4d ago",getResources().getString(R.string.rupee)+"250");
        dataList.add(data);
        data =new data("name","John Born","6d ago",getResources().getString(R.string.rupee)+"50");
        dataList.add(data);


        FriendsAdapter friendsAdapter=new FriendsAdapter(getContext(), dataList);
        freindsReturnRV.setAdapter(friendsAdapter);



        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void drawCircle(ImageView iv2) {


        Bitmap b = Bitmap.createBitmap(300, 300,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b);
        Paint paint = new Paint();

        paint.setColor(getContext().getColor(R.color.white));
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(150, 150, 140, paint);

        paint.setColor(getContext().getColor(R.color.color1));
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL);
        RectF oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);
        oval.set(10,10,290,290);
        canvas.drawArc(oval, 270,301f, false, paint);

        paint.setColor(getContext().getColor(R.color.color2));
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL);
        oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);
        oval.set(10,10,290,290);
        canvas.drawArc(oval, 572,47f, false, paint);

        paint.setColor(getContext().getColor(R.color.color3));
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL);
        oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);
        oval.set(10,10,290,290);
        canvas.drawArc(oval, 620,9f, false, paint);


        TextPaint textPaint=new TextPaint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(60);
        textPaint.setColor(getContext().getColor(R.color.black));
        textPaint.setStrokeWidth(2);

        canvas.drawText(93+"%", 160, 140+(textPaint.getTextSize()/4), textPaint);

        textPaint.setTextSize(30);
        textPaint.setColor(getContext().getColor(R.color.black1));
        textPaint.setStrokeWidth(2);

        canvas.drawText("returned", 150, 140+(textPaint.getTextSize()*2), textPaint);
        iv2.setImageBitmap(b);
    }
}