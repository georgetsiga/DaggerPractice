package co.za.drivetrek.daggerpractice;

import co.za.drivetrek.daggerpractice.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
