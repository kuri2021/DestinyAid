package com.Destiny_Aid.destinyaid;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class LoginApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        KakaoSdk.init(this, String.valueOf(R.string.kakao_app_key));
    }
}
