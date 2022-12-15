package vn.edu.usth.onlinemusicplayer.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.onlinemusicplayer.R;

public class SignInFragment extends Fragment {
    private TextView youDontAlreadyHaveAnAccount;
    private TextView resetPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        youDontAlreadyHaveAnAccount= view.findViewById(R.id.youDontAlreadyHaveAnAccount);
        resetPassword = view.findViewById(R.id.resetPassword);
        return view;
    }
}