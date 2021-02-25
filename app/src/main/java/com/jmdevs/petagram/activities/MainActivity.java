package com.jmdevs.petagram.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Objects;

import com.google.android.material.tabs.TabLayout;
import com.jmdevs.petagram.R;
import com.jmdevs.petagram.adapter.pageAdapter;
import com.jmdevs.petagram.fragments.*;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar ;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        assert toolbar != null;
        toolbar.setTitle("@string/app_name");

        ImageButton imgBtn_star = (ImageButton) findViewById(R.id.imgBtn_star);
        imgBtn_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ultimos5Fav.class);
            startActivity(intent);
            }
        });

    }

    private  ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> frags = new ArrayList<>();
        frags.add(new pet_feed());
        frags.add(new pet_profile());
        return frags;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new pageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_dog_house);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_dog_heart);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_op, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mContacto:
                Intent int1 = new Intent(this, formulario_contacto.class);
                startActivity(int1);
                break;

            case R.id.mAbout:
                Intent int2 = new Intent(this, about.class);
                startActivity(int2);
                break;
        }
    return super.onOptionsItemSelected(item);
    }

}