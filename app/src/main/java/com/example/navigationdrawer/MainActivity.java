package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showHomePage();

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_food) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new FoodFragment())
                            .commit();
                    getSupportActionBar().setTitle("Traditional Food");
                } else if (itemId == R.id.nav_drink) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new DrinkFragment())
                            .commit();
                    getSupportActionBar().setTitle("Traditional Drink");
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new FavoriteFragment())
                            .commit();
                    getSupportActionBar().setTitle("Favorite");
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showHomePage() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FoodFragment())
                .commit();

        getSupportActionBar().setTitle("Authenthic of Ind's");
    }
}
