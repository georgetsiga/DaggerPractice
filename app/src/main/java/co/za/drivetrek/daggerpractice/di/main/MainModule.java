package co.za.drivetrek.daggerpractice.di.main;

import co.za.drivetrek.daggerpractice.di.network.main.MainApi;
import co.za.drivetrek.daggerpractice.ui.main.PostsRecyclerAdapter;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static PostsRecyclerAdapter provideAdapter() {
        return new PostsRecyclerAdapter();
    }

    @Provides
    static MainApi providesMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }
}
