package com.updev.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.updev.newsapp.Models.NewsHeadlines;

public class DetailsActivity extends AppCompatActivity {

    NewsHeadlines newsHeadlines;
    TextView text_title,text_author,text_time,text_detail,text_content;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        text_title =findViewById(R.id.text_detail_title);
        text_author=findViewById(R.id.text_detail_author);
        text_time=findViewById(R.id.text_detail_time);
        text_detail=findViewById(R.id.text_detail_detail);
        text_content=findViewById(R.id.text_detail_content);
        img_news=findViewById(R.id.img_detail_news);

        newsHeadlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        text_title.setText(newsHeadlines.getTitle());
        text_author.setText(newsHeadlines.getAuthor());
        text_time.setText(newsHeadlines.getPublishedAt());
        text_detail.setText(newsHeadlines.getDescription());
        text_content.setText(newsHeadlines.getContent());


        try {
            Picasso.get().load(newsHeadlines.getUrlToImage()).into(img_news);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}