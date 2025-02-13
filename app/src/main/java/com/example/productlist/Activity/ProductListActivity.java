package com.example.productlist.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.productlist.Model.ProductList.ProductListResponse;
import com.example.productlist.ProductAdapter;
import com.example.productlist.R;
import com.example.productlist.api.APIClient2;
import com.example.productlist.databinding.ActivityProductListBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {

    ActivityProductListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        callAPI();
    }
    private void callAPI(){
        Call<ProductListResponse> call = APIClient2.getInstance().getAPI().getProductList();
        call.enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                if(response.isSuccessful()){
                    binding.progrssBar.setVisibility(View.GONE);
                    Toast.makeText(ProductListActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    //giving the items
                    ProductAdapter adapter = new ProductAdapter(response.body().getProducts(), ProductListActivity.this);
                    binding.recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(ProductListActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable t) {
                Toast.makeText(ProductListActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}



