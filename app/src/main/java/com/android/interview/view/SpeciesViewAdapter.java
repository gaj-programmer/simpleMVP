package com.android.interview.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.interview.R;
import com.android.interview.model.vo.ResultsVO;

import java.util.List;

/**
 * Created by gajraj on 26/02/18.
 */

public class SpeciesViewAdapter extends RecyclerView.Adapter<SpeciesViewAdapter.MyViewHolder> {

    private List<ResultsVO> speciesList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, classification, designation;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tv_name);
            classification = (TextView) view.findViewById(R.id.tv_classification);
            designation = (TextView) view.findViewById(R.id.tv_designation);
        }
    }

    public SpeciesViewAdapter(List<ResultsVO> speciesList) {
        this.speciesList = speciesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ResultsVO resultsVO = speciesList.get(position);
        holder.name.setText(resultsVO.getName());
        holder.classification.setText(resultsVO.getClassification());
        holder.designation.setText(resultsVO.getDesignation());
    }

    @Override
    public int getItemCount() {
        return speciesList.size();
    }
}