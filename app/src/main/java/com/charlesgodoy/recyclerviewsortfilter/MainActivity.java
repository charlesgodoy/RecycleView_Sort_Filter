package com.charlesgodoy.recyclerviewsortfilter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.charlesgodoy.recyclerviewsortfilter.Model.Contact;
import com.charlesgodoy.recyclerviewsortfilter.Model.ContactApi;
import com.charlesgodoy.recyclerviewsortfilter.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// By Charles Godoy
// After getting listOfContacts, create a new Arraylist and use a loop to filter out
// all null and empty String objects
// Then use Collections.sort and use a Comparator to sort with listId, then by name

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ContactApi contactApi;
    List<Contact> listOfContacts;
    ArrayList<Contact> finalListOfContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        finalListOfContacts = new ArrayList<>();
        contactApi = NetworkService.getClient().create(ContactApi.class);
        Call<List<Contact>> call = contactApi.getAllContacts();

        // Use Retrofit enqueue to do the call in another thread
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {

                // After getting response.body, iterate through data and remove null/"" objects
                // and then save to finalListOfContacts
                listOfContacts = response.body();
                for (int i = 0; i < listOfContacts.size(); i++) {
                    if (listOfContacts.get(i).getName() == null || listOfContacts.get(i).getName() == "") {

                    } else {
                        finalListOfContacts.add(listOfContacts.get(i));
                    }
                }

                // Finally, use Collections.sort with Comparator, and sort
                Collections.sort(finalListOfContacts, new Comparator<Contact>() {
                    @Override
                    public int compare(Contact record1, Contact record2) {

                        int compareFlag;
                        compareFlag = String.valueOf(record1.getListId()).compareTo(String.valueOf(record2.getListId()));
                        if (compareFlag == 0) {
                            compareFlag = record1.getName().compareTo(record2.getName());
                        }
                        if (compareFlag == 0) {
                            compareFlag = String.valueOf(record1.getId()).compareTo(String.valueOf(record2.getId()));
                        }

                        return compareFlag;
                    }
                });

                // Create layoutManager and set recyclerview in the layout to the adapter
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                ContactAdapter adapter = new ContactAdapter(finalListOfContacts);
                binding.rvName.setLayoutManager(layoutManager);
                binding.rvName.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}