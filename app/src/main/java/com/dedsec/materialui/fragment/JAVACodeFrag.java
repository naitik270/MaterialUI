package com.dedsec.materialui.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dedsec.materialui.R;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.classifier.CodeProcessor;
import io.github.kbiakov.codeview.highlight.ColorTheme;
import io.github.kbiakov.codeview.highlight.Font;

public class JAVACodeFrag extends Fragment {

    private CodeView codeView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_java_code, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setData(View view, Context ctx, String code) {
        CodeProcessor.init(ctx);
        codeView = view.findViewById(R.id.codeview_java);
        codeView.setOptions(Options.Default.get(ctx)
                .withLanguage("java")
                .withCode(code)
                .withTheme(ColorTheme.MONOKAI)
                .withFont(Font.DroidSansMonoSlashed));
    }

    public CodeView getCodeLytJava(View view) {
        codeView = view.findViewById(R.id.codeview_java);
        return codeView;
    }

}