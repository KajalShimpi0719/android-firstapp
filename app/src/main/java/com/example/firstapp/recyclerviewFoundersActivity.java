package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        listData.add(new FoudersListData("Steve jobs","Steven Paul Jobs (February 24, 1955 – October 5, 2011) was an American businessman, inventor, and investor best known for co-founding the technology company Apple Inc. Jobs was also the founder of NeXT and chairman and majority shareholder of Pixar. He was a pioneer of the personal computer revolution of the 1970s and 1980s, along with his early business partner and fellow Apple co-founder Steve Wozniak.", R.drawable.apple_founders));
        listData.add(new FoudersListData("Andrew E. Rubin","Andrew E. Rubin (born March 13, 1963) is an American computer programmer, entrepreneur, and venture capitalist. Rubin founded Danger Inc. in 1999 and left in 2003; Danger was eventually acquired by Microsoft in 2008. Rubin founded Android Inc. in 2003, which was acquired by Google in 2005; Rubin served as a Google vice president for nine years and led Google's efforts in creating and promoting the Android operating system for mobile phones and other devices during most of his tenure. Rubin left Google in 2014, initially presented as a voluntary departure; but later revealed to be a dismissal due to allegations of sexual harassment by Rubin.[1] Rubin then served as co-founder and CEO of venture capital firm Playground Global from 2015 to 2019.[2] Rubin also helped found Essential Products in 2015, a mobile phone start-up that closed in 2020 without finding a buyer. In 2019, Rubin was inducted into the Wireless Hall of Fame", R.drawable.android_founder));
        listData.add(new FoudersListData("Aman Gupta","Aman Gupta (born 4 March 1982)[1] is an Indian entrepreneur and angel investor.[2] He is the co-founder and CMO of Indian electronics brand boAt Lifestyle.[3] He is a judge and investor in Sony TV's business reality show Shark Tank India",R.drawable.boat_founder));
        listData.add(new FoudersListData("Peyush Bansal","Lenskart is an Indian multinational eyewear company, based in Gurugram. As a vertically integrated company, it designs, manufactures, distributes, and retails prescription and regular eyewear.[5] It sells its products through website, mobile app and 2,000+ physical stores It has a manufacturing facility located in Bhiwadi, Rajasthan, with an annual production capacity of 5 crore glasses.",R.drawable.lenskart_founder));
        foundersViewAdapter adapter=new foundersViewAdapter(listData, this);
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