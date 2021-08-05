package iss.workshop.nav01.post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import iss.workshop.nav01.R;
import iss.workshop.nav01.Remote.APIUtils;
import iss.workshop.nav01.Remote.Service.PostService;
import iss.workshop.nav01.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostDetailsActivity extends AppCompatActivity {
    private View head,img;
    private TextView username, date,title,content;
    private PostService postService;
    private List<Post> postList;
    private ArrayList<Post> newPostList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_post_details);

        head = findViewById(R.id.head);
        img = findViewById(R.id.img);
        username = findViewById(R.id.username);
        date = findViewById(R.id.date);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        postService = APIUtils.getPostService();

        Call<List<Post>> call = postService.listPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {

                    postList = response.body();
                    int counter = postList.size();


                    for(Post post:postList){
                        counter--;
                        newPostList.add(post);

                    }


                    username.setText(newPostList.get(id).getUsername());
                    date.setText(newPostList.get(id).getPost_date());
                    title.setText(newPostList.get(id).getTitle());
                    content.setText(newPostList.get(id).getDescription());
                    Picasso.get().load(newPostList.get(id).getImgURL()).into((ImageView) img);

                }


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }

        });


    }
}