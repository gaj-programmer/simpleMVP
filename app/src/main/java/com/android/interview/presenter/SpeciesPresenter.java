package com.android.interview.presenter;

import com.android.interview.contracts.NetworkCallback;
import com.android.interview.contracts.SpeciesView;
import com.android.interview.model.Network;
import com.android.interview.model.vo.SpeciesVO;

import java.io.IOException;

/**
 * Created by gajraj on 26/02/18.
 */

public class SpeciesPresenter extends BasePresenter implements NetworkCallback {
    private SpeciesView mView;

    public SpeciesPresenter(SpeciesView view) {
        mView = view;
    }

    public void getSpecies(int page) {
        Network network = Network.getInstance();
        try {
            network.getOkHttpLib().doFetchSpecies(this, page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(SpeciesVO speciesVO) {
        mView.doUpdateSpeciesOnUI(speciesVO);
    }

    @Override
    public void onFailed(String message) {

    }
}
