package com.android.interview.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.interview.R;
import com.android.interview.contracts.SpeciesView;
import com.android.interview.model.vo.SpeciesVO;
import com.android.interview.presenter.SpeciesPresenter;

public class MainActivity extends AppCompatActivity implements SpeciesView {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SpeciesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initialization();
        addListeners();

    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
    }

    private void initialization() {
        presenter = new SpeciesPresenter(this);
        doRequestToGetSpeciesData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void addListeners() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                doRequestToGetSpeciesData();
            }
        });
    }

    private void doRequestToGetSpeciesData() {
        presenter.getSpecies(1);
    }

    @Override
    public void doUpdateSpeciesOnUI(SpeciesVO speciesVO) {
        swipeRefreshLayout.setRefreshing(false);
        SpeciesViewAdapter adapter = new SpeciesViewAdapter(speciesVO.getResults());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }
}
