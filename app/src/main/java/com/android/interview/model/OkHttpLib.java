package com.android.interview.model;

import android.os.Handler;
import android.os.Looper;

import com.android.interview.contracts.NetworkCallback;
import com.android.interview.model.vo.ResultsVO;
import com.android.interview.model.vo.SpeciesVO;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gajraj on 26/02/18.
 */

public class OkHttpLib {
    String baseUrl = "https://swapi.co/api/species/?";

    public void doFetchSpecies(final NetworkCallback networkCallback, int page) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(baseUrl + "page=" + page)
                .build();
        Response response = null;
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        networkCallback.onFailed("Failed to get Results");
                    }
                });
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final SpeciesVO speciesVO = new SpeciesVO();
                    List<ResultsVO> resultsVOList = new ArrayList<>();
                    try {
                        JSONObject json = new JSONObject(response.body().string());
                        JSONArray jsonArray = json.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String name = jsonObject.getString("name");
                            String classification = jsonObject.getString("classification");
                            String designation = jsonObject.getString("designation");
                            ResultsVO resultsVO = new ResultsVO(name, classification, designation);
                            resultsVOList.add(resultsVO);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    speciesVO.setResults(resultsVOList);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            networkCallback.onSuccess(speciesVO);
                        }
                    });
                }
            }
        });
    }

}
