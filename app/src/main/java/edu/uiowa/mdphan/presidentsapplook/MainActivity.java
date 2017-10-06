package edu.uiowa.mdphan.presidentsapplook;

//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;
    Spinner mySpinner;
    ListView myList;
    public static int currentCentury;
    SidePanelFragment sideFragment;
    MainPanelFragment mainFragment;
    public static ArrayList<String> myArrayList;
    public static ArrayAdapter<String> sidePanelAdapter;
    public static String[] sevenPres;
    public static String[] eightPres;
    public static String[] ninePres;
    public static String[] twenPres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate both fragments
        sideFragment = new SidePanelFragment();
        mainFragment = new MainPanelFragment();

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar); // sets as action bar
        mySpinner = (Spinner) findViewById(R.id.spinner);
        myList = (ListView) findViewById(R.id.listOfPres);

        // populate the spinner with the centuries array
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.centuries));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        // this arraylist will be the place holder so that the arrayadapter can be modified
        myArrayList = new ArrayList<>();
        sidePanelAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myArrayList);
        myList.setAdapter(sidePanelAdapter);

        // now to modify myArrayList
        sevenPres = getResources().getStringArray(R.array.seventeenPres);
        eightPres = getResources().getStringArray(R.array.eighteenPres);
        ninePres = getResources().getStringArray(R.array.nineteenPres);
        twenPres = getResources().getStringArray(R.array.twentyPres);

//        hideSideFrag();

//         When the spinner has an item selected
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentCentury = mySpinner.getSelectedItemPosition();
                SidePanelFragment.updatePresidentListDisplay();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    // hide/show fragments
    public static void hideSideFrag() {
        // how to load this fragment in the view?
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.hide(sideFragment);
//        transaction.commit();
        View sidePane = SidePanelFragment.sideView;
        if (sidePane.getVisibility() == View.VISIBLE) {
            sidePane.setVisibility(View.GONE);
        }
    }

    public static void showSideFrag() {

    }

}
