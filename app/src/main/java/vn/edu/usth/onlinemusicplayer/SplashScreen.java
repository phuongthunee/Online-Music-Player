package vn.edu.usth.onlinemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private TextView SIGNIN, SIGNUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SIGNUP = findViewById(R.id.SIGNUP);
        SIGNIN = findViewById(R.id.SIGNIN);

        SIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashScreen.this, Register.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        SIGNIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashScreen.this, Login.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }
}
