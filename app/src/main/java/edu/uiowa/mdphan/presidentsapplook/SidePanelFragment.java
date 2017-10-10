package edu.uiowa.mdphan.presidentsapplook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.ArrayList;


public class SidePanelFragment extends Fragment {

    public ListView myListV;
    public ArrayList<String> myLister;
    public ArrayAdapter<String> presAdapter;
    MainPanelFragment mainFrag;
    public int currCent; // current century
    public int currPres; // selected pres

    public SidePanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.side_panel_fragment, container, false);
        myListV = view.findViewById(R.id.presListView);
        currCent = MainActivity.currentCentury;

        mainFrag = new MainPanelFragment();
        // listener for myListV
        myListV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currPres = position;
//                mainFrag.updatePresStatus(currCent, currPres);
//                Toast.makeText(getContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();
                switch (currCent) {
                    case 0: // 1700
                        switch (currPres) {
                            case 0:
                                Toast.makeText(getContext(), "George Washington, age:67, term:1789-1797", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getContext(), "John Adams, age:90, term:1797-1801", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 1: // 1800
                        switch (currPres) {
                            case 0:
                                Toast.makeText(getContext(), "Thomas Jefferson, age:83, term:1801-1809", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getContext(), "James Madison, age:85, term:1809-1817", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(getContext(), "James Monroe, age:73, term:1817-1825", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Toast.makeText(getContext(), "John Q. Adams, age:80, term:1825-1829", Toast.LENGTH_SHORT).show();
                                break;
                            case 4:
                                Toast.makeText(getContext(), "Andrew Jackson, age:78, term:1829-1837", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case 2: // 1900
                        switch (currPres) {
                            case 0:
                                Toast.makeText(getContext(), "Theddore Roosevelt, age:60, term:1901-1909", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getContext(), "William H. Taft, age:72, term:1909-1913", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(getContext(), "WoodRow Wilson, age:67, term:1913-1921", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Toast.makeText(getContext(), "Calvin Coolidge, age:60, term:1923-1929", Toast.LENGTH_SHORT).show();
                                break;
                            case 4:
                                Toast.makeText(getContext(), "Herbert Hoover, age:90, term:1929-1933", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case 3: // current year
                        switch (currPres) {
                            case 0:
                                Toast.makeText(getContext(), "George W. Bush, age:71, term:2001-2009", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getContext(), "Barack Obama, age:56, term:2009-2017", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(getContext(), "Donald Trump, age:71, term:2017-", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }

    public void updateSpinner() {

        // use invalidate to update the stuff

        String[] sevenPres = getResources().getStringArray(R.array.seventeenPres);
        String[] eightPres = getResources().getStringArray(R.array.eighteenPres);
        String[] ninePres = getResources().getStringArray(R.array.nineteenPres);
        String[] twenPres = getResources().getStringArray(R.array.twentyPres);

        myLister = new ArrayList<>();
        presAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, myLister);
        myListV.setAdapter(presAdapter);
        currCent = MainActivity.currentCentury;

        switch (currCent) {
            case 0:
                presAdapter.clear();
                presAdapter.addAll(Arrays.asList(sevenPres));
//                presAdapter.notifyDataSetChanged();
//                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                presAdapter.clear();
                presAdapter.addAll(Arrays.asList(eightPres));
//                presAdapter.notifyDataSetChanged();
//                Toast.makeText(getContext(), "helloTwo", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                presAdapter.clear();
                presAdapter.addAll(Arrays.asList(ninePres));
//                presAdapter.notifyDataSetChanged();
//                Toast.makeText(getContext(), "helloThree", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                presAdapter.clear();
                presAdapter.addAll(Arrays.asList(twenPres));
//                presAdapter.notifyDataSetChanged();
//                Toast.makeText(getContext(), "helloFour", Toast.LENGTH_SHORT).show();
                break;
            default:
                presAdapter.clear();
                presAdapter.addAll(Arrays.asList(sevenPres));
//                presAdapter.notifyDataSetChanged();
//                Toast.makeText(getContext(), "helloDefault", Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
