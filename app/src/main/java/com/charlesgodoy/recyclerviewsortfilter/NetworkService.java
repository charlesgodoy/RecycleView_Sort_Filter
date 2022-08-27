package com.charlesgodoy.recyclerviewsortfilter;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

// Used by Retrofit to get baseUrl and convert json objects to java objects using MoshiConverterFactory

public class NetworkService {

    public static final String BASEURL = "https://fetch-hiring.s3.amazonaws.com/";
    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        return retrofit;
    }
}
