package rsantillanc.contactme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import rsantillanc.contactme.view.fragment.DrawerFragment;
import rsantillanc.contactme.view.fragment.AssessFragment;
import rsantillanc.contactme.view.fragment.ConfigurationFragment;
import rsantillanc.contactme.view.fragment.EventsFragment;
import rsantillanc.contactme.view.fragment.HistoryFragment;
import rsantillanc.contactme.view.fragment.OffersFragment;
import rsantillanc.contactme.view.fragment.SendCommentFragment;


public class MainActivity extends ActionBarActivity implements DrawerFragment.FragmentDrawerListener {

    private Toolbar tooBar;
    private DrawerFragment fragDra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        initViews();
    }

    private void initViews() {

        tooBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tooBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fragDra = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        fragDra.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), tooBar);
        fragDra.setDrawerListener(this);
        // display the first navigation drawer view on app launch
        displayView(0);
    }



    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new EventsFragment();
                title = getString(R.string.nav_title_events);
                break;
            case 1:
                fragment = new OffersFragment();
                title = getString(R.string.nav_title_offers);
                break;
            case 2:
                fragment = new HistoryFragment();
                title = getString(R.string.nav_title_history);
                break;
            case 3:
                fragment = new SendCommentFragment();
                title = getString(R.string.nav_title_commentary);
                break;
            case 4:
                fragment = new AssessFragment();
                title = getString(R.string.nav_title_assess);
                break;
            case 5:
                fragment = new ConfigurationFragment();
                title = getString(R.string.nav_title_configuration);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the custom_toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
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

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }
}
