package co.za.drivetrek.daggerpractice.di;

import co.za.drivetrek.daggerpractice.di.auth.AuthModule;
import co.za.drivetrek.daggerpractice.di.auth.AuthViewModelsModule;
import co.za.drivetrek.daggerpractice.ui.auth.AuthActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();
}
