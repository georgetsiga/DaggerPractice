package co.za.drivetrek.daggerpractice.di;

import androidx.lifecycle.ViewModelProvider;

import co.za.drivetrek.daggerpractice.viewmodels.ViewModelProviderFactory;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
