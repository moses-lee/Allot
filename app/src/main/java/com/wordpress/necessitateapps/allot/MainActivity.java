package com.wordpress.necessitateapps.allot;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.support.v7.widget.OrientationHelper;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




    }

}
