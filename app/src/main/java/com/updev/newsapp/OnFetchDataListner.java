package com.updev.newsapp;

import com.updev.newsapp.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListner<NewsApiResponse> {

    void onFetchData(List<NewsHeadlines> list,String message);
    void Error(String message);

}
