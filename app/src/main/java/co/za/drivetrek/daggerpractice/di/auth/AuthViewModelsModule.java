package co.za.drivetrek.daggerpractice.di.auth;

import androidx.lifecycle.ViewModel;

import co.za.drivetrek.daggerpractice.di.ViewModelKey;
import co.za.drivetrek.daggerpractice.ui.auth.AuthViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindViewModel(AuthViewModel viewModel);
}
