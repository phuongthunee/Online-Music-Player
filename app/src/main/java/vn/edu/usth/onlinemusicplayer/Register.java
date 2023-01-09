package vn.edu.usth.onlinemusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import vn.edu.usth.onlinemusicplayer.fragments.SignInFragment;

public class Register extends AppCompatActivity {
    private Button signUp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //back = findViewById(R.id.back);
        //back.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent intent = new Intent(Register.this, MainActivity.class);
                //startActivity(intent);
            //}
        //});
    }
}
