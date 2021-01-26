package co.za.drivetrek.daggerpractice.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AuthViewModel  extends ViewModel {

    @Inject
    public AuthViewModel() {
        Log.d("AuthViewModel", "AuthViewModel(): viewmodel is working");
    }
}
