package com.program.Task2;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;


public class FragmentUI extends Fragment {
    private MyBase mBase;
    private EditText et;
    private EditText et2;
    private EditText et3;
    private EditText et4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);

        View rootView =
                inflater.inflate(R.layout.fragment_fragment_ui, container, false);
        mBase = new MyBase(getActivity());
        Cursor cursor = mBase.getWritableDatabase().query("USER_Settings",
                new String[]{"COLUMN_NAME", "COLUMN_ID", "COLUMN_GENDER", "COLUMN_MAIL", "COLUMN_COMMENT"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int ci1 = cursor.getColumnIndex("COLUMN_NAME");
            int ci2 = cursor.getColumnIndex("COLUMN_ID");
            int ciG = cursor.getColumnIndex("COLUMN_GENDER");
            int ci3 = cursor.getColumnIndex("COLUMN_MAIL");
            int ci4 = cursor.getColumnIndex("COLUMN_COMMENT");
            et = (EditText) rootView.findViewById(R.id.editTextUIName);
            et.setText(cursor.getString(ci1));
            et.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("COLUMN_NAME", et.getText().toString());
                    String where = "_id=1";
                    mBase.getWritableDatabase().update("USER_Settings", updatedValues, where, null);
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
            et2 = (EditText) rootView.findViewById(R.id.editTextUIID);
            et2.setText(cursor.getString(ci2));
            et2.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("COLUMN_ID", et2.getText().toString());
                    String where = "_id=1";
                    mBase.getWritableDatabase().update("USER_Settings", updatedValues, where, null);
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
            //     et2.setOnFocusChangeListener(Focus_1);
            switch (cursor.getString(ciG).toLowerCase()) {
                case "male":
                    RadioButton rbm = (RadioButton) rootView.findViewById(R.id.radioButtonUIM);
                    rbm.setSelected(true);
                    break;
                default:
                    RadioButton rbf = (RadioButton) rootView.findViewById(R.id.radioButtonUIF);
                    rbf.setSelected(true);
                    break;
            }
            et3 = (EditText) rootView.findViewById(R.id.editTextUIEmail);
            et3.setText(cursor.getString(ci3));
            et3.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("COLUMN_MAIL", et3.getText().toString());
                    String where = "_id=1";
                    mBase.getWritableDatabase().update("USER_Settings", updatedValues, where, null);
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
            //   et3.setOnFocusChangeListener(Focus_1);
            et4 = (EditText) rootView.findViewById(R.id.editTextUICOmment);
            et4.setText(cursor.getString(ci4));
            et4.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("COLUMN_COMMENT", et4.getText().toString());
                    String where = "_id=1";
                    mBase.getWritableDatabase().update("USER_Settings", updatedValues, where, null);
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
            //  et4.setOnFocusChangeListener(Focus_1);
        }


        return rootView;
    }
}
