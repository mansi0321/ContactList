package com.developer.contactlist;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
    Activity activity;
    ArrayList<ContactModel> arrayList;

    //create constructor
    public MainAdapter(Activity activity, ArrayList<ContactModel> arrayList){
        this.activity = activity;
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }


    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull MainAdapter.viewHolder holder, int position) {
          ContactModel model = arrayList.get(position);

          holder.tvname.setText(model.getName());

          holder.tvnumber.setText(model.getNumber());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        public  TextView tvname;
        public TextView tvnumber;


        public viewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            TextView tvnumber, tvname;
            tvname = itemView.findViewById(R.id.name);
            tvnumber = itemView.findViewById(R.id.number);


        }
    }
}
