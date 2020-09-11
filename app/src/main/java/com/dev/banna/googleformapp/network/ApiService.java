package com.dev.banna.googleformapp.network;


import com.dev.banna.googleformapp.network.models.HoursResponse;
import com.dev.banna.googleformapp.network.models.SkillsResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<ResponseBody> submitGoogleFormApiCall(@Field("entry.1824927963") String EmailAddress,
                                               @Field("entry.1877115667") String Name,
                                               @Field("entry.2006916086") String LastName,
                                               @Field("entry.284483984") String LinkToProject
    );

    @GET("/api/skilliq")
    Call<List<SkillsResponse>> getIQSkillsApiCall();

    @GET("/api/hours")
    Call<List<HoursResponse>> getHoursApiCall();


}
