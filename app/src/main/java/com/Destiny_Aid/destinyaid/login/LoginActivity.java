package com.Destiny_Aid.destinyaid.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Destiny_Aid.destinyaid.G;
import com.Destiny_Aid.destinyaid.main.MainActivity;
import com.Destiny_Aid.destinyaid.R;
import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv;
    Button steamBtn,next;

    ImageView kakaoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iv=findViewById(R.id.pro);
        tv=findViewById(R.id.protv);
        steamBtn=findViewById(R.id.steam);
        kakaoBtn=findViewById(R.id.loginbtn);
        next=findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextBtn();
            }
        });

    }

    //로그인 인증있는 Intent
    public void loginBtn(View view) {
        String keyHash= Utility.INSTANCE.getKeyHash(this);
        Log.d("KeyHash",keyHash);
        LoginClient.getInstance().loginWithKakaoAccount(this, new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken !=null){
                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {
                            if(user !=null){
                                long id=user.getId();
                                G.nickname=user.getKakaoAccount().getProfile().getNickname();
                                String nickname=G.nickname.toString();
                                String email=user.getKakaoAccount().getEmail();
                                G.profileImageUrl=user.getKakaoAccount().getProfile().getThumbnailImageUrl();
                                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("email",email);
                                intent.putExtra("nickname", nickname);
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
    public void NextBtn() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void Bungie(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bungie.net/en/OAuth/Authorize"));
        startActivity(intent);

    }
}