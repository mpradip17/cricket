package cricket.circket;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cricket.circket.adapter.AndroidDataAdapter;
import cricket.circket.model.AndroidVersion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Context mContext;
    private ImageView navmenu;

    private final String recyclerViewTitleText[] = {"PLAY IPL", "ALL SERIES", "PLAY OPL", "PLAY TEST", "PLAY IND VS AUS", "PLAY RANJI"};

    private final int recyclerViewImages[] = {
            R.drawable.delete_profile, R.drawable.delete_profile, R.drawable.delete_profile, R.drawable.delete_profile, R.drawable.delete_profile, R.drawable.delete_profile
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navmenu=  findViewById(R.id.navmenu);
        setSupportActionBar(toolbar);
        initRecyclerViews();
        // Set Drawerlayout switch indicator that the icon leftmost Toolbar
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.lbl_open, R.string.lbl_close);
        mActionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mActionBarDrawerToggle);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navItemHome:
                        break;
                    case R.id.navItemInBox:

                        break;
                    case R.id.navItemSetting:

                        break;
                    case R.id.navItemLogout:

                        break;
                }
                // Menu item clicked on, and close Drawerlayout
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                return true;
            }
        });
        float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        Toast.makeText(getApplicationContext(), getDensity(scale), Toast.LENGTH_LONG).show();
        toolbar.setNavigationIcon(null);
        navmenu.setOnClickListener(this);
    }

    private void initRecyclerViews() {
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<AndroidVersion> av = prepareData();
        AndroidDataAdapter mAdapter = new AndroidDataAdapter(mContext, av);
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<AndroidVersion> prepareData() {

        ArrayList<AndroidVersion> av = new ArrayList<>();
        for (int i = 0; i < recyclerViewTitleText.length; i++) {
            AndroidVersion mAndroidVersion = new AndroidVersion();
            mAndroidVersion.setAndroidVersionName(recyclerViewTitleText[i]);
            mAndroidVersion.setrecyclerViewImage(recyclerViewImages[i]);
            av.add(mAndroidVersion);
        }
        return av;
    }

    private String getDensity(float scale) {
        if (scale == 0.75f)
            return "Low Density : ldpi";
        if (scale == 1.0f)
            return "Medium Density : mdpi";
        if (scale == 1.5f)
            return "High Density : hdpi";
        if (scale == 2.0f)
            return "Extra High Density : xhpi";
        if (scale == 3.0f)
            return "Double Extra High Density : xxhpi";
        if (scale == 4.0f)
            return "Triple Extra High Density : xxxhpi";
        else
            return "Not detected :  scale : " + scale;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.navmenu:
                if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT); //CLOSE Nav Drawer!
                }else{
                    drawerLayout.openDrawer(Gravity.RIGHT); //OPEN Nav Drawer!
                }
                break;
        }
    }
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
