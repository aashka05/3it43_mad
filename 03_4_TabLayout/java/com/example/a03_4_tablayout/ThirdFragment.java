package com.example.a03_4_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }
}