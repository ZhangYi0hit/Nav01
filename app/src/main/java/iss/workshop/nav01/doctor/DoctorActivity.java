package iss.workshop.nav01.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Adapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import iss.workshop.nav01.NavBarFragment;
import iss.workshop.nav01.R;
import iss.workshop.nav01.Remote.APIUtils;
import iss.workshop.nav01.Remote.Service.DoctorService;
import iss.workshop.nav01.model.Doctor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private List<Doctor> doctorList;
    EditText searchDoctor;
    DoctorService doctorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_doctor);

        NavBarFragment navBarFragment = new NavBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nav", "doctor");
        navBarFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, navBarFragment).commit();


        doctorService = APIUtils.getDoctorsService();
        recyclerView = (RecyclerView) findViewById(R.id.doctorRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        doctorList=new ArrayList<>();
        getDoctorList();

    }

    private void getDoctorList() {
        Call<List<Doctor>> call = doctorService.listDoctors();
        call.enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                if (response.isSuccessful()) {
                    doctorList = response.body();
                    adapter=new DoctorAdapter(getApplicationContext(),doctorList);
                    recyclerView.setAdapter(adapter);




                }
            }

            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}