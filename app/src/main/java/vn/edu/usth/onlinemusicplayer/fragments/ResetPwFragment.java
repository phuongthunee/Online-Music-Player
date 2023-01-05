package vn.edu.usth.onlinemusicplayer.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import vn.edu.usth.onlinemusicplayer.MainActivity;
import vn.edu.usth.onlinemusicplayer.R;

public class ResetPwFragment extends Fragment {
    private TextView SIGNIN;
    private TextView SIGNUP;
    private FrameLayout frameLayout;

    private EditText email;
    private Button reset;
    private TextView responseMessage;

    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_pw, container, false);

        SIGNIN = view.findViewById(R.id.SIGNIN);
        SIGNUP= view.findViewById(R.id.SIGNUP);
        frameLayout = getActivity().findViewById(R.id.register);

        email = view.findViewById(R.id.email);
        reset = view.findViewById(R.id.reset);
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
        SIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
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
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

        mAuth = FirebaseAuth.getInstance();
    }

    private void resetPassword() {
        if (email.getText().toString().matches("[a-zA]-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            mAuth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        responseMessage.setTextColor(getResources().getColor(R.color.main));
                        responseMessage.setText("Please check your Email.");
                    } else {
                        responseMessage.setTextColor(getResources().getColor(R.color.white));
                        responseMessage.setText("Error, please check again.");
                    }
                }
            });
        } else {
            email.setError("Invalid Email, please check again.");
            reset.setEnabled(true);
            reset.setTextColor(getResources().getColor(R.color.main));
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
        fragmentTransaction.setCustomAnimations(R.anim.left, R.anim.left_out);
    }
    private void checkInputs() {
        if (!email.getText().toString().isEmpty()) {
            reset.setEnabled(true);
            reset.setTextColor(getResources().getColor(R.color.main));
            } else {
                reset.setEnabled(false);
                reset.setTextColor(getResources().getColor(R.color.white));
        }
    }
}