package com.example.moeslimsunnahapk;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        private RecyclerView rvView;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager layoutManager;
        private ArrayList<String> dataSet;
        private ArrayList<String> dataSet1;
        private  NavigationView navigationView;
        CircleImageView circleImageView;
        TextView name, email;
        String namo,emailo,photi;


        private MaterialCalendarView materialCalendarView;



        public MainActivity(){}


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate( savedInstanceState );
                setContentView( R.layout.activity_main );
                Toolbar toolbar = findViewById( R.id.toolbar );
                setSupportActionBar( toolbar );

            dataSet = new ArrayList<>();
            dataSet1 = new  ArrayList<>();
            initDataset();
            inidataset1();
                rvView = (RecyclerView) findViewById( R.id.rRv_main );
                rvView.setHasFixedSize( true );
                layoutManager = new LinearLayoutManager( this );
                rvView.setLayoutManager( layoutManager );
                adapter = new Adapter( dataSet );
                rvView.setAdapter( adapter );
                navigationView = findViewById(  R.id.nav_view );
                View headerView = navigationView.getHeaderView( 0 );
                namo = Login.name;
                emailo = Login.email;
                photi = Login.photo;
                System.out.println("dsata" + namo);
                circleImageView = headerView.findViewById( R.id.imageView );
                name = headerView.findViewById( R.id.un);
                email = headerView.findViewById(R.id.em);
                name.setText( namo );
                email.setText( emailo );
                Glide.with(this)
                        .load( photi )
                        .into( circleImageView );

           Intent intent = getIntent();
            final String personName = intent.getStringExtra( "person Name" );
            final String personEmail = intent.getStringExtra( "person Email" );
            final String personId = intent.getStringExtra( "person Id" );
            //final String foto = intent.getStringExtra( "person Foto" );

                NavigationView navigationView = findViewById( R.id.nav_view );







                 /*   materialCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
                materialCalendarView.state().edit()
                        .setFirstDayOfWeek(Calendar.MONDAY)
                        .setMinimumDate( CalendarDay.from(2019, 1, 1))
                            .setMaximumDate(CalendarDay.from(2045, 12, 31))
                            .setCalendarDisplayMode( CalendarMode.MONTHS)
                        .commit();
                materialCalendarView.setOnTitleClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                } );*/


                FloatingActionButton fab = findViewById( R.id.fab );
                fab.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                                        .setAction( "Action", null ).show();
                        }
                } );
                DrawerLayout drawer = findViewById( R.id.drawer_layout );
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
                drawer.addDrawerListener( toggle );
                toggle.syncState();
                navigationView.setNavigationItemSelectedListener( this );

        }

        @Override
        public void onBackPressed() {
                DrawerLayout drawer = findViewById( R.id.drawer_layout );
                if (drawer.isDrawerOpen( GravityCompat.START )) {
                        drawer.closeDrawer( GravityCompat.START );
                } else {
                        super.onBackPressed();
                }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate( R.menu.main, menu );
                return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_Help) {
                    Intent intent = new Intent( MainActivity.this, HelpActivity.class );
                    startActivity( intent );
                        return true;
                }

                return super.onOptionsItemSelected( item );
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                } else if (id == R.id.nav_info) {
                } else if (id == R.id.nav_share) {

                } else if (id == R.id.nav_send) {

                }

                DrawerLayout drawer = findViewById( R.id.drawer_layout );
                drawer.closeDrawer( GravityCompat.START );
                return true;
        }


        private void initDataset() {

            dataSet.add( "Sholat Sunnah" );
            dataSet.add( "Puasa Sunnah" );
            dataSet.add( "Membaca AlQuran" );
            dataSet.add( "Membaca AlQuran" );
            dataSet.add( "Membaca AlQuran" );
            dataSet.add( "Membaca AlQuran" );
            dataSet.add( "Membaca AlQuran" );
            dataSet.add( "Membaca AlQuran" );
            dataSet.add( "Membaca AlQuran" );
            dataSet.add( "Membaca AlQuran" );


        }
        private void inidataset1() {
            dataSet1.add( "a" );
            dataSet1.add( "a" );
            dataSet1.add( "a" );
            dataSet1.add( "a" );
        }

    }


