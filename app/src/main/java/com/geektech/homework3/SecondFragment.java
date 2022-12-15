package com.geektech.homework3;

import static com.geektech.homework3.FirstFragment.KEY_COUNT;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    private TextView txt_cur;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt_cur = requireActivity().findViewById(R.id.result);

        String result = getArguments().getString(KEY_COUNT);

        txt_cur.setText(result);

    }
}