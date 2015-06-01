package rsantillanc.contactme.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

import rsantillanc.contactme.MainActivity;
import rsantillanc.contactme.R;
import rsantillanc.contactme.adapter.ViewPagerAdapter;

public class LoginActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener,View.OnClickListener{

    private static final int TOTAL_SCREENS = 3;
    private final Context _context = getApplicationContext();
    private ViewPager mViewPager;
    private CirclePageIndicator mCirPagIndicator;
    private Button btLogin;
    private Button btRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        /*Init*/
        mCirPagIndicator = (CirclePageIndicator)findViewById(R.id.cvp_login);
        mViewPager = (ViewPager)findViewById(R.id.vp_login);
        btLogin = (Button)findViewById(R.id.button);
        btRegister = (Button)findViewById(R.id.button2);

        /*Setup*/
        mViewPager.setAdapter( new ViewPagerAdapter(getSupportFragmentManager(),TOTAL_SCREENS));
        mCirPagIndicator.setViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.button:
                Intent i = new Intent(_context, MainActivity.class);
                startActivity(i);
                break;
            case R.id.button2:
                Intent i2 = new Intent(_context, MainActivity.class);
                startActivity(i2);
                break;
        }
    }
}
