package com.program.Task2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentActiv extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);

        View rootView =
                inflater.inflate(R.layout.fragment_activ, container, false);
        return rootView;
    }

    public void setID(final int id) {
        final MyBase mBase = new MyBase(getActivity());
        Cursor cursor = mBase.getWritableDatabase().query("USER_ACTIVIVTY",
                new String[]{"C_TITLE", " C_DATE", " C_TYPE", " C_PLACE", " C_DURATION", " C_PHOTO", "C_COMMENT"},
                "_id=?", new String[]{String.valueOf(id)}, null, null, null);

        while (cursor.moveToNext()) {
            int ci1 = cursor.getColumnIndex("C_TITLE");
            int ci2 = cursor.getColumnIndex("C_DATE");

            int ci3 = cursor.getColumnIndex("C_TYPE");
            int ci4 = cursor.getColumnIndex("C_PLACE");
            int ci5 = cursor.getColumnIndex("C_DURATION");
            int ci6 = cursor.getColumnIndex("C_PHOTO");
            int ci7 = cursor.getColumnIndex("C_COMMENT");

            final EditText et7 = (EditText) getActivity().findViewById(R.id.editTextComment);
            et7.setText(cursor.getString(ci7));
            et7.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("C_COMMENT", et7.getText().toString());
                    String where = "_id=" + id;
                    mBase.getWritableDatabase().update("USER_ACTIVIVTY", updatedValues, where, null);


                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });


            final EditText et5 = (EditText) getActivity().findViewById(R.id.editText3);
            et5.setText(cursor.getString(ci5));
            et5.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("C_DURATION", et5.getText().toString());
                    String where = "_id=" + id;
                    mBase.getWritableDatabase().update("USER_ACTIVIVTY", updatedValues, where, null);
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });

            final EditText et4 = (EditText) getActivity().findViewById(R.id.editTextPlace);
            et4.setText(cursor.getString(ci4));
            et4.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("C_PLACE", et4.getText().toString());
                    String where = "_id=" + id;
                    mBase.getWritableDatabase().update("USER_ACTIVIVTY", updatedValues, where, null);
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
            final EditText et2 = (EditText) getActivity().findViewById(R.id.editTextDate);
            et2.setText(cursor.getString(ci2));
            et2.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("C_DATE", et2.getText().toString());
                    String where = "_id=" + id;
                    mBase.getWritableDatabase().update("USER_ACTIVIVTY", updatedValues, where, null);
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });

            final EditText et = (EditText) getActivity().findViewById(R.id.editTextTitle);
            et.setText(cursor.getString(ci1));
            et.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    ContentValues updatedValues = new ContentValues();
                    updatedValues.put("C_TITLE", et.getText().toString());
                    String where = "_id=" + id;
                    mBase.getWritableDatabase().update("USER_ACTIVIVTY", updatedValues, where, null);
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });


        }
        cursor.close();

        Button delB = (Button) getActivity().findViewById(R.id.buttonActDelete);
        delB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBase.getWritableDatabase().delete("USER_ACTIVIVTY", "_id=" + id, null);


                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("foo", "d");
                startActivity(intent);
            }
        });
        Button gpsB = (Button) getActivity().findViewById(R.id.buttonActGPS);
        gpsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }
}
