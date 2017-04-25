package com.minscapecomputing.infowindow;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class InfoWindowFragment extends android.support.v4.app.DialogFragment {

    private Activity activity;
    private ArrayList<String> list;

    private Bundle bundle;
    private ViewPager viewPager;
    private TabPageIndicator indicator;

    public InfoWindowFragment() {
    }

    public static InfoWindowFragment newInstance(Bundle args) {
        InfoWindowFragment fragment = new InfoWindowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(InfoWindowFragment.STYLE_NO_TITLE, R.style.AppDialogTheme);
        activity = getActivity();

        if (getArguments() != null) {
            bundle = getArguments();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image_fullview, container, false);

        init(rootView);
        if (bundle != null) {
            list = bundle.getStringArrayList("list");
            populateData();
        }

        setListener(rootView);

        return rootView;
    }

    private void setListener(View view) {

        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private void populateData() {


    }

    private void init(View rootView) {

        viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        indicator = (TabPageIndicator) rootView.findViewById(R.id.indicator);
    }

    @Override
    public void onStart() {
        super.onStart();

        // safety check
        if (getDialog() == null)
            return;

//        LoginParam loginParam = new LoginParam();
//        int width = loginParam.getScreenWidth(activity);
        int dialogWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
        int dialogHeight = ViewGroup.LayoutParams.WRAP_CONTENT;

        Window window = getDialog().getWindow();
        window.setLayout(dialogWidth, dialogHeight);
        window.setGravity(Gravity.TOP);

        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = -100;
        window.setAttributes(params);
    }

    private String optString(Bundle b, String key) {
        if (b.containsKey(key)) return b.getString(key);
        return "";
    }
}