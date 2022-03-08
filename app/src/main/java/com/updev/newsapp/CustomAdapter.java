package com.updev.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.updev.newsapp.Models.NewsHeadlines;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<NewsHeadlines> headlines;
    private  SelectListner listner;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines,SelectListner  listner) {
        this.context = context;
        this.headlines = headlines;
        this.listner =listner;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headlines_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.text_title.setText(headlines.get(position).getTitle());
       holder.text_source.setText(headlines.get(position).getSource().getName());

        try {
            if(headlines.get(position).getUrlToImage() != null)
            {
                Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
            }
            else
            {
                Picasso.get().load(R.drawable.not_available).into(holder.img_headline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listner.OnNewsClicked(headlines.get(position));
           }
       });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
