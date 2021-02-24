package com.example.destinyaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

import static com.example.destinyaid.G.nickname;
import static com.example.destinyaid.G.profileImageUrl;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




    }

    //로그인 인증있는 Intent
    public void loginBtn(View view) {
        String keyHash= Utility.INSTANCE.getKeyHash(this);
        Log.i("KeyHash",keyHash);
        LoginClient.getInstance().loginWithKakaoAccount(this, new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken !=null){
                    Toast.makeText(LoginActivity.this, "성공", Toast.LENGTH_SHORT).show();
                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {
                            if(user !=null){
                                long id=user.getId();

                                G.nickname=user.getKakaoAccount().getProfile().getNickname();
                                String email=user.getKakaoAccount().getEmail();
                                G.profileImageUrl=user.getKakaoAccount().getProfile().getThumbnailImageUrl();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                intent.putExtra("email",email);
                                Toast.makeText(LoginActivity.this, email, Toast.LENGTH_SHORT).show();
                                startActivity(intent);

                            }else {
                                Toast.makeText(LoginActivity.this, "사용자 정보요청 실패", Toast.LENGTH_SHORT).show();
                            }
                            return null;
                        }
                    });
                }else{
                    Toast.makeText(LoginActivity.this, "실패"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                }
                return null;
            }

        });



    }
    //로그인 인증 없는 Intent
    public void NextBtn(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}