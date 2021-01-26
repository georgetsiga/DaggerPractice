package co.za.drivetrek.daggerpractice.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import co.za.drivetrek.daggerpractice.R;
import co.za.drivetrek.daggerpractice.viewmodels.ViewModelProviderFactory;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity  extends DaggerAppCompatActivity {
    private static final String TAG = AppCompatActivity.class.getSimpleName();

    private AuthViewModel viewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        viewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);

        setLogo();
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .into((ImageView)findViewById(R.id.login_logo));
    }
}
