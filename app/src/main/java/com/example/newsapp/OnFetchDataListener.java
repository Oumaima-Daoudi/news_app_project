package com.example.newsapp;

import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {

    void OnFetchData(List<NewsHeadlines> list, String message);
    void OnError(String message);
}
