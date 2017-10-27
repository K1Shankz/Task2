package com.program.Task2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class FragmentMain extends Fragment implements View.OnClickListener {
    private MyBase mBase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);

        View rootView =
                inflater.inflate(R.layout.fragment_fragment_main, container, false);
        Button button1 = (Button) rootView.findViewById(R.id.buttonLog);
        Button button2 = (Button) rootView.findViewById(R.id.buttonUI);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recView);


        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        RVAdapter adapter = new RVAdapter(getData(), new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Activis item) {
                Intent intent = new Intent(getActivity(), ActivityActiv.class);
                intent.putExtra("id", item.id);
                startActivity(intent);

            }
        });
        rv.setAdapter(adapter);


        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.buttonLog:
                intent = new Intent(getActivity(), ActivityL.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.buttonUI:
                intent = new Intent(getActivity(), ActivityUI.class);
                startActivity(intent);
                break;
        }


    }

    private List<Activis> getData() {
        mBase = new MyBase(getActivity());
        Cursor cursor = mBase.getWritableDatabase().query("USER_ACTIVIVTY",
                new String[]{"_id", "C_TITLE", " C_DATE", " C_PLACE"},
                null, null, null, null, null);
        ArrayList<Activis> al = new ArrayList<>();
        while (cursor.moveToNext()) {
            int ci0 = cursor.getColumnIndex("_id");
            int ci1 = cursor.getColumnIndex("C_TITLE");
            int ci2 = cursor.getColumnIndex("C_DATE");
            int ci4 = cursor.getColumnIndex("C_PLACE");
            al.add(new Activis(cursor.getInt(ci0), cursor.getString(ci1), cursor.getString(ci2), cursor.getString(ci4)));
        }
        cursor.close();
        return al;
    }

    public void getRV() {
        RecyclerView rv = (RecyclerView) getActivity().findViewById(R.id.recView);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        RVAdapter adapter = new RVAdapter(getData(), new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Activis item) {
                Intent intent = new Intent(getActivity(), ActivityActiv.class);
                intent.putExtra("id", item.id);
                startActivity(intent);

            }
        });
        rv.setAdapter(adapter);

    }
}