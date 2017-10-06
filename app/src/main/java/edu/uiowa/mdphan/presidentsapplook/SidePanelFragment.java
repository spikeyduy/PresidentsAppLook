package edu.uiowa.mdphan.presidentsapplook;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;

import static edu.uiowa.mdphan.presidentsapplook.MainActivity.myArrayList;
import static edu.uiowa.mdphan.presidentsapplook.MainActivity.ninePres;
import static edu.uiowa.mdphan.presidentsapplook.MainActivity.sidePanelAdapter;
import static edu.uiowa.mdphan.presidentsapplook.MainActivity.twenPres;

/**
 * A placeholder fragment containing a simple view.
 */
public class SidePanelFragment extends Fragment {

    ListView menu; // shows all the names
    // need a listView click listener
    public static View sideView;


    public SidePanelFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.side_panel_fragment, container, false);


    }

    public static void updatePresidentListDisplay() {
        switch (MainActivity.currentCentury) {
            case 0:
                myArrayList.clear();
                myArrayList.addAll(Arrays.asList(MainActivity.sevenPres));
                sidePanelAdapter.notifyDataSetChanged();
                break;
            case 1:
                myArrayList.clear();
                myArrayList.addAll(Arrays.asList(MainActivity.eightPres));
                sidePanelAdapter.notifyDataSetChanged();
                break;
            case 2:
                myArrayList.clear();
                myArrayList.addAll(Arrays.asList(ninePres));
                sidePanelAdapter.notifyDataSetChanged();
                break;
            case 3:
                myArrayList.clear();
                myArrayList.addAll(Arrays.asList(twenPres));
                sidePanelAdapter.notifyDataSetChanged();
                break;
            default:
                myArrayList.clear();
                myArrayList.addAll(Arrays.asList(MainActivity.sevenPres));
                sidePanelAdapter.notifyDataSetChanged();
                break;

        }
    }


}
