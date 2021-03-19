package com.panshul.devspace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.panshul.devspace.Fragments.ClockFragment;
import com.panshul.devspace.Fragments.FriendsFragment;
import com.panshul.devspace.Fragments.ListFragment;
import com.panshul.devspace.Fragments.MusicFragment;
import com.panshul.devspace.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ListFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfragment = null;
                switch (item.getItemId()){
                    case R.id.navigation_list:
                        selectedfragment = new ListFragment();
                        break;
                    case R.id.navigation_clock:
                        selectedfragment = new ClockFragment();
                        break;
                    case R.id.navigation_music:
                        selectedfragment = new MusicFragment();
                        break;
                    case R.id.navigation_friends:
                        selectedfragment = new FriendsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedfragment).commit();
                return  true;
            }
        });
    }
}