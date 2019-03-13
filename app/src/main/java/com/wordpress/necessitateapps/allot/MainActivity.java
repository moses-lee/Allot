package com.wordpress.necessitateapps.allot;


import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.wordpress.necessitateapps.allot.fragments.CalendarFragment;
import com.wordpress.necessitateapps.allot.fragments.WhatFragment;
import com.wordpress.necessitateapps.allot.fragments.WhenFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WhatFragment.OnFragmentInteractionListener, WhenFragment.OnFragmentInteractionListener{

    @BindView(R.id.frame) FrameLayout frameLayout;
    @BindView(R.id.image_menu) ImageView imageMenu;
    private WhatFragment whatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        nextFrag();

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openMenu();

            }
        });
    }

    private void nextFrag() {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // WhatFragment whatFragment = WhatFragment.newInstance();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);
        transaction.add(R.id.frame, whatFragment, "WHAT_FRAGMENT").commit();

    }

    private void openMenu() {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        CalendarFragment myFragment = (CalendarFragment)getSupportFragmentManager().findFragmentByTag("MENU_FRAGMENT");
        if (myFragment == null) {
            CalendarFragment calendarFragment = CalendarFragment.newInstance();
            transaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom,R.anim.enter_from_bottom, R.anim.exit_to_bottom);
            transaction.addToBackStack(null);
            transaction.add(R.id.frame, calendarFragment, "MENU_FRAGMENT").commit();
        } else {
            onBackPressed();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //nextFrag();
    }
}
