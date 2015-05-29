package rsantillanc.contactme.view.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rsantillanc.contactme.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginThreeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginThreeFragment extends Fragment {

    public LoginThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_three, container, false);
    }



}
