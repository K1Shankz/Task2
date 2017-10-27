package com.program.Task2;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentL extends Fragment {
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);

        View rootView =
                inflater.inflate(R.layout.fragment_fragment_l, container, false);


        return rootView;
    }


    public void saveData() {

        EditText et7 = (EditText) getActivity().findViewById(R.id.editTextCommentl);
        EditText et5 = (EditText) getActivity().findViewById(R.id.editText3l);
        EditText et4 = (EditText) getActivity().findViewById(R.id.editTextPlacel);
        EditText et2 = (EditText) getActivity().findViewById(R.id.editTextDatel);
        EditText et = (EditText) getActivity().findViewById(R.id.editTextTitlel);
        ContentValues newValues = new ContentValues();
        newValues.put("C_TITLE", et.getText().toString());
        newValues.put("C_DATE", et2.getText().toString());
        newValues.put("C_TYPE", "WORK");
        newValues.put("C_PLACE", et4.getText().toString());
        newValues.put("C_DURATION", et5.getText().toString());
        newValues.put("C_PHOTO", "path/to/file");
        newValues.put("C_COMMENT", et7.getText().toString());
        newValues.put("C_GPS", "This is a comment");
        MyBase mBase = new MyBase(getActivity());
        mBase.getWritableDatabase().insert("USER_ACTIVIVTY", null, newValues);
        Toast.makeText(getActivity(), "Data is saved", Toast.LENGTH_SHORT).show();
    }


}
