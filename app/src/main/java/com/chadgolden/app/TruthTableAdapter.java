package com.chadgolden.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Chad on 2/14/2015.
 */
public class TruthTableAdapter extends BaseAdapter {

    private Context context;
    private String circuitName;

    public TruthTableAdapter(Context context, String circuitName) {
        this.context = context;
        this.circuitName = circuitName;
    }

    @Override
    public int getCount() {
        return getTableAsRow().length;
    }

    @Override
    public Object getItem(int position) {
        return getTableAsRow()[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = new View(context);
            gridView = inflater.inflate(R.layout.label, null);
            TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
            textView.setText(getTableAsRow()[position]);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    /**
     * @return Truth table array.
     */
    public String[] getTableAsRow() {
        String[][] table = new TruthTableFactory().createTruthTable(circuitName);
        String[] retVal = new String[table.length * table[0].length];

        // Convert 2D array to 1D
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                retVal[table[0].length * i + j] = table[i][j];
            }
        }
        return retVal;
    }

    /**
     * @return The number of columns to display for the truth table.
     */
    public int numberOfColumns() {
        return new TruthTableFactory().createTruthTable(circuitName)[0].length;
    }

}
