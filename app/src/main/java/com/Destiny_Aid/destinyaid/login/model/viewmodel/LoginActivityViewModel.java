package com.Destiny_Aid.destinyaid.login.model.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kakao.sdk.user.model.User;

import java.util.List;

public class LoginActivityViewModel extends ViewModel {
    private MutableLiveData<String> test;

    private MutableLiveData<List<User>> users;
    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
    }

}
