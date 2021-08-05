package iss.workshop.nav01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import iss.workshop.nav01.Remote.APIUtils;
import iss.workshop.nav01.Remote.Service.PostService;
import iss.workshop.nav01.model.Post;
import iss.workshop.nav01.post.PostAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView postlistView;
    int counter;
    private List<Post> postList;
    PostAdapter postAdapter;
    PostService postService;
    private ArrayList<Post> newPostList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


        //navbar
        NavBarFragment navBarFragment = new NavBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nav", "home");
        navBarFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, navBarFragment).commit();



        postlistView = findViewById(R.id.postlist);
        postService = APIUtils.getPostService();


        getpostlist();
    }

    private void getpostlist() {
        Call<List<Post>> call = postService.listPosts();
        call.enqueue(new Callback<List<Post>>(){
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response){
                if (response.isSuccessful()){

                    postList = response.body();

                    int counter = postList.size();


                    for(Post post:postList){
                        counter--;
                        newPostList.add(post);

                    }
                    postAdapter = new PostAdapter(getApplicationContext(), newPostList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

                    postlistView.setLayoutManager(linearLayoutManager);
                    postlistView.setAdapter(postAdapter);


                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}