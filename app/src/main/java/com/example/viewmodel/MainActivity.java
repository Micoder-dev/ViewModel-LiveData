package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    Button mButton;

    MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.clickBtn);

        // Using Live Data to get the counter
        LiveData<Integer> count = mMainActivityViewModel.getInitialCount();
        count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTextView.setText("You clicked me: "+ integer + " times");
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainActivityViewModel.getCounter();
            }
        });

    }
}