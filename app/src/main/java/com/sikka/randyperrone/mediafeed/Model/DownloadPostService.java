package com.sikka.randyperrone.mediafeed.Model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.sikka.randyperrone.mediafeed.Model.Consts.API_DATA;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_ID;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_IMAGES;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_LINK;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_THUMBNAIL;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_THUMBNAILS;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_URL;

public class DownloadPostService {
    private final String TAG = "DownloadPostService";
    private RequestQueue requestQueue;
    private List<Post> listOfPost;

    public DownloadPostService(Context context) {
        this.listOfPost = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(context);
    }

    public void downloadPosts(String url, final VolleyCallBack callBack){
        final JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response != null){
                    try{
                        JSONArray datas = response.getJSONArray(API_DATA);
                        if(datas != null){
                            for(int i = 0; i < datas.length(); i++){
                                String url = "";
                                String id = "";
                                String link = "";
                                JSONObject data = datas.getJSONObject(i);
                                id = data.getString(API_ID);
                                link = data.getString(API_LINK);
                                JSONObject images = data.getJSONObject(API_IMAGES);
                                JSONObject thumbnail = images.getJSONObject(API_THUMBNAIL);
                                url = thumbnail.getString(API_URL);
                                if(url != null && id != null && link != null){
                                    Post post = new Post(link, id, url);
                                    listOfPost.add(post);
                                }
                            }
                        }
                    }catch (Exception e){
                        Log.e(TAG, e.toString());
                    }
                }
                callBack.onSuccessCallback(listOfPost);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        });
        requestQueue.add(objectRequest);
    }

    public interface VolleyCallBack{
        void onSuccessCallback(List<Post> postList);
    }
}
