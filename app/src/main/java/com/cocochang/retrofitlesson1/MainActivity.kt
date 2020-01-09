package com.cocochang.retrofitlesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //레트로핏 객체 만듦
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //만든 레트로핏이 서비스 객체 만들어줌
        var service = retrofit.create(FakeService::class.java)

        btn_search.setOnClickListener {
            var inputId : Int = Integer.parseInt(et_input.text.toString())
            service.getUser(inputId)?.enqueue(object :Callback<Fake>{
                override fun onResponse(call: Call<Fake>?, response: Response<Fake>?) {
                    Log.d("dk", response?.code().toString())
                    tv_userId.text = response?.body()?.userId.toString()
                    tv_id.text = response?.body()?.title.toString()
                    tv_title.text = response?.body()?.id.toString()
                    tv_completed.text = response?.body()?.completed.toString()

                }
                override fun onFailure(call: Call<Fake>?, t: Throwable?) {
                }
            })
        }

    }



}
