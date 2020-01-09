package com.cocochang.retrofitlesson1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//todos경로로 가서 Fake제이슨 객체를 받아오는 서비스를 해줌
interface  FakeService{
    @GET("/todos/{id}")
    fun getUser(@Path("id")id : Int) : Call<Fake>
}