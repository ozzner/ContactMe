package rsantillanc.contactme.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rsantillanc.contactme.R;

/**
 * Created by RenzoD on 22/05/2015.
 */
public class DrawerFragment extends Fragment {

    private final static String TAG = DrawerFragment.class.getSimpleName();
    private OnDrawerCustomListener drawerListener;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout draLay;
    private RecyclerView recView;
    private String[] barTitles = null;





    public interface OnDrawerCustomListener{
        void onDrawerSelectedItem(View v, int pos);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = null;
        v = inflater.inflate(R.layout.fragment_nav_drawer,container,false);
        recView = (RecyclerView)v.findViewById(R.id.drawerList);

        return v;
    }



}
