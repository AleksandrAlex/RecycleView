package com.suslovalex.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainMenuActivity extends AppCompatActivity implements RecyclerAdapter.OnClickListener {
    private List<Card> cards = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareCardsData();

        recyclerView = findViewById(R.id.myRecycleView);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter = new RecyclerAdapter(cards, this);
        recyclerView.setAdapter(recyclerAdapter);


    }

    private void prepareCardsData() {

        cards.add(new Card("title: first item","description: first item description",R.drawable.ic_android));
        cards.add(new Card("title: second item","description: second item description",R.drawable.ic_build));
        cards.add(new Card("title: third item","description: third item description",R.drawable.ic_wb_sunny));


    }

    @Override
    public void onClick(int position) {
        cards.get(position);
        Toast toast = Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT);
        toast.show();
    }
}
