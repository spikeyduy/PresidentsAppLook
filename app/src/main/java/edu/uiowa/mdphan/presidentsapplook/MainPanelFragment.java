package edu.uiowa.mdphan.presidentsapplook;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainPanelFragment extends Fragment {

    public TextView presTextV;
    public FragmentManager fragmentManager;
    public FragmentTransaction transaction;

    public MainPanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_panel, container, false);
        presTextV = view.findViewById(R.id.presText);

        return view;
    }

    public void updatePresStatus(int currCent, int currPres) {
        // show a new screen for the selected president
        switch (currCent) {
            case 0: // 1700
                switch (currPres) {
                    case 0:
                        Toast.makeText(getActivity().getParent().getParent(), "George Washington", Toast.LENGTH_SHORT).show();
//                        presTextV.setText("George Washington");
//                        transaction = fragmentManager.beginTransaction();
//                        transaction.replace(R.id.presText, this);
//                        transaction.addToBackStack(null);
//                        transaction.commit();
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    // should make a method for each century

}
