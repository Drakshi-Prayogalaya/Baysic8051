package com.grape.basic8051;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.grape.basic8051.fragment.AboutUsFragment;
import com.grape.basic8051.fragment.ExperimentsFragment;
import com.grape.basic8051.fragment.HomeFragment;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragment = new HomeFragment();
        setFragment(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        AdBuddiz.setPublisherKey("48e15c7c-fd9f-488b-8a68-4346d8d3d34c");
        AdBuddiz.cacheAds(this);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        String title = "";

        int id = item.getItemId();

        if (id == R.id.menu_main_home)
        {
            closeDrawerLayout();
            setTimeDelay(200);
            fragment = new HomeFragment();
            title = "Home";
        }
        else if (id == R.id.menu_programs)
        {
            closeDrawerLayout();
            setTimeDelay(200);
            fragment = new ExperimentsFragment();
            title = "Programs";
        }
        else if(id == R.id.menu_instructions)
        {
            closeDrawerLayout();
            setTimeDelay(200);
            Intent i = new Intent(MainActivity.this,InstructionsList.class);
            startActivity(i);
        }
        else if (id == R.id.menu_about_us)
        {
            closeDrawerLayout();
            setTimeDelay(200);
            fragment = new AboutUsFragment();
            title = "About Us";
        }
        else if (id == R.id.menu_share)
        {
            closeDrawerLayout();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello friends!!! Check out this application in play store. \"Basic 8051\" - https://play.google.com/store/apps/details?id=com.grape.basic8051");
            startActivity(Intent.createChooser(intent,"Share via"));
        }
        else if (id == R.id.menu_facebook)
        {
            closeDrawerLayout();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.facebook.com/GrapeEmbeddedSolutions"));
            startActivity(intent);
        }
        else if (id == R.id.menu_more_apps)
        {
            closeDrawerLayout();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Grape+Labs"));
            startActivity(intent);
        }
        else if (id == R.id.menu_rate_the_app)
        {
            closeDrawerLayout();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.grape.basic8051"));
            startActivity(intent);
        }
        else if (id == R.id.menu_visit_our_site)
        {
            closeDrawerLayout();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.grape-labs.com"));
            startActivity(intent);
        }
        else if(id == R.id.menu_twitter)
        {
            closeDrawerLayout();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://twitter.com/Grape_Labs"));
            startActivity(intent);
        }

        if (fragment != null)
        {
            setFragment(fragment);

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }

        return true;
    }

    public void setFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment);
        fragmentTransaction.commit();
    }

    public void setTimeDelay(int milliseconds)
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {

            }
        }, milliseconds);
    }

    public void closeDrawerLayout()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
