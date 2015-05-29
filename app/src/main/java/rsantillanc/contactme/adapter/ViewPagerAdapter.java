package rsantillanc.contactme.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import rsantillanc.contactme.view.fragment.LoginOneFragment;
import rsantillanc.contactme.view.fragment.LoginTwoFragment;

/**
 * Created by RenzoD on 29/05/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{
    private Fragment mFragment;
    private static String[] titles = null;
    private int numFragmens;


    public ViewPagerAdapter(FragmentManager fm, int number) {
        super(fm);
        this.numFragmens = number;
    }

    @Override
    public int getCount() {
        return numFragmens;
    }

    //TODO CAMBIAR LOS NULL POR OBJETOS BUNDLE
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                mFragment = LoginOneFragment.newInstance(null,null);
                break;
            case 1:
                mFragment = LoginTwoFragment.newInstance(null,null);
                break;
            default:
                break;
        }

        return mFragment;
    }

}
