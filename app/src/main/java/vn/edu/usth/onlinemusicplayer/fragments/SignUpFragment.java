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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import vn.edu.usth.onlinemusicplayer.MainActivity;
import vn.edu.usth.onlinemusicplayer.R;


public class SignUpFragment extends Fragment {
    private TextView SIGNIN;
    private FrameLayout frameLayout;

    private EditText userName;
    private EditText email;
    private EditText password;
    private EditText passwordCF;
    private Button signUp;

    private FirebaseAuth mAuth;
    FirebaseFirestore database;

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

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
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
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpWithFirebase();
                signUp.setEnabled(false);
                signUp.setTextColor(getResources().getColor(R.color.white));
            }
        });
    }

    private void signUpWithFirebase() {
        if (email.getText().toString().matches("[a-zA]-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            if (password.getText().toString().equals(passwordCF.getText().toString())) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("userName", userName.getText().toString());
                                    user.put("email", email.getText().toString());
                                    database.collection("users").addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Intent intent = new Intent(getActivity(), MainActivity.class);
                                                    getActivity().startActivity(intent);
                                                    getActivity().finish();
                                                }
                                            })
                                            .document(task.getResult().getUser().getUid())
                                            .set(user)
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                                    signUp.setEnabled(true);
                                                    signUp.setTextColor(getResources().getColor(R.color.main));
                                                }
                                            });

                                } else {
                                    Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    signUp.setEnabled(true);
                                    signUp.setTextColor(getResources().getColor(R.color.main));
                                }
                            }
                        });
            } else {
                passwordCF.setError("Please check again.");
                signUp.setEnabled(true);
                signUp.setTextColor(getResources().getColor(R.color.main));
            }
        } else {
            email.setError("Invalid Email, please check again.");
            signUp.setEnabled(true);
            signUp.setTextColor(getResources().getColor(R.color.main));
        }
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