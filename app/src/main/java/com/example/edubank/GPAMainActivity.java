package com.example.edubank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GPAMainActivity extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;
    Button gpabtn, gpasettingsbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpamain);

        //Assign variable
        drawerLayout = findViewById(R.id.gpamain_layout);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        gpabtn = findViewById(R.id.gpabtn);
        gpasettingsbtn = findViewById(R.id.gpasettingsbtn);

        //Direct to NameAndUniversity Interface and GPASettings Interface
        //Direct to NameAndUniversity Interface
        gpabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nameanduniversityIntent = new Intent(GPAMainActivity.this, NameUniversity.class);
                startActivity(nameanduniversityIntent);
                finish();
            }
        });

        //Direct to GPASettings Interface
        gpasettingsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpaSettingsIntent = new Intent(GPAMainActivity.this, GradePointsAdd.class);
                startActivity(gpaSettingsIntent);
                finish();
            }
        });

        //Set Grades Selected
        bottomNavigationView.setSelectedItemId(R.id.gradesnav);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    /*case R.id.schedulenav:
                        startActivity(new Intent(getApplicationContext(), CalculateGPA.class));
                        overridePendingTransition(0, 0);
                        return true;*/
                    /*case R.id.coursesnav:
                        startActivity(new Intent(getApplicationContext(), FinalGPA.class));
                        overridePendingTransition(0, 0);
                        return true;*/
                    case R.id.gradesnav:
                        return true;
                    /*case R.id.examschedulenav:
                        startActivity(new Intent(getApplicationContext(), NameUniversity.class));
                        overridePendingTransition(0, 0);
                        return true;*/
                }
                return false;
            }
        });
    }

    public void ClickMenu(View view) {
        //Open drawer
        openDrawer(drawerLayout);
    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer Layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        //close drawer
        closeDrawer(drawerLayout);
    }

    private static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    /*public void ClickSettings(View view) {
        //Redirect activity to app settings
        redirectActivity(this,);
    }

    public void ClickVersion(View view) {
        //Redirect activity to app version
        redirectActivity(this,);
    }

    public void ClickAboutUs(View view) {
        //Redirect activity to about
        redirectActivity(this,);
    }

    public void ClickFeedback(View view) {
        //Redirect activity to feedback
        redirectActivity(this,);
    }

    private static void redirectActivity(Activity activity, Class aClass) {
        //Intialize activity
        Intent intent = new Intent(activity, aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }

}