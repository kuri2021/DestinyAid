package com.example.destinyaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    TextView tvNickname;
    TextView tvEmail;
    CircleImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvEmail=findViewById(R.id.);


    }

    //로그인 인증있는 Intent
    public void loginBtn(View view) {
    }
    //로그인 인증 없는 Intent
    public void NextBtn(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}