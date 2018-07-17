package com.android.interview.model;

/**
 * Created by gajraj on 26/02/18.
 */

public class Network {
    private static Network mInstance;

    private Network() {
    }

    public static Network getInstance() {
        if (mInstance == null) {
            mInstance = new Network();
        }
        return mInstance;
    }

    public OkHttpLib getOkHttpLib() {
        OkHttpLib okHttpLib = new OkHttpLib();
        return okHttpLib;
    }

}
