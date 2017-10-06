package edu.uiowa.mdphan.presidentsapplook;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;
    Spinner mySpinner;
    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate both fragments
        SidePanelFragment sideFragment = new SidePanelFragment();
        MainPanelFragment mainFragment = new MainPanelFragment();

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        myList = (ListView) findViewById(R.id.listOfPres);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.centuries));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        // this arraylist will be the place holder so that the arrayadapter can be modified
        final ArrayList<String> myArrayList = new ArrayList<>();
        final ArrayAdapter<String> sidePanelAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myArrayList);
        myList.setAdapter(sidePanelAdapter);

        // now to modify myArrayList
        final String[] sevenPres = getResources().getStringArray(R.array.seventeenPres);
        final String[] eightPres = getResources().getStringArray(R.array.eighteenPres);
        final String[] ninePres = getResources().getStringArray(R.array.nineteenPres);
        final String[] twenPres = getResources().getStringArray(R.array.twentyPres);



        // When the spinner has an item selected
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Toast for item selected
                // Toast.makeText(MainActivity.this, mySpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        myArrayList.clear();
                        for (int x=0; x < sevenPres.length; x++) {
                            myArrayList.add(sevenPres[x]);
                        }
                        sidePanelAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        myArrayList.clear();
                        for (int x=0; x < eightPres.length; x++) {
                            myArrayList.add(eightPres[x]);
                        }
                        sidePanelAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        myArrayList.clear();
                        for (int x=0; x < ninePres.length; x++) {
                            myArrayList.add(ninePres[x]);
                        }
                        sidePanelAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        myArrayList.clear();
                        for (int x=0; x < twenPres.length; x++) {
                            myArrayList.add(twenPres[x]);
                        }
                        sidePanelAdapter.notifyDataSetChanged();
                        break;
                    default:
                        myArrayList.clear();
                        for (int x=0; x < sevenPres.length; x++) {
                            myArrayList.add(sevenPres[x]);
                        }
                        sidePanelAdapter.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    // hide/show fragments
    public void hideSideFrag() {

    }

}
