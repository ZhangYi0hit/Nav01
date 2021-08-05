package iss.workshop.nav01;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import iss.workshop.nav01.doctor.DoctorActivity;
import iss.workshop.nav01.post.PostDetailsActivity;
import iss.workshop.nav01.post.newPostActivity;


public class NavBarFragment extends Fragment {
    private TextView textView;
    ImageView home,location,doctors,list,add;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_navbar,container,false);

        home=view.findViewById(R.id.home);
        doctors=view.findViewById(R.id.doctor);
        add=view.findViewById(R.id.newpost);





        String nav = getArguments().getString("nav");
        //switch here
        switch (nav){
            case "home": home.setImageResource(R.drawable.ic_med_home_active);break;
            case "doctor": doctors.setImageResource(R.drawable.ic_med_people_active);break;

        }
        home.setOnClickListener((View v)-> {
            home.setImageResource(R.drawable.ic_med_home_active);
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
        doctors.setOnClickListener((View v)-> {
            doctors.setImageResource(R.drawable.ic_med_people_active);
            Intent intent = new Intent(getActivity(), DoctorActivity.class);
            startActivity(intent);
        });
        add.setOnClickListener((View v)-> {
            //home.setImageResource(R.drawable.ic_med_people_active);
            Intent intent = new Intent(getActivity(), newPostActivity.class);
            startActivity(intent);
        });








        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



}