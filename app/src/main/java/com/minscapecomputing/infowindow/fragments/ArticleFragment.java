package com.minscapecomputing.infowindow.fragments;

import com.minscapecomputing.infowindow.R;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import uk.co.deanwild.flowtextview.FlowTextView;

public class TabFragment extends Fragment {

    LinearLayout linearLayout;

    public enum TEMPLATE {
        IMAGE_TEXT,
        VIDEO_TEXT,
        ONLY_IMAGE,
        ONLY_VIDEO,
        ONLY_TEXT
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_fragment, container, false);

        init(view);
        setContent(container);

        return view;
    }

    private void init(View view) {

        linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
    }

    public void setContent(ViewGroup container) {

        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        createView(TEMPLATE.IMAGE_TEXT, inflater, container);
        createView(TEMPLATE.VIDEO_TEXT, inflater, container);
        createView(TEMPLATE.IMAGE_TEXT, inflater, container);
    }

    private void createView(TEMPLATE type, LayoutInflater inflater, ViewGroup container) {

        switch (type) {

            case IMAGE_TEXT: {
                View view = inflater.inflate(R.layout.image_with_text, container, false);
                FlowTextView flowTextView = (FlowTextView) view.findViewById(R.id.textView);
                flowTextView.setText("Our heritage and artisan communities need to be increasingly relevant for modern society. To this end, Caravan works towards a sophisticated language for Indic crafts. Every Caravan product has a handcrafted element from a traditional Indian craft cluster. To achieve precision and consistent quality, which is the hallmark of Caravan, artisan communities are up-skilled to achieve the level of desired sophistication.");
                try {
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "RobotoRegular.ttf");
                    flowTextView.setTypeface(typeface);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                flowTextView.setTextSize(16f);
                linearLayout.addView(view);
                break;
            }
            case VIDEO_TEXT: {
                linearLayout.addView(inflater.inflate(R.layout.video_with_text, container, false));
                break;
            }
        }
    }
}
