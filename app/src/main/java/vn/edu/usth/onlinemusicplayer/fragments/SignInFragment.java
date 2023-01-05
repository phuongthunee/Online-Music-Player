package vn.edu.usth.onlinemusicplayer.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.security.ConfirmationNotAvailableException;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import vn.edu.usth.onlinemusicplayer.MainActivity;
import vn.edu.usth.onlinemusicplayer.R;
import vn.edu.usth.onlinemusicplayer.Register;

public class SignInFragment extends Fragment {
    private TextView SIGNUP;
    private TextView resetPassword;
    private FrameLayout frameLayout;

    private EditText email;
    private EditText password;
    private Button signIn;

    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        SIGNUP = view.findViewById(R.id.SIGNUP);
        resetPassword = view.findViewById(R.id.resetPassword);
        frameLayout = getActivity().findViewById(R.id.register);

        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        signIn = view.findViewById(R.id.signIn);

        mAuth = FirebaseAuth.getInstance();
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }
        });
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ResetPwFragment());
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
        fragmentTransaction.setCustomAnimations(R.anim.right, R.anim.left_out);
    }
    private void checkInputs() {
        if (!email.getText().toString().isEmpty()) {
            if (!email.getText().toString().isEmpty()) {

            } else {

            }
        } else {
            signIn.setEnabled(false);
            signIn.setTextColor(getResources().getColor(R.color.white));
        }
    }
}