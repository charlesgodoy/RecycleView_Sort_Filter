package com.charlesgodoy.recyclerviewsortfilter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.charlesgodoy.recyclerviewsortfilter.Model.Contact;
import com.charlesgodoy.recyclerviewsortfilter.databinding.ItemNameBinding;

import java.util.List;

// RecyclerView adapter to create and bind views
// Stores data into a list of contacts

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    List<Contact> listOfContacts;

    public ContactAdapter(List<Contact> listOfContacts) {
        this.listOfContacts = listOfContacts;
    }

    @NonNull
    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemNameBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.MyViewHolder holder, int position) {

        Contact contact = listOfContacts.get(position);

        holder.itemNameBinding.tvName.setText(contact.getName());
        holder.itemNameBinding.tvId.setText(String.valueOf(contact.getId()));
        holder.itemNameBinding.tvListId.setText(String.valueOf(contact.getListId()));

    }

    @Override
    public int getItemCount() {
        return listOfContacts.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ItemNameBinding itemNameBinding;

        public MyViewHolder(ItemNameBinding itemNameBinding) {
            super(itemNameBinding.getRoot());

            this.itemNameBinding = itemNameBinding;
        }
    }
}
