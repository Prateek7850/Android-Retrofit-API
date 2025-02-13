package com.example.productlist.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.productlist.R;
import com.example.productlist.databinding.ActivityProductDetailBinding;
import com.example.productlist.databinding.ActivityProductListBinding;

public class ProductDetailActivity extends AppCompatActivity {

    ActivityProductDetailBinding binding;
    String title,desc,price,image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
          binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());

          //checking are we getting proper data from product list or not
        if(getIntent()!=null){
            image=getIntent().getStringExtra("img");
            desc=getIntent().getStringExtra("desc");
            price=getIntent().getStringExtra("price");
            title=getIntent().getStringExtra("title");
            //setting data into view
            Glide.with(this).load(image).into(binding.profileImage);
            binding.txtName.setText(title);
            binding.txtPrice.setText(price);
            binding.txtDescription.setText(desc);
        }else{
            Toast.makeText(this,"Not getting data",Toast.LENGTH_SHORT).show();
        }
    }

}