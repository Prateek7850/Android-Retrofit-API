package com.example.productlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.productlist.Activity.ProductDetailActivity;
import com.example.productlist.Activity.ProductListActivity;
import com.example.productlist.Model.ProductList.ProductsItem;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.holder> {

    Context context;
    //check which kind of data it is list or json object this-> [] list or this {} object
    List<ProductsItem> productsItemList;



    public ProductAdapter(List<ProductsItem> productsItemList, Context context) {
        this.productsItemList = productsItemList;
        this.context = context;
    }



    @NonNull
    @Override
    public ProductAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //passing layout file like xml
        //adding dependency of showing circular image and glide
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_product_list,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.holder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtName.setText(productsItemList.get(position).getTitle());
        holder.txtDesc.setText(productsItemList.get(position).getDescription());
        Glide.with(context).load(productsItemList.get(position).getThumbnail()).into(holder.profileImage);

        //showing the detail of the products
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              context.startActivity(new Intent(context, ProductDetailActivity.class)
                      //for sending the data
                      .putExtra("img",productsItemList.get(position).getThumbnail())
                      .putExtra("title",productsItemList.get(position).getTitle())
                      .putExtra("desc",productsItemList.get(position).getDescription())
                      .putExtra(    "price",productsItemList.get(position).getPrice().toString())

              );


            }
        });
    }

    @Override
    public int getItemCount() {
        return productsItemList.size();
    }

    public class holder extends RecyclerView.ViewHolder {
      //finding the items created in the cell layout
        TextView txtName, txtDesc;
        CircleImageView profileImage;
        public holder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtDesc = itemView.findViewById(R.id.txt_desc);
            profileImage = itemView.findViewById(R.id.profile_image);
        }
    }
}
