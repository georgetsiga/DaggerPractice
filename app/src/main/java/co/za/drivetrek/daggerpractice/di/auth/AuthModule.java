package co.za.drivetrek.daggerpractice.di.auth;

import co.za.drivetrek.daggerpractice.di.network.auth.AuthApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {
    @Provides
    static AuthApi provideAuthAPi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }
}
