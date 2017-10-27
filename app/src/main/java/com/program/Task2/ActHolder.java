package com.program.Task2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ActHolder extends RecyclerView.ViewHolder {
    private TextView aTitleView;
    private TextView aDateView;
    private TextView aPlaceView;

    private Activis aAct;

    public ActHolder(View itemView) {
        super(itemView);
        aTitleView = (TextView) itemView.findViewById(R.id.actTitleView);
        aDateView = (TextView) itemView.findViewById(R.id.actDateView);
        aPlaceView = (TextView) itemView.findViewById(R.id.actPlaceView);
    }

    void bind(final Activis person, final RVAdapter.OnItemClickListener listener) {
        aAct = person;
        aTitleView.setText(aAct.title);
        aDateView.setText(aAct.date);
        aPlaceView.setText(aAct.place);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(person);
            }
        });
    }


}