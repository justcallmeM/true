package com.example.dinopc.atsimink;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dinopc.atsimink.Settings.AboutUs;
import com.example.dinopc.atsimink.WeekDays.Current;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.Navigation_v);
        navigationView.setNavigationItemSelectedListener(this);

        Current current = new Current();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, current);
        fragmentTransaction.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //SEARCH AND SETTINGS MENU
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.Current)
        {
            Current current = new Current();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, current);
            fragmentTransaction.commit();
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
}
