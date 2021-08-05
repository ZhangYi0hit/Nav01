package iss.workshop.nav01.post;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.File;

import iss.workshop.nav01.MainActivity;
import iss.workshop.nav01.R;
import iss.workshop.nav01.Remote.APIUtils;
import iss.workshop.nav01.Remote.Service.PostService;
import iss.workshop.nav01.model.Post;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newPostActivity extends AppCompatActivity {
    Button btnCancel, btnCreate;
    EditText titleForm, contentForm;
    PostService postService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_post);

        btnCancel = findViewById(R.id.btnCancel);
        btnCreate = findViewById(R.id.btnCreate);

        titleForm = findViewById(R.id.titleForm);
        contentForm = findViewById(R.id.contentForm);

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(newPostActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                Post post = new Post();
                post.setTitle(titleForm.getText().toString());
                post.setDescription(contentForm.getText().toString());


                Gson gson = new Gson();
                String postJson = gson.toJson(post);
                RequestBody postBody = RequestBody.create(MediaType.parse("application/json"), postJson);


                createPost(postBody);
                Intent intent = new Intent(newPostActivity.this, MainActivity.class);
                startActivity(intent);
            }
            });

}

    private void createPost(RequestBody postBody) {
        //your can get userId using Intent from other activity
        int userId=1;
        postService = APIUtils.getPostService();
        Call<Void> call = postService.create(userId,postBody);



        }
    }
