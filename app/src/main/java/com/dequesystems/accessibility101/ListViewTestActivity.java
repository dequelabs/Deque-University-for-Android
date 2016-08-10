package com.dequesystems.accessibility101;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by melindakothbauer on 7/21/16.
 */
public class ListViewTestActivity extends Fragment {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private LinearLayout mLinearLayout;
    private CheckBox mCheckBox;

    public ListViewTestActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listview_test, container, false);

        mListView = (ListView) view.findViewById(R.id.fragment_listview_test_listview);

        //mLinearLayout = (LinearLayout) view.findViewById(R.id.fragment_listview_test_linearlayout);
        //mLinearLayout.setContentDescription("linear layout bro");

        ArrayList<String> list = new ArrayList<>();
        list.add("text");

        mAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);

        mListView.setAdapter(mAdapter);

        return view;
    }

}
