package com.example.aaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.aaaa.models.Item;

public class Shop extends AppCompatActivity {
    ImageButton volver2;
    ImageButton imagenBoton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        volver2 = findViewById(R.id.volver2);
        volver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Shop.this, Home.class);
                startActivity(i);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setItems(Item.getData());
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Item item) {
                //Aquí recibe el item sobre el que hemos hecho click
                String Item = item.getNombre();
                Log.d("Nombre item: ","" + Item);
            }
        });
    }
}