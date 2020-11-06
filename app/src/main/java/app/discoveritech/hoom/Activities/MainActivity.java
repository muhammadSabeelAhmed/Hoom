package app.discoveritech.hoom.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.kaopiz.kprogresshud.KProgressHUD;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.Fragments.HomeFragment;
import app.discoveritech.hoom.Fragments.SignupFragment;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.LocalDatabase.PreferencesHandler;
import app.discoveritech.hoom.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    PostWebDataAPI postWebDataAPI;
    PreferencesHandler preferencesHandler;
   public static TextView txt_mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Global.mKProgressHUD = KProgressHUD.create(MainActivity.this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setDimAmount(0.7f).setAnimationSpeed(2).setLabel("Please Wait").setCancellable(true);
        Global.changeMainFragment(MainActivity.this, new HomeFragment(), "", "");
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        preferencesHandler = new PreferencesHandler(MainActivity.this);
        postWebDataAPI = new PostWebDataAPI(MainActivity.this);

        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(Color.BLACK);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//        toolbar.setNavigationIcon(R.drawable.nav_icon);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.nav_icon);
        txt_mainToolbar = findViewById(R.id.main_toolbar_txt);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("ItemID", "" + item.getItemId());
        switch (item.getItemId()) {
            case R.id.nav_order:

                break;
            case R.id.nav_address:

                break;
            case R.id.nav_help:

                break;
            case R.id.nav_more:

                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}