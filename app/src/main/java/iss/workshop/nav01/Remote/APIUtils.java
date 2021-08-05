package iss.workshop.nav01.Remote;


import iss.workshop.nav01.Remote.Service.DoctorService;
import iss.workshop.nav01.Remote.Service.PostService;

public class APIUtils {

    private APIUtils(){}

    //192.168.0.140  is your local host
    public static final String API_URL = "http://192.168.0.140:1234/api/";



    public static PostService getPostService(){
        return iss.workshop.nav01.Remote.RetrofitClient.getClient(API_URL).create(PostService.class);
    }


    public static DoctorService getDoctorsService(){
        return iss.workshop.nav01.Remote.RetrofitClient.getClient(API_URL).create(DoctorService.class);
    }

}