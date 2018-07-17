package com.android.interview.model.vo;

import java.util.List;

/**
 * Created by gajraj on 26/02/18.
 */

public class SpeciesVO {
    private List<ResultsVO> results;

    private String previous;

    private String count;

    private String next;

    public List<ResultsVO> getResults() {
        return results;
    }

    public void setResults(List<ResultsVO> results) {
        this.results = results;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ClassPojo [results = " + results + ", previous = " + previous + ", count = " + count + ", next = " + next + "]";
    }
}