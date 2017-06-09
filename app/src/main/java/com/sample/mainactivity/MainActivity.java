package com.sample.mainactivity;

import android.content.Context;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

        SliderLayout sliderLayout;
        HashMap<String,String> Hash_file_maps ;


    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Toast mToastToShow;

    TextView tabOne,tabTwo,tabThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AppStatus.getInstance(this).isOnline()) {

            setContentView(R.layout.activity_main);

        } else {

            setContentView(R.layout.activity_main);




                // Set the toast and duration
                int toastDurationInMilliSeconds = 10000;
                mToastToShow = Toast.makeText(this, "Check Your Internet Connection", Toast.LENGTH_LONG);

                // Set the countdown to display the toast
                CountDownTimer toastCountDown;
                toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
                    public void onTick(long millisUntilFinished) {
                        mToastToShow.show();
                    }
                    public void onFinish() {
                        mToastToShow.cancel();
                    }
                };

                // Show the toast and starts the countdown
                mToastToShow.show();
                toastCountDown.start();

        }


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout)findViewById(R.id.slider);

        Hash_file_maps.put("Avatar", "http://www.3dmoviereviews.net/wp-content/uploads/2015/07/Avatar2.jpg");
        Hash_file_maps.put("Fast and Furious 8", "https://i.ytimg.com/vi/6FuR7gER6n8/maxresdefault.jpg");
        Hash_file_maps.put("Spiderman 3", "https://i.ytimg.com/vi/MXnSF8NI4K4/maxresdefault.jpg");
        Hash_file_maps.put("Pirates of the Caribbean 5", "http://media.comicbook.com/2017/02/pirates-of-the-caribbean-5-dead-men-tell-no-tales-new-posters-233127-1280x0.jpg");


        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(this);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        createViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                if(position == 0){



                    tabOne.setText("VIDEOS");
                    tabOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_select_video, 0, 0);
                    tabLayout.getTabAt(0).setCustomView(tabOne);


                    tabTwo.setText("IMAGES");
                    tabTwo.setTextColor(getResources().getColor(R.color.colorPrimarygray));
                    tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_image, 0, 0);
                    tabLayout.getTabAt(1).setCustomView(tabTwo);


                    tabThree.setText("MILESTONE");
                    tabThree.setTextColor(getResources().getColor(R.color.colorPrimarygray));
                    tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_milestone, 0, 0);
                    tabLayout.getTabAt(2).setCustomView(tabThree);

                }
                else if( position ==1){


                    tabOne.setText("VIDEOS");
                    tabOne.setTextColor(getResources().getColor(R.color.colorPrimarygray));
                    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_video, 0, 0);
                    tabLayout.getTabAt(0).setCustomView(tabOne);


                    tabTwo.setText("IMAGES");
                    tabTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                    tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_select_image, 0, 0);
                    tabLayout.getTabAt(1).setCustomView(tabTwo);


                    tabThree.setText("MILESTONE");
                    tabThree.setTextColor(getResources().getColor(R.color.colorPrimarygray));
                    tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_milestone, 0, 0);
                    tabLayout.getTabAt(2).setCustomView(tabThree);


                }
                else if(position ==2){

                    tabOne.setText("VIDEOS");
                    tabOne.setTextColor(getResources().getColor(R.color.colorPrimarygray));
                    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_video, 0, 0);
                    tabLayout.getTabAt(0).setCustomView(tabOne);


                    tabTwo.setText("IMAGES");
                    tabTwo.setTextColor(getResources().getColor(R.color.colorPrimarygray));
                    tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_image, 0, 0);
                    tabLayout.getTabAt(1).setCustomView(tabTwo);


                    tabThree.setText("MILESTONE");
                    tabThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                    tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_select_milestone, 0, 0);
                    tabLayout.getTabAt(2).setCustomView(tabThree);


                }

                //also you can use tab.setCustomView() too
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
               // tab.setIcon(R.drawable.oldicon);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        createTabIcons();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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



    private void createTabIcons() {

        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("VIDEOS");
        tabOne.setTextSize(14);
        tabOne.setTextColor(getResources().getColor(R.color.colorPrimary));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_select_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("IMAGES");
        tabTwo.setTextSize(14);
        tabTwo.setTextColor(getResources().getColor(R.color.colorPrimarygray));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        tabThree  = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("MILESTONE");
        tabThree.setTextSize(14);
        tabThree.setTextColor(getResources().getColor(R.color.colorPrimarygray));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Fragment1(), "VIDEOS");
        adapter.addFrag(new Fragment1(), "IMAGES");
        adapter.addFrag(new Fragment1(), "MILESTONE");
        viewPager.setAdapter(adapter);
    }




    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

       // Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}



