package com.dedsec.materialui.content;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;

public class ContentTabsStore extends Fragment {

    public ContentTabsStore() {
    }

    public static ContentTabsStore newInstance() {
        ContentTabsStore fragment = new ContentTabsStore();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.content_tabs_store, container, false);

        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_1), R.drawable.img_bird);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_2), R.drawable.img_eroded_granite);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_3), R.drawable.img_flower);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_4), R.drawable.img_island);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_5), R.drawable.img_mountain);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_6), R.drawable.img_fox);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.image_7), R.drawable.img_balcony);

        return root;
    }

}
