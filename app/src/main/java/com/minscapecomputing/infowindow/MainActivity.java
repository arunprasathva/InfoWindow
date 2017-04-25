package com.minscapecomputing.infowindow;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListener();
    }

    private void setListener() {

        findViewById(R.id.info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list = new ArrayList<>();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("list", list);
                InfoWindowFragment infoWindowFragment = InfoWindowFragment.newInstance(bundle);
                infoWindowFragment.show(getSupportFragmentManager(), "Info Window Fragment");
            }
        });
    }
}
