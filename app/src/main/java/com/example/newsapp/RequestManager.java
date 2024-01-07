package com.example.newsapp;

import android.content.Context;
import android.widget.Toast;

import com.example.newsapp.Models.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public RequestManager(Context context) {
        this.context = context;
    }


    //method to manage our api calling we will handle the response for he main aciviy
    public  void GetNewsHeadlines(OnFetchDataListener Listener, String category, String query){
        CallNNewsApi callNNewsApi =retrofit.create(CallNNewsApi.class);
        Call<NewsApiResponse> call =callNNewsApi.callHeadlines("us", category, query, context.getString(R.string.api_key));
        try {
            call.enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                    }
                    Listener.OnFetchData(response.body().getArticles(), response.message());

                }

                @Override
                public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                    Listener.OnError("Request Failed!");

                }
            });
        }catch(Exception e){
            e.printStackTrace();

        }
    }

    //now to manager our api request we will create this interface
    public  interface  CallNNewsApi {
        @GET("top-headlines")
        Call<NewsApiResponse> callHeadlines(
                @Query("country") String country,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apiKey") String api_key


        );
    }
}
