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

import static com.sikka.randyperrone.mediafeed.Model.Consts.API_DESCRIPTION;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_ID;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_ITEMS;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_MEDIUM;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_RESOURCEID;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_SNIPPET;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_THUMBNAILS;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_TITLE;
import static com.sikka.randyperrone.mediafeed.Model.Consts.API_URL;

public class DownloadVideoService {
    private final String TAG = "DownloadVideoService";
    private RequestQueue requestQueue;
    private List<Video> listOfVideos;

    public DownloadVideoService(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        listOfVideos = new ArrayList<>();
    }

    public void downloadVideos(String url, final VolleyCallBack callBack){
        final JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "Volley Success");
                if(response != null){
                    try{
                        JSONArray items = response.getJSONArray(API_ITEMS);
                        if(items != null){
                            for(int i = 0; i < items.length(); i++){
                                JSONObject item = items.getJSONObject(i);
                                String id = "";
                                String title = "";
                                String description = "";
                                String url = "";
                                if(item != null){
                                    JSONObject snippet = item.getJSONObject(API_SNIPPET);
                                    title = snippet.getString(API_TITLE);
                                    description = snippet.getString(API_DESCRIPTION);
                                    JSONObject thumbnails = snippet.getJSONObject(API_THUMBNAILS);
                                    JSONObject medium = thumbnails.getJSONObject(API_MEDIUM);
                                    JSONObject resourceId = snippet.getJSONObject(API_RESOURCEID);
                                    id = resourceId.getString(API_ID);
                                    url = medium.getString(API_URL);
                                }
                                if(id != null && title != null && description != null && url != null){
                                    Video video = new Video(id, description, url, title);
                                    listOfVideos.add(video);
                                }
                            }
                        }
                    }catch (Exception e){
                        Log.e(TAG, e.toString());
                    }
                }
                callBack.onSuccess(listOfVideos);
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
        void onSuccess(List<Video> videoList);
    }
}
