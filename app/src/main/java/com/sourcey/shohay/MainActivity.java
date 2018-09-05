package com.sourcey.shohay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentTransaction fragmentTransaction;
    TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Intent bundle = getIntent();
//        String value = bundle.getStringExtra("email");
//        String value2 = bundle.getStringExtra("name");
//        Log.e("onCreate: ", value2 );
//        View view = navigationView.inflateHeaderView(R.layout.nav_header_main);
//        Log.e("onCreate: ", value2 );
//        name = (TextView) view.findViewById(R.id.name);
//
//        email = (TextView) view.findViewById(R.id.email);
//        name.setText(value);
//        Log.e("onCreate: ", value2 );
//        email.setText(value2);



        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new ProfileFragment());
        fragmentTransaction.commit();

        Toast.makeText(this.getApplicationContext(), Profile.email + "lalala", Toast.LENGTH_LONG).show();

//
//        name = (TextView) findViewById(R.id.name);
//        email = (TextView) findViewById(R.id.email);

//        char [] lala = bundle.getString("name").toCharArray();
//        name.setText(lala,0,bundle.getString("name").length()-1);
//        email.setText(bundle.getString("email"));
//        email.setText(Profile.email);



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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        } else if (id == R.id.nav_profile) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new ProfileFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("PROFILE");

        } else if (id == R.id.nav_services) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new ServicesFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("SERVICES");

        } else if (id == R.id.nav_history) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new HistoryFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("HISTORY");
        } else if (id == R.id.nav_payment) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new PaymentFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("PAYMENT");
        } else if (id == R.id.nav_map) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new ProfileFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Map");

        } else if (id == R.id.nav_logout){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_notifications) {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new NotificationsFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Notifications");

        } else if (id == R.id.nav_settings) {

        }

        //TODO: SET UP NAVIGATION FOR ALL THE OPTIONS

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
