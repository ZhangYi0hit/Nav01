package iss.workshop.nav01.post;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import iss.workshop.nav01.R;
import iss.workshop.nav01.Remote.Service.PostService;
import iss.workshop.nav01.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Viewholder>{


    private ArrayList<Post> postModelList;
    private PostService postService;
    private Context context;
    String url="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fjkcdn.pajk.com.cn%2Fimage%2FT19SDcBjLT1RyfOV6K.gif%3Fimg%3D%2Ftf%2Cd_jpg%2Cq_70%2Frs%2Cw_500&refer=http%3A%2F%2Fjkcdn.pajk.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628738373&t=789f0afcb29ab7d3842f4fe6e664d1f4";

    public PostAdapter(Context context,ArrayList<Post> postModelList) {
        this.postModelList = postModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list, parent, false);
    return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.Viewholder holder, int position) {
        Post model = postModelList.get(position);

        holder.username.setText(""+model.getUsername());
        holder.date.setText("" + model.getPost_date());
        holder.title.setText("" + model.getTitle());
        holder.content.setText("" + model.getDescription());

        Picasso.get().load(model.getImgURL()).into((ImageView) holder.img);


        holder.content.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(),PostDetailsActivity.class);
                intent.putExtra("id",model.getId());
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder {
        private View head,img;
       private TextView username, date,title,content;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.head);
            img = itemView.findViewById(R.id.img);
            username = itemView.findViewById(R.id.username);
            date = itemView.findViewById(R.id.date);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);


        }
    }
}
