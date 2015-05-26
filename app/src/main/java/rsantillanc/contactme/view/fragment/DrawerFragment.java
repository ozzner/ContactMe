package rsantillanc.contactme.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import rsantillanc.contactme.R;
import rsantillanc.contactme.adapter.NavDrawerAdapter;
import rsantillanc.contactme.model.NavItemModel;

/**
 * Created by RenzoD on 22/05/2015.
 */
public class DrawerFragment extends Fragment {

    private final static String TAG = DrawerFragment.class.getSimpleName();
    private static DrawerFragment  singleton = null;
    private Context _context = getActivity();
    private ArrayList<NavItemModel> navItems;
    private FragmentDrawerListener drawerListener;
    private ActionBarDrawerToggle toggle;
    private NavDrawerAdapter navAdapter;
    private DrawerLayout draLay;
    private View contView;
    private RecyclerView recView;
    private static String[] navTitles = null;
    private static final int[] ICONS = { R.drawable.ic_infinite
                                        ,R.drawable.ic_infinite
                                        ,R.drawable.ic_infinite
                                        ,R.drawable.ic_infinite
                                        ,R.drawable.ic_infinite
                                        ,R.drawable.ic_infinite};



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navTitles = getActivity().getResources().getStringArray(R.array.nav_titles);

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }
    public interface OnDrawerCustomListener{
        void onDrawerSelectedItem(View v, int pos);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_nav_drawer,container,false);
        recView = (RecyclerView)v.findViewById(R.id.drawerList);
        recView.setLayoutManager(new LinearLayoutManager(getActivity()));
        navAdapter =  new NavDrawerAdapter(getActivity(),getItems());



        recView.setAdapter(navAdapter);
        recView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view,position);
                draLay.closeDrawer(contView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        initViews(v);
        return v;
    }

    protected void initViews(View v){


    }

    private ArrayList<NavItemModel> getItems(){
        NavItemModel item;
        navItems = new ArrayList<NavItemModel>();

        for(int x = 0; x < navTitles.length; x ++){
            item = new NavItemModel(navTitles[x],ICONS[x]);
            navItems.add(item);
        }

        return navItems;
    }

    public void setUp(int fragmentID, DrawerLayout drLay,Toolbar toolbar){
        contView = getActivity().findViewById(fragmentID);
        draLay = drLay;
        toggle =  new ActionBarDrawerToggle(getActivity(),draLay,toolbar,R.string.nav_drawer_open,R.string.nav_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
//                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };


        draLay.setDrawerListener(toggle);
        draLay.post(new Runnable() {
            @Override
            public void run() {
                toggle.syncState();
            }
        });
    }


    public interface FragmentDrawerListener {
        void onDrawerItemSelected(View view, int position);
    }

    public static interface ClickListener {
        public void onClick(View view, int position);
        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }
    }



}
