package com.Destiny_Aid.destinyaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.ByteArrayOutputStream;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

import static com.Destiny_Aid.destinyaid.G.nickname;

public class LoginActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iv=findViewById(R.id.pro);
        tv=findViewById(R.id.protv);




    }

    //로그인 인증있는 Intent
    public void loginBtn(View view) {
        String keyHash= Utility.INSTANCE.getKeyHash(this);
        Log.i("KeyHash",keyHash);
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
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                intent.putExtra("email",email);
                                intent.putExtra("nickname", nickname);
//                                Bitmap bitmap= BitmapFactory.decodeResource(getResources(), Integer.parseInt(G.profileImageUrl));
//                                ByteArrayOutputStream stream=new ByteArrayOutputStream();
//                                bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
//                                byte[] byteArray=stream.toByteArray();
//                                intent.putExtra("image",byteArray);

//                                Glide.with(getApplicationContext()).load(G.profileImageUrl).into(iv);
//                                tv.setText(nickname);

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

//    public void Bungie(View view) {
//        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bungie.net/en/OAuth/Authorize"));
//        startActivity(intent);
//
//    }
}