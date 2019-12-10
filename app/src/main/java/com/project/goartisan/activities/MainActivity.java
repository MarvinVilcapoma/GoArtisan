package com.project.goartisan.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.project.goartisan.R;
import com.project.goartisan.fragments.CarritoFragment;
import com.project.goartisan.fragments.HomeFragment;
import com.project.goartisan.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private LinearLayout linearLayout;
    private RecyclerView productlist;
    private HomeFragment homeFragment;
    private CarritoFragment carritoFragment;
    private PerfilFragment perfilFragment;
    private BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        carritoFragment = new CarritoFragment();
        perfilFragment = new PerfilFragment();

        initialize();

        /*
        menu = findViewById(R.id.btn_nav);


        linearLayout = findViewById(R.id.content_layout);
        setFragment(homeFragment);
        menu.setSelectedItemId(R.id.item1);
        setTitle("Option 1");

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        setTitle("Option 1");
                        menu.setItemBackgroundResource(R.color.green);
                        setFragment(homeFragment);
                        return true;
                    case R.id.item2:
                        setTitle("Option 2");
                        menu.setItemBackgroundResource(R.color.green);
                        setFragment(carritoFragment);
                        return true;
                    case R.id.item3:
                        setTitle("Option 3");
                        menu.setItemBackgroundResource(R.color.green);
                        setFragment(perfilFragment);
                        return true;
                }
                return false;
            }
        });
    }

    /*private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, fragment);
        fragmentTransaction.commit();
    }
    */
    }
    private void initialize(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        final Long id = sp.getLong("id", 0);

    }

    public void irPerfil(View view) {
        startActivity(new Intent(this, PerfilActivity.class));
    }
}





