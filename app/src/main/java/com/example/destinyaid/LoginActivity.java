package com.example.destinyaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //로그인 인증있는 Intent
    public void loginBtn(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bungie.net/en/OAuth/Authorize?client_id={client-id}&response_type=code"));
        startActivity(intent);

    }
    //로그인 인증 없는 Intent
    public void NextBtn(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}