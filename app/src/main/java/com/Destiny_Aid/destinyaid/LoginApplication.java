package com.Destiny_Aid.destinyaid;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class LoginApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this,"1826258c33342419a13498719d9f8043");
    }
}
