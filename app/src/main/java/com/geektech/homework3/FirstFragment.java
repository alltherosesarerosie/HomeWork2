package com.geektech.homework3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {
    private Button btn_count;
    private TextView txt_c;
    final static String KEY_COUNT = "count";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        clickListener();

    }

    private void initView() {
        btn_count = requireActivity().findViewById(R.id.btn_counter);
        txt_c = requireActivity().findViewById(R.id.tv_counter);
    }

    private void clickListener() {
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextFragment();
            }
        });
    }

    private void nextFragment() {
        Bundle bundle = new Bundle();
        String text_r = txt_c.getText().toString().trim();
        int text_r_int = Integer.parseInt(text_r);

        if(text_r_int==20){
            bundle.putString(KEY_COUNT, text_r);
            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment ).addToBackStack(null).commit();
        }
        text_r_int++;
        setToBtn(text_r_int);

        }

    private void setToBtn(Integer text_r_int){
        txt_c.setText(text_r_int.toString());
    }

}