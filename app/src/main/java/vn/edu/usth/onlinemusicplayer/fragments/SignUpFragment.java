package vn.edu.usth.onlinemusicplayer.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import vn.edu.usth.onlinemusicplayer.R;


public class SignUpFragment extends Fragment {
    private TextView SIGNIN;
    private FrameLayout frameLayout;
    private EditText userName;
    private EditText email;
    private EditText password;
    private EditText passwordCF;
    private Button signUp;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        SIGNIN= view.findViewById(R.id.SIGNIN);
        frameLayout = getActivity().findViewById(R.id.register);
        userName = view.findViewById(R.id.userName);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        passwordCF = view.findViewById(R.id.passwordCF);
        signUp =  view.findViewById(R.id.signUp);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SIGNIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });

        userName.addTextChangedListener(new TextWatcher() {
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

        passwordCF.addTextChangedListener(new TextWatcher() {
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
        fragmentTransaction.setCustomAnimations(R.anim.left, R.anim.right_out);
    }

    private void checkInputs() {
        if (!userName.getText().toString().isEmpty()) {
            if (!email.getText().toString().isEmpty()) {
                if (!password.getText().toString().isEmpty() && password.getText().toString().length() >= 8) {
                    if (!passwordCF. getText().toString().isEmpty()) {
                        signUp.setEnabled(true);
                        signUp.setTextColor(getResources().getColor(R.color.main));
                    } else {
                        signUp.setEnabled(false);
                        signUp.setTextColor(getResources().getColor(R.color.white));
                    }
                } else {
                        signUp.setEnabled(false);
                        signUp.setTextColor(getResources().getColor(R.color.white));
                }
            } else {
                    signUp.setEnabled(false);
                    signUp.setTextColor(getResources().getColor(R.color.white));
            }
        } else {
                signUp.setEnabled(false);
                signUp.setTextColor(getResources().getColor(R.color.white));
        }
    }
}