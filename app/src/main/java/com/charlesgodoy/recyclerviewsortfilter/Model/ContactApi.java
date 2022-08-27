package com.charlesgodoy.recyclerviewsortfilter.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactApi {

    // Used by Retrofit

    @GET("hiring.json")
    Call<List<Contact>> getAllContacts();
}
