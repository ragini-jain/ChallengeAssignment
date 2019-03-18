package com.gl.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener, BasicFragment.OnFragmentInteractionListener, ScientificFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    private  Toolbar toolbar;
    private DrawerLayout drawer;
    private TabLayout mTabLayout;
    private ImageButton mImageButtonOne;
    private ImageButton mImageButtonTwo;
    private ImageButton mImageButtonThree;

    public FragmentRefreshListener getFragmentRefreshListener() {
        return fragmentRefreshListener;
    }

    public void setFragmentRefreshListener(FragmentRefreshListener fragmentRefreshListener) {
        this.fragmentRefreshListener = fragmentRefreshListener;
    }

    private FragmentRefreshListener fragmentRefreshListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        registerListener();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewPagerDetailInfo();

    }

    private void registerListener() {
        mImageButtonOne.setOnClickListener(this);
        mImageButtonTwo.setOnClickListener(this);
        mImageButtonThree.setOnClickListener(this);
    }

    /**
     * View Pager
     */
    private void viewPagerDetailInfo() {
        mTabLayout.addTab(mTabLayout.newTab().setText("Basic"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Scientific"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.viewPagerId);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    /**
     * init View
     */
    private void initView() {
         toolbar = findViewById(R.id.toolbar);
         drawer = findViewById(R.id.drawer_layout);
         mTabLayout = findViewById(R.id.tabLayout);
         mImageButtonOne = findViewById(R.id.circle1);
         mImageButtonTwo = findViewById(R.id.circle2);
         mImageButtonThree = findViewById(R.id.circle3);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_basic:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new BasicFragment()).commit();
                break;

            case R.id.nav_scientific:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ScientificFragment()).commit();
                break;
        }
        DrawerLayout drawer =findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, BasicFragment.class);
      switch (v.getId()) {
          case R.id.circle1:
              intent.putExtra("Color","1");
              BasicFragment basic_fragment  = new BasicFragment();
              basic_fragment.changeData( 1);
              break;

          case R.id.circle2:
              intent.putExtra("Color","2");
              break;

          case R.id.circle3:
              intent.putExtra("Color","3");
              break;
      }
          DrawerLayout drawer =findViewById(R.id.drawer_layout);
          drawer.closeDrawer(GravityCompat.START);

    }

    public interface FragmentRefreshListener{
        void onRefresh();
    }

}
