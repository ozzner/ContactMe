package rsantillanc.contactme.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rsantillanc.contactme.R;


public class LoginThreeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static LoginThreeFragment instance;


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


    public static LoginThreeFragment newInstance(String param1,String param2) {
        if (instance == null)
            instance =  new LoginThreeFragment();

        return instance;
    }
}
