package com.example.dinopc.atsimink;

import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dinopc.atsimink.Settings.AboutUs;
import com.example.dinopc.atsimink.WeekDays.Friday;
import com.example.dinopc.atsimink.WeekDays.Monday;
import com.example.dinopc.atsimink.WeekDays.Saturday;
import com.example.dinopc.atsimink.WeekDays.Sunday;
import com.example.dinopc.atsimink.WeekDays.Thursday;
import com.example.dinopc.atsimink.WeekDays.Tuesday;
import com.example.dinopc.atsimink.WeekDays.Wednesday;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Button button;
    private TextView textView;
    private LocationManager locationManager;
    private LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.Navigation_v);
        navigationView.setNavigationItemSelectedListener(this);

        //GPS
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        //Inititalize location manager & listener
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                textView.append("\n"+location.getLatitude() +" "+location.getLongitude());
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);

            }
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                }, 10 );
                return;
            }
        }else{
            configureButton();
        }
        locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;
        }
    }

    private void configureButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //REQUESTION LOCATION AND UPDATING AFTER 5SECONDS (time = 5000)
                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;

    }

    //SEARCH AND SETTINGS MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_refresh:

                Toast.makeText(this,"Item Refresh selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_search:

                Toast.makeText(this,"Item Search selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_settings:

                Toast.makeText(this,"Item Settings selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_about_us:

                AboutUs aboutUs = new AboutUs();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, aboutUs);
                fragmentTransaction.commit();
        }
        //HAMBURGER
        if(mToggle.onOptionsItemSelected(item)){

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    //DRAWER LAYOUT
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.Main)
        {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
            mDrawerLayout.closeDrawers();
        }
        else if(id == R.id.Monday)
        {
            Monday monday = new Monday();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, monday);
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawers();
        }
        else if(id == R.id.Tuesday)
        {
            Tuesday tuesday = new Tuesday();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, tuesday);
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawers();
        }
        else if(id == R.id.Wednesday)
        {
            Wednesday wednesday = new Wednesday();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, wednesday);
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawers();
        }
        else if(id == R.id.Thursday)
        {
            Thursday thursday = new Thursday();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, thursday);
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawers();
        }
        else if(id == R.id.Friday)
        {
            Friday friday = new Friday();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, friday);
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawers();
        }
        else if(id == R.id.Saturday)
        {
            Saturday saturday = new Saturday();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, saturday);
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawers();
        }
        else if(id == R.id.Sunday)
        {
            Sunday sunday = new Sunday();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, sunday);
            fragmentTransaction.commit();
            mDrawerLayout.closeDrawers();
        }

        return true;
    }

    //
}
