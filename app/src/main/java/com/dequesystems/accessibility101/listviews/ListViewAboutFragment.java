package com.dequesystems.accessibility101.listviews;


import android.app.Activity;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.dequesystems.accessibility101.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewAboutFragment extends Fragment {

    ListView mListView;
    ArrayList<String> mListItems;
    customAdapter mListAdapter;
    ImageView mImageView;

    public ListViewAboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_view_about, container, false);

        mListItems = new ArrayList<>();
        mListView = (ListView) view.findViewById(R.id.aac_listView_about_list_view);

        mImageView = (ImageView) view.findViewById(R.id.aac_listView_about_imageView);

        mListItems.add(getResources().getString(R.string.aac_listView_about_list_item_1));
        mListItems.add(getResources().getString(R.string.aac_listView_about_list_item_2));
        mListItems.add(getResources().getString(R.string.aac_listView_about_list_item_3));

        mListAdapter = new customAdapter(getActivity(), R.layout.list_view_about_list_item, mListItems);

        mListView.setAdapter(mListAdapter);
        //Utility.setListViewHeightBasedOnChildren(mListView);

        mListAdapter.notifyDataSetChanged();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mImageView.setImageResource(R.drawable.dog);
                        break;
                    case 1:
                        mImageView.setImageResource(R.drawable.cat);
                        break;
                    case 2:
                        mImageView.setImageResource(R.drawable.fish);
                        break;
                }
            }
        });

        return view;
    }

    private class customAdapter extends ArrayAdapter {

        Context mContext;
        ArrayList<String> mArrayList;
        int mResId;

        public customAdapter(Context context, int resID, List<String> list) {
            super(context, resID, mListItems);
            mContext = context;
            mResId = resID;
            mArrayList = (ArrayList<String>) list;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(mResId, null);
            TextView textView = (TextView) convertView.findViewById(R.id.aac_listView_textView);
            textView.setText(mArrayList.get(position));

            switch (position) {
                case 1:
                    convertView = inflater.inflate(R.layout.list_view_item_switch, null);

                    TextView textView1 = (TextView) convertView.findViewById(R.id.listView_item_switch_textView);
                    textView1.setText(mArrayList.get(position));

                    final Switch switch1 = (Switch) convertView.findViewById(R.id.listView_item_switch);
                    switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked) {
                                mImageView.setImageResource(R.drawable.cat);
                            }
                        }
                    });

                    break;
            }
            return convertView;
        }

    }
}
