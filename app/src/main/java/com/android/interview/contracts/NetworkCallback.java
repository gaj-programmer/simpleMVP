package com.android.interview.contracts;

import com.android.interview.model.vo.SpeciesVO;

/**
 * Created by gajraj on 26/02/18.
 */

public interface NetworkCallback {
    void onSuccess(SpeciesVO speciesVO);

    void onFailed(String message);

}
