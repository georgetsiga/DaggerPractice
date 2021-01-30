package co.za.drivetrek.daggerpractice.di.network.main;

import java.util.List;

import co.za.drivetrek.daggerpractice.models.Post;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {
    //posts?userId=1
    @GET("posts")
    Flowable<List<Post>> getPostsFromUser(
            @Query("userId") int id
    );
}
