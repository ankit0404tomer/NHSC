package com.nhsc.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.nhsc.Adapters.ViewPagerAdapter;
import com.nhsc.home.fragment.Category_Tabs_Fragment;
import com.nhsc.R;

/**
 * Created by balu on 11/05/18.
 */

public class Category_Tabs extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbar_title;
    String title = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_tabs);


        toolbar = (Toolbar) findViewById(R.id.categories_toolbar);
        toolbar_title = (TextView) findViewById(R.id.categories_toolbar_title);


        Bundle b = getIntent().getExtras();

        if (b != null) {
            title = b.getString("title");
            toolbar_title.setText(title);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new Category_Tabs_Fragment(), "Chilean Wines");
        adapter.addFragment(new Category_Tabs_Fragment(), "French Wines");
        adapter.addFragment(new Category_Tabs_Fragment(), "French Wines");
        adapter.addFragment(new Category_Tabs_Fragment(), "Chilean Wines");
        adapter.addFragment(new Category_Tabs_Fragment(), "French Wines");
        adapter.addFragment(new Category_Tabs_Fragment(), "French Wines");

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
}
