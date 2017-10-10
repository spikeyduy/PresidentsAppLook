package edu.uiowa.mdphan.presidentsapplook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;
    Spinner mySpinner;
    public ListView myListView; // listview in sidefragment
    public static int currentCentury; // keeps track of which century is selected
    public ArrayAdapter<String> centuryAdapter; // list of centuries for spinner
    SidePanelFragment sideFrag;
    public static ArrayAdapter<String> presAdapter; // adapter to convert president list
    public static ArrayList<String> presList; // list of presidents user can choose from

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check activity to make sure it has framelayout
        if (findViewById(R.id.holdFrag) != null) {
            // if we are being restored from a previous state
            // do nothing
            if (savedInstanceState != null) {
                return;
            }

            // create fragment to be placed in layout
            sideFrag = new SidePanelFragment();

            // start activity with any passed intents
            sideFrag.setArguments(getIntent().getExtras());

            // add fragment to framelayout
            getSupportFragmentManager().beginTransaction().add(R.id.holdFrag, sideFrag).commit();
        }

        // set up the toolbar and spinner
        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar); // set as action bar (top bar where all the action/settings go)
        mySpinner = (Spinner) findViewById(R.id.spinner);

        // populate the spinner with the centuries
        centuryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.centuries));
        mySpinner.setAdapter(centuryAdapter);

        // when user selects option in list, switch between the presList
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentCentury = mySpinner.getSelectedItemPosition(); // keep track of the selected year
                sideFrag.updateSpinner();
//                Toast.makeText(MainActivity.this, Integer.toString(currentCentury), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
