package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.firstapp.databinding.ActivityRecyclerviewFoundersBinding;

import java.util.ArrayList;
import java.util.List;

public class recyclerviewFoundersActivity extends AppCompatActivity {

    ActivityRecyclerviewFoundersBinding binding;
    List<FoudersListData> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityRecyclerviewFoundersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listData=new ArrayList<>();
        listData.add(new FoudersListData("One","Description1", R.drawable.apple_founders));
        listData.add(new FoudersListData("Two","Description2", R.drawable.android_founder));
        listData.add(new FoudersListData("Three","Description3",R.drawable.boat_founder));
        listData.add(new FoudersListData("Four","Description4",R.drawable.lenskart_founder));
        listData.add(new FoudersListData("five","Description5", R.drawable.apple_founders));
        listData.add(new FoudersListData("six","Description6", R.drawable.android_founder));
        listData.add(new FoudersListData("seven","Description7",R.drawable.boat_founder));
        listData.add(new FoudersListData("eight","Description8",R.drawable.lenskart_founder));
        foundersViewAdapter adapter=new foundersViewAdapter(listData, getApplicationContext());
        binding.fdlist.setHasFixedSize(true);
        // binding.rvlist.setLayoutManager(new LinearLayoutManager(this));
        binding.fdlist.setLayoutManager(new GridLayoutManager(this, 2));
        binding.fdlist.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}