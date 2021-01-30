package co.za.drivetrek.daggerpractice.di.main;

import co.za.drivetrek.daggerpractice.ui.main.posts.PostsFragment;
import co.za.drivetrek.daggerpractice.ui.main.profile.ProfileFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();
}
