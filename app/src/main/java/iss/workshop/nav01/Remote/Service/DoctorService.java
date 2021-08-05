package iss.workshop.nav01.Remote.Service;

import java.util.List;

import iss.workshop.nav01.model.Doctor;
import iss.workshop.nav01.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DoctorService {
    @GET("doctor/list")
    Call<List<Doctor>> listDoctors();
}
