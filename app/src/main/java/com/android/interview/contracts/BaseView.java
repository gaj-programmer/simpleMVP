package com.android.interview.contracts;

/**
 * Created by gajraj on 26/02/18.
 */

public interface BaseView {
    void showLoading();

    void hideLoading();

    void showErrorMessage(String errorMessage);
}
