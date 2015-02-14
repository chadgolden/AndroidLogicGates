package com.chadgolden.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class MainActivity extends ActionBarActivity {

    private ListView logicListView;
    private ArrayAdapter<String> listAdapter;
    private GridView gridView;
    private TextView optionIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            logicListView = (ListView) findViewById(R.id.logicListView);
            optionIndicator = (TextView) findViewById(R.id.optionIndicator);
            String[] logicOptions = {"NOT", "OR", "AND", "XOR", "Half-Adder", "Full-Adder"};
            ArrayList<String> logicOptionsList = new ArrayList<>();
            logicOptionsList.addAll(Arrays.asList(logicOptions));
            listAdapter = new ArrayAdapter<>(this, R.layout.simplerow, logicOptionsList);
            logicListView.setAdapter(listAdapter);
            onLogicOptionClick();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onLogicOptionClick() {
        OnItemClickListener logicListViewListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                optionIndicator.setText("You selected: " + listAdapter.getItem(position));
                TruthTableAdapter truthTableAdapter = new TruthTableAdapter(MainActivity.this, listAdapter.getItem(position));
                gridView = (GridView) findViewById(R.id.gridView);
                gridView.setNumColumns(truthTableAdapter.numberOfColumns());
                gridView.setAdapter(truthTableAdapter);
            }
        };
        logicListView.setOnItemClickListener(logicListViewListener);
    }
}
