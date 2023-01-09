package vn.edu.usth.onlinemusicplayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

import vn.edu.usth.onlinemusicplayer.fragments.ResetPwFragment;

public class Login extends AppCompatActivity {
    private TextView SIGNUP;
    private TextView resetPassword;
    private FrameLayout frameLayout;

    private EditText email;
    private EditText password;
    private Button signIn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

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
        signIn = view.findViewById(R.id.reset);

        mAuth = FirebaseAuth.getInstance();
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        SIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
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

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithFirebase();
                signIn.setEnabled(false);
                signIn.setTextColor(getResources().getColor(R.color.white));
            }
        });
    }

    private void signInWithFirebase() {
        if (email.getText().toString().matches("[a-zA]-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                getActivity().startActivity(intent);
                                getActivity().finish();
                            } else {
                                Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                signIn.setEnabled(true);
                                signIn.setTextColor(getResources().getColor(R.color.main));
                            }
                        }
                    });
        } else {
            email.setError("Invalid Email, please check again.");
            signIn.setEnabled(true);
            signIn.setTextColor(getResources().getColor(R.color.main));
        }
    }

    private void checkInputs() {
        if (!email.getText().toString().isEmpty()) {
            if (!password.getText().toString().isEmpty()) {
                signIn.setEnabled(true);
                signIn.setTextColor(getResources().getColor(R.color.main));
            } else {
                signIn.setEnabled(false);
                signIn.setTextColor(getResources().getColor(R.color.white));
            }
        } else {
            signIn.setEnabled(false);
            signIn.setTextColor(getResources().getColor(R.color.white));
        }
    }

    public Activity getActivity() {
        return activity;
    }
}