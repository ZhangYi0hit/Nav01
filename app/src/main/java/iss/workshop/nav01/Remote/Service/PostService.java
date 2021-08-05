package iss.workshop.nav01.Remote.Service;

import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import iss.workshop.nav01.model.Post;

public interface PostService {
    @GET("post/list")
    Call<List<Post>> listPosts();
    @Multipart
    @POST("post/create/{userid}")
    Call<Void> create(@Path("userid")Integer userId, @Part("post") RequestBody post);
}
