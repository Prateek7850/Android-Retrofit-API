package com.example.productlist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.productlist.Model.UserModelItem;
import com.example.productlist.api.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar progressBar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
      textView = findViewById(R.id.textView);
      progressBar = findViewById(R.id.progressBar);

        callListApi();
        getDataWithIdApi();
    }
    //Giving here list becasue Json data inside in the array we can check this from
    //User model class set method
    private void callListApi(){
        Call<List<UserModelItem>> call = APIClient.getInstance().getAPI().getUserData();
        call.enqueue(new Callback<List<UserModelItem>>() {
            @Override
            public void onResponse(Call<List<UserModelItem>> call, Response<List<UserModelItem>> response) {
                if(response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Successfully load the data!!", Toast.LENGTH_SHORT).show();
                    List<UserModelItem> userModelItems = response.body(); //data will store here we are getting from api
                    for(int i =0;i<userModelItems.size();i++){
                        textView.append(""+userModelItems.get(i).getId()+"\n");
                    }
                }else{
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this,"Failed loading data",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserModelItem>> call, Throwable t) {

            }
        });
    }
    private void getDataWithIdApi(){
        Call<UserModelItem> call = APIClient.getInstance().getAPI().getDataWithId(1);
        call.enqueue(new Callback<UserModelItem>() {
            @Override
            public void onResponse(Call<UserModelItem> call, Response<UserModelItem> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "SuccessFull", Toast.LENGTH_SHORT).show();
                     textView.append("UserId:" + response.body().getUserId()
                                     +"Id:"+ response.body().getId()
                                     +"Title:"+ response.body().getTitle()
                                     +"Body:"+ response.body().getBody()
                     );
                }else{
                    if(response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserModelItem> call, Throwable t) {

            }
        });
    }
}