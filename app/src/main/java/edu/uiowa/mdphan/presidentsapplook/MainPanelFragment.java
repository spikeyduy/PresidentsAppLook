package edu.uiowa.mdphan.presidentsapplook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainPanelFragment extends Fragment {


    public static View mainView;

    public MainPanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_panel, container, false);
    }

    public static void updatePresidentDisplay() {

    }

}
