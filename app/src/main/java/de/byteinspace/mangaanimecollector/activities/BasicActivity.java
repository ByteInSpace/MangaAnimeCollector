package de.byteinspace.mangaanimecollector.activities;

import android.os.Bundle;


import android.content.Context;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;


import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import android.widget.AdapterView;

import de.byteinspace.mangaanimecollector.R;
import de.byteinspace.mangaanimecollector.adapter.PublicDrawerAdapter;

public abstract class BasicActivity extends AppCompatActivity {

   private Toolbar toolbar;
   private ListView drawerList;
   private ActionBarDrawerToggle drawerToogle;
   protected DrawerLayout drawerLayout;
   protected String activityTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        showToolbar();
        drawerList = (ListView)findViewById(R.id.navList);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        activityTitle = getTitle().toString();

        createDrawer(this);

    }

    protected abstract int getContentView() ;

    protected void showToolbar() {
        setSupportActionBar(toolbar);
    }

    protected void createDrawer(Context context) {
        String[] osArray = { "Android", "iOS", "Windows", "OS X", "Linux" };
        drawerList.setAdapter(new PublicDrawerAdapter(context));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawer();

    }

    protected void setupDrawer() {
        drawerToogle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("mActivityTitle!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(activityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        drawerToogle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(drawerToogle);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch ((int) id) {
                    case 0: // Replace it by constants
                        return;
                    case 1:
                        return;
                    case 2:
                        return;
                    case 3:
                        return;
                    case 4:
                        return;
                    case 5:
                        return;

                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        // Activate the navigation drawer toggle
        if (drawerToogle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
