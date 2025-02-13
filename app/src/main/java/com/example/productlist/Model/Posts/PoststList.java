package com.example.productlist.Model.Posts;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PoststList{

	@SerializedName("PoststList")
	private List<PoststListItem> poststList;

	public void setPoststList(List<PoststListItem> poststList){
		this.poststList = poststList;
	}

	public List<PoststListItem> getPoststList(){
		return poststList;
	}
}