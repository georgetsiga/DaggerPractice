package co.za.drivetrek.daggerpractice.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import co.za.drivetrek.daggerpractice.R;
import co.za.drivetrek.daggerpractice.models.User;
import co.za.drivetrek.daggerpractice.ui.auth.AuthResource;
import co.za.drivetrek.daggerpractice.viewmodels.ViewModelProviderFactory;
import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {
    private static final String TAG = ProfileFragment.class.getSimpleName();
    private ProfileViewModel viewModel;
    private TextView email, username, website, error;
    private LinearLayout errorContainer;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: Profile fragment was created");
        email = view.findViewById(R.id.email);
        username = view.findViewById(R.id.username);
        website = view.findViewById(R.id.website);
        error = view.findViewById(R.id.error);
        errorContainer = view.findViewById(R.id.error_container);
        viewModel = new ViewModelProvider(this, providerFactory).get(ProfileViewModel.class);
        subscribeObservers();
    }

    private void subscribeObservers() {
        viewModel.getAuthenticatedUser().removeObservers(getViewLifecycleOwner());
        viewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case AUTHENTICATED: {
                            setUserDetails(userAuthResource.data);
                            break;
                        }
                        case ERROR: {
                            setErrorDetails(userAuthResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void setErrorDetails(String message) {
        email.setVisibility(View.GONE);
        username.setVisibility(View.GONE);
        website.setVisibility(View.GONE);
        errorContainer.setVisibility(View.VISIBLE);
        error.setText(message);
    }

    private void setUserDetails(User data) {
        errorContainer.setVisibility(View.GONE);
        email.setVisibility(View.VISIBLE);
        username.setVisibility(View.VISIBLE);
        website.setVisibility(View.VISIBLE);

        email.setText(data.getEmail());
        username.setText(data.getUsername());
        website.setText(data.getWebsite());
    }
}
