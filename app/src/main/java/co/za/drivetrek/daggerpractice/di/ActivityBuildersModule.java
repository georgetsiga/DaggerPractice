package co.za.drivetrek.daggerpractice.di;

import co.za.drivetrek.daggerpractice.di.auth.AuthModule;
import co.za.drivetrek.daggerpractice.di.auth.AuthScope;
import co.za.drivetrek.daggerpractice.di.auth.AuthViewModelsModule;
import co.za.drivetrek.daggerpractice.di.main.MainFragmentBuildersModule;
import co.za.drivetrek.daggerpractice.di.main.MainModule;
import co.za.drivetrek.daggerpractice.di.main.MainScope;
import co.za.drivetrek.daggerpractice.di.main.MainViewModelsModule;
import co.za.drivetrek.daggerpractice.ui.auth.AuthActivity;
import co.za.drivetrek.daggerpractice.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelsModule.class,
                    MainModule.class
            }
    )
    abstract MainActivity contributeMainActivity();
}
