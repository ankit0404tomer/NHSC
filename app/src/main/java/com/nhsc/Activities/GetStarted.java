package com.nhsc.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nhsc.Adapters.CustomPagerAdapter;
import com.nhsc.R;
import com.nhsc.Utils.Utils;
import com.nhsc.base.CustomSharedPreff;
import com.nhsc.home.activities.Home_Screen;
import com.nhsc.login.activities.Sign_in;
import com.nhsc.registration.activities.Register3;

import java.util.ArrayList;

/**
 * Created by balu on 04/04/18.
 */

public class GetStarted extends AppCompatActivity implements View.OnClickListener {


    TextView welcome_text;
    Utils utils;
    Button getstarted;
    private ViewPager viewPager;
    private CustomPagerAdapter myViewPagerAdapter;
    private ArrayList<String> listOfItems;
    private LinearLayout dotsLayout;
    private int dotsCount;
    CustomSharedPreff sharedPreff;

    private TextView[] dots;
    //	page change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < dotsCount; i++) {
                dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            }
            dots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.getstarted);

        ui_set();
        sharedPreff=new CustomSharedPreff(GetStarted.this);

        setViewPagerItemsWithAdapter();
        setUiPageViewController();

        onClickMethods();


    }

    public void onClickMethods() {

        getstarted.setOnClickListener(this);


    }

    private void setUiPageViewController() {
        dotsLayout = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        dotsCount = myViewPagerAdapter.getCount();
        dots = new TextView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            dotsLayout.addView(dots[i]);
        }

        dots[0].setTextColor(getResources().getColor(R.color.colorAccent));
    }

    private void setViewPagerItemsWithAdapter() {
        myViewPagerAdapter = new CustomPagerAdapter(listOfItems, GetStarted.this);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(viewPagerPageChangeListener);
    }

    public void ui_set() {

        utils = new Utils(GetStarted.this);

        getstarted = (Button) findViewById(R.id.getstarted);

        welcome_text = (TextView) findViewById(R.id.getsarted_welcome_text);


        utils.setUbuntu_Regular(getstarted);
        utils.setUbuntu_Regular(welcome_text);


        listOfItems = new ArrayList<String>();
        listOfItems.add("Each online store has its own Products, but if you want to go shopping in multiple places at once, so you only have one bag.");
        listOfItems.add("Each online store has its own Products, but if you want to go shopping in multiple places at once, so you only have one bag.");
        listOfItems.add("Each online store has its own Products, but if you want to go shopping in multiple places at once, so you only have one bag.");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //viewPager.setAdapter(new CustomPagerAdapter(this));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getstarted:
                if(sharedPreff.isLoggedIn()){
                    Intent getstarted_intent = new Intent(GetStarted.this, Home_Screen.class);
                    startActivity(getstarted_intent);
                }else{
                    Intent getstarted_intent = new Intent(GetStarted.this, Sign_in.class);
                    startActivity(getstarted_intent);
                }
                break;
        }
    }
}
