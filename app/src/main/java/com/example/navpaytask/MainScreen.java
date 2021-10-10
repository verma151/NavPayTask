package com.example.navpaytask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.navpaytask.Fragments.ReceiveFragment;
import com.example.navpaytask.Fragments.ReturnFragment;
import com.example.navpaytask.adapter.RecentsAdapter;
import com.example.navpaytask.adapter.UpcomingAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainScreen extends AppCompatActivity {
    CircleImageView img5, recentbtn;
    TextView tv5,frequent,recTV,tv1;
    RelativeLayout pbottomSheet;
    public static String current_name="";
    RecyclerView recentsrv;
    TableRow Row;
    //declaring the names of the user for Recycler View
    String[] names = {
            "Sukshagar",
            "Red DP",
            "Ramesh",
            "Mukesh",
            "Manish",
            "Prakash",
            "Rakesh",
            "Mukesh",
            "Red DP",
            "Saksha",
            "Sakshi",
            "Sampreet",
            "John",
            "Suresh",
            "Ramesh",
            "Mukesh",
            "Manish",
            "Prakash",
            "Rakesh",
            "Mukesh",
            "Harender",
            "Sukshagar",
            "McDonalds",
            "Harender",
            "Harol",
            "Halli",
            "Red DP",
            "Saksha",
            "Sakshi",
            "Sampreet",
            "John",
            "Suresh",
            "Ramesh",
            "Mukesh",
            "Manish",
            "Prakash",
            "Rakesh",
            "Mukesh",
            "Harender",
            "Sukshagar",
            "McDonalds",
            "Harender",
            "Harol",
            "Halli",
            "Red DP",
            "Saksha",
            "Sakshi",
            "Sampreet",
            "John",
            "Suresh",
            "Ramesh",
            "Mukesh",
            "Manish",
            "Prakash",
            "Rakesh",
            "Mukesh",

    };
    RecentsAdapter recentsAdapter;
    TableLayout tableLayout;
    CoordinatorLayout bottomLayout;

    CustomScrollView scrollView;
    TextView recenttv, recenttvfixed, recentsbtntv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
        getSupportActionBar().hide();
        img5=findViewById(R.id.user5);
        tv5=findViewById(R.id.user5TV);
        frequent=findViewById(R.id.frequest_users);
        recentbtn =findViewById(R.id.recentsBTN);
        bottomLayout=findViewById(R.id.bottomLayout);
        recTV=findViewById(R.id.recentsBTNTV);
        scrollView=findViewById(R.id.scrollView);
        Row =findViewById(R.id.tablerow);
        tableLayout=findViewById(R.id.tableLayout);
        recenttv =findViewById(R.id.recent_users);
        recenttvfixed =findViewById(R.id.recent_use);
        recentsbtntv =findViewById(R.id.recentsBTNTV);
        recentsrv =findViewById(R.id.recentsRecyclerView);
        tv1=findViewById(R.id.topTV);
        OnClick onClick=new OnClick() {
            @Override
            public void onClick(String name) {
                openScreen4(name);
            }
        };
        recentsrv.setLayoutManager(new GridLayoutManager(this, 5));
        recentsAdapter=new RecentsAdapter(this,names,onClick);
        recentsrv.setAdapter(recentsAdapter);



        pbottomSheet = findViewById(R.id.your_account);
        init_persistent_bottomsheet();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("return", ReturnFragment.class)
                .add("receive", ReceiveFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    isRecieve=false;
                }else{
                    isRecieve=true;
                }
            }

        });

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);


        bottomSheetDialog=new BottomSheetDialog(MainScreen.this);
        bottomSheetDialog.setContentView(R.layout.balance_history);

        bottomfullheight(bottomSheetDialog);
        bottomSheetDialog.getBehavior().setFitToContents(true);
        ImageView closebtn=bottomSheetDialog.findViewById(R.id.closeBTN);
        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });
        scrollView.smoothScrollTo(0,0);
        scrollView.setEnableScrolling(false);
    }
    BottomSheetDialog bottomSheetDialog;


    private void bottomfullheight(BottomSheetDialog bottomSheetDialog) {
        FrameLayout bottomSheet = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();

        int windowHeight = getWindowHeight();
        if (layoutParams != null) {
            layoutParams.height = windowHeight;
        }
        bottomSheet.setLayoutParams(layoutParams);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private int getWindowHeight() {
        // Calculate window height for fullscreen use
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
    private void openScreen4(String name) {
        //if Bottom Dialog is showing then close
        if(bottomSheetDialog.isShowing()){
            bottomSheetDialog.dismiss();
        }
        //else add the following details
        List<data> dataList =new ArrayList<>();
        data data =new data(name,"Pragati","22 Aug",getResources().getString(R.string.rupee)+"87");
        dataList.add(data);



        UpcomingAdapter upcomingAdapter=new UpcomingAdapter(MainScreen.this, dataList);


        TextView nameTV=bottomSheetDialog.findViewById(R.id.userName);
        TextView upiTV=bottomSheetDialog.findViewById(R.id.upiTV);
        CircleImageView profileIV=bottomSheetDialog.findViewById(R.id.profile_image);
        RecyclerView upcomingRV=bottomSheetDialog.findViewById(R.id.upcomingRV);
        upcomingRV.setAdapter(upcomingAdapter);

        nameTV.setText(name);
        upiTV.setText(name.toLowerCase()+"@okhdfc");

        bottomSheetDialog.show();

    }

    public void openEmpty(String name){
        current_name=name;
        startActivity(new Intent(MainScreen.this,empty.class));
    }
    ImageView iv_trigger;
    BottomSheetBehavior behavior;
    public static boolean isRecieve=false;
    public void init_persistent_bottomsheet() {

        iv_trigger = (ImageView) pbottomSheet.findViewById(R.id.upBTN);
        behavior = BottomSheetBehavior.from(pbottomSheet);
        behavior.setDraggable(false);


        iv_trigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             cancelRecycler();
            }
        });

        if (behavior != null)
            behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    //showing the different states
                    switch (newState) {
                        case BottomSheetBehavior.STATE_HIDDEN:
                            break;
                        case BottomSheetBehavior.STATE_EXPANDED:
                            iv_trigger.setVisibility(View.GONE);


                            pbottomSheet.setBackground(getResources().getDrawable(R.drawable.bootom_sheet_expand));
                            cancelRecycler();
                            break;
                        case BottomSheetBehavior.STATE_COLLAPSED:
                            pbottomSheet.setBackground(getResources().getDrawable(R.drawable.bootom_sheet_collap));
                            iv_trigger.setVisibility(View.VISIBLE);
                            recents(null);
                            break;
                        case BottomSheetBehavior.STATE_DRAGGING:
                            break;
                        case BottomSheetBehavior.STATE_SETTLING:
                            break;
                    }
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                    // React to dragging events

                }
            });

        extracted();


    }

    private void extracted() {
        new CountDownTimer(100, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                int[] location = new int[2];
                recentsbtntv.getLocationOnScreen(location);
                if(location[1]==0){
                    extracted();
                    return;
                }
                RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) bottomLayout.getLayoutParams();
                params.topMargin= location[1];
                bottomLayout.setLayoutParams(params);
                bottomLayout.requestLayout();
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                iv_trigger.setVisibility(View.GONE);
            }
        }.start();
    }


    boolean moreOpen=false;
    public void back(View view) {
        if(moreOpen){
            moreOpen=false;
        }else{
            finish();
        }
    }

    public void recents(View view) {
        recentbtn.setVisibility(View.GONE);
        recTV.setVisibility(View.GONE);
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        frequent.setVisibility(View.VISIBLE);
        img5.setVisibility(View.VISIBLE);
        tv5.setVisibility(View.VISIBLE);
        Row.setVisibility(View.VISIBLE);
        recenttv.setVisibility(View.VISIBLE);
        scrollView.setEnabled(true);
        scrollView.setEnableScrolling(true);


    }

    public void cancelRecycler(){
        scrollView.scrollTo(0,0);
        scrollView.setEnableScrolling(false);
        recentbtn.setVisibility(View.VISIBLE);
        recTV.setVisibility(View.VISIBLE);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        frequent.setVisibility(View.GONE);
        img5.setVisibility(View.GONE);
        tv5.setVisibility(View.GONE);

        Row.setVisibility(View.GONE);
        scrollView.setEnabled(false);



    }
        //creating upper 7 user profile
    public void name1(View view) {
        openScreen4("Harshada");
    }
    public void name2(View view) {
        openScreen4("Naveen");
    }
    public void name3(View view) {
        openScreen4("Vivek");
    }
    public void name4(View view) {
        openScreen4("Rahul");
    }
    public void name5(View view) {
        openScreen4("Naveepriya");
    }
    public void name6(View view) {
        openScreen4("Subhash");
    }
    public void name7(View view) {
        openScreen4("Ramshankar");
    }


    boolean showing=false;
    public void showRecentUsers(View view) {
        TextView tv=(TextView) view;
        if(showing){
            showing=false;
            tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
            recentsrv.setVisibility(View.GONE);
        }else{
            showing=true;
            tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0);
            recentsrv.setVisibility(View.VISIBLE);

        }

    }
    //For
    public void Message(View view) {
        openEmpty("Message");
    }

    public void Transactions(View view) {
        openEmpty("Transactions");
    }
}