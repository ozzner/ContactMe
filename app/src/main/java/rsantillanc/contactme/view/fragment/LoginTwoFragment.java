package rsantillanc.contactme.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rsantillanc.contactme.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginTwoFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static LoginTwoFragment instance;

    public LoginTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_two, container, false);
    }


    public static LoginTwoFragment newInstance(String param1,String param2) {
        if (instance == null)
            instance = new LoginTwoFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        instance.setArguments(args);


        return instance;
    }
}
