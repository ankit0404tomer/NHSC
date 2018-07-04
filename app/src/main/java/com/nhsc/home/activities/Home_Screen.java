package com.nhsc.home.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.nhsc.Fragments.MyCart_Fragment;
import com.nhsc.Fragments.My_Account_Fragment;
import com.nhsc.Fragments.Search_Fragment;
import com.nhsc.Models.ExpandedMenuModel;
import com.nhsc.R;
import com.nhsc.Utils.Utils;
import com.nhsc.base.BaseActivity;
import com.nhsc.home.adapter.DrawerAdapter;
import com.nhsc.home.fragment.Home_Fragment;
import com.nhsc.home.model.DrawerModel;
import com.nhsc.home.model.HomeModel;
import com.nhsc.home.presenters.HomePresenter;
import com.nhsc.home.presenters.HomePresenterImpl;
import com.nhsc.home.views.HomeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Home_Screen extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeView {

    /* Tab identifiers */
    private static String TAB_A = "Home";
    private static String TAB_B = "Special Offers";
    private static String TAB_C = "My Cart";
    private static String TAB_D = "My Account";
    private final int[] prevExpandPosition = {-1};
    private RecyclerView recyclerView;
    private Utils utils;
    private Home_Fragment home_fragment;
    private MyCart_Fragment myCart_fragment;
    private Search_Fragment search_fragment;   public ProgressBar progressBar;

    private My_Account_Fragment my_account_fragment;
    private TabHost host;
    private DrawerAdapter mAdapter;
    /*
     * TabChangeListener for changing the tab when one of the tabs is pressed
     */
    TabHost.OnTabChangeListener listener = new TabHost.OnTabChangeListener() {
        public void onTabChanged(String tabId) {

            setTabColor(host);

            /*Set current tab..*/
            if (tabId.equals(TAB_A)) {
                pushFragments(tabId, home_fragment);
            } else if (tabId.equals(TAB_B)) {
                pushFragments(tabId, myCart_fragment);
            } else if (tabId.equals(TAB_C)) {
                pushFragments(tabId, search_fragment);
            } else if (tabId.equals(TAB_D)) {
                pushFragments(tabId, my_account_fragment);
            }
        }
    };
    private HomeModel homeModel;
    private HomePresenter mPresenter;
    private LinkedHashMap<String, ArrayList<String>> mDrawerData;

    public static void setTabColor(TabHost tabhost) {

        for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#000000"));//unselected
            // unselected


        }
        tabhost.getTabWidget().setCurrentTab(0);
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab())
                .setBackgroundColor(Color.parseColor("#303F9F")); // selected
        // //have
        // to
        // change
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home__screen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        progressBar = (ProgressBar) findViewById(R.id.progress_view);

        setSupportActionBar(toolbar);
        mDrawerData = new LinkedHashMap<>();
        mPresenter = new HomePresenterImpl(this, this, getSPRestClientInstance());
        mPresenter.getHomeData();

        utils = new Utils(Home_Screen.this);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.minus);
        actionbar.setDisplayHomeAsUpEnabled(true);


        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);

        title.setText("NHSC");

        utils.setUbuntu_Regular(title);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //  NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.navigationmenu);

        home_fragment = new Home_Fragment();
        myCart_fragment = new MyCart_Fragment();
        search_fragment = new Search_Fragment();
        my_account_fragment = new My_Account_Fragment();

        host = (TabHost) findViewById(R.id.tabhost);
        host.setOnTabChangedListener(listener);
        host.setup();


        initializeTab();


        setTabColor(host);


    }

    public void initializeTab() {

        TabHost.TabSpec spec = host.newTabSpec(TAB_A);
        host.setCurrentTab(-3);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(android.R.id.tabcontent);
            }
        });
        spec.setIndicator(createTabView(TAB_A, R.drawable.home_grey));
        host.addTab(spec);


        spec = host.newTabSpec(TAB_B);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(android.R.id.tabcontent);
            }
        });
        spec.setIndicator(createTabView(TAB_B, R.drawable.my_cart_grey));
        host.addTab(spec);


        spec = host.newTabSpec(TAB_C);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(android.R.id.tabcontent);
            }
        });
        spec.setIndicator(createTabView(TAB_C, R.drawable.search_grey));
        host.addTab(spec);


        spec = host.newTabSpec(TAB_D);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(android.R.id.tabcontent);
            }
        });
        spec.setIndicator(createTabView(TAB_D, R.drawable.my_account_grey));
        host.addTab(spec);


    }

    private View createTabView(final String text, final int id) {
        View view = LayoutInflater.from(this).inflate(R.layout.tabs_icon, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        imageView.setImageDrawable(getResources().getDrawable(id));
        TextView tab_text = (TextView) view.findViewById(R.id.tab_text);
        tab_text.setText(text);
        utils.setUbuntu_Light(tab_text);
        return view;
    }

    /*
     * adds the fragment to the FrameLayout
     */
    public void pushFragments(String tag, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        ft.replace(android.R.id.tabcontent, fragment);
        ft.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_settings);
        item.setVisible(false);
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home__screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onNavigationDrawerSuccess(List<DrawerModel.ComponentsBean> data) {
        Log.d("ANKIT", "data ::  " + data);
        ArrayList<String> list;
        for (int i = 0; i < homeModel.getComponents().size(); i++) {
            list = new ArrayList<>();
            for (int j = 0; j < data.size(); j++) {

                if (homeModel.getComponents().get(i).getCategoriesId().equalsIgnoreCase(data.get(j).getCategoriesId())) {
                    list.add(data.get(j).getSubCategoriesName());
                }
            }
            mDrawerData.put(homeModel.getComponents().get(i).getCategoriesName(), list);

        }
        mDrawerData.put("Settings", new ArrayList<String>());
        mDrawerData.put("Sign out",  new ArrayList<String>());


        setUpRecyclerView(mDrawerData);

    }

    private void setUpRecyclerView(HashMap<String, ArrayList<String>> mDrawerData) {


        mAdapter = new DrawerAdapter(Home_Screen.this,mDrawerData);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onNavigationDrawerFailure(String message) {
        Toast.makeText(getApplicationContext(),message
        ,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHomeSuccess(HomeModel data) {
        homeModel = data;
        mPresenter.getNavigationDrawerData();
        home_fragment.getHomeData(homeModel);
    }

    @Override
    public void onHomeFailure(String message) {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }
}
