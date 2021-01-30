package co.za.drivetrek.daggerpractice.di.main;

import androidx.lifecycle.ViewModel;

import co.za.drivetrek.daggerpractice.di.ViewModelKey;
import co.za.drivetrek.daggerpractice.ui.main.posts.PostsViewModel;
import co.za.drivetrek.daggerpractice.ui.main.profile.ProfileViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostsViewModel(PostsViewModel viewModel);
}
