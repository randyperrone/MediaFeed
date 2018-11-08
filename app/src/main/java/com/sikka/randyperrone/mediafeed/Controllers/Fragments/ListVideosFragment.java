package com.sikka.randyperrone.mediafeed.Controllers.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sikka.randyperrone.mediafeed.Model.DownloadVideoService;
import com.sikka.randyperrone.mediafeed.Model.Video;
import com.sikka.randyperrone.mediafeed.R;
import com.sikka.randyperrone.mediafeed.RecyclerView.YouTubeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListVideosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListVideosFragment extends Fragment {
    private String URL = "https://www.googleapis.com/youtube/v3/playlistItems?playlistId=UU_-I_H2iR4MaAghRSDzVBCQ&maxResults=25&part=snippet%2CcontentDetails&key=";
    private View layoutView;
    private List<Video> listOfVideos;
    private RecyclerView recyclerView;
    private YouTubeRecyclerAdapter mAdapter;
    private DownloadVideoService downloadVideoService;
    private GridLayoutManager gridLayoutManager;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ListVideosFragment() {
        // Required empty public constructor
    }

    public static ListVideosFragment newInstance(String param1, String param2) {
        ListVideosFragment fragment = new ListVideosFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutView = inflater.inflate(R.layout.fragment_list_videos, container, false);
        URL = URL + getString(R.string.key);
        listOfVideos = new ArrayList<>();
        downloadVideoService = new DownloadVideoService(layoutView.getContext());
        recyclerView = (RecyclerView)layoutView.findViewById(R.id.recyclerview_videos);
        mAdapter = new YouTubeRecyclerAdapter(listOfVideos);
        recyclerView.setAdapter(mAdapter);
        gridLayoutManager = new GridLayoutManager(layoutView.getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        loadData();

        return layoutView;
    }

    private void loadData(){
        downloadVideoService.downloadVideos(URL, new DownloadVideoService.VolleyCallBack() {
            @Override
            public void onSuccess(List<Video> videoList) {
                listOfVideos.addAll(videoList);
                final int curSize = mAdapter.getItemCount();
                mAdapter.notifyItemRangeInserted(curSize, listOfVideos.size() - 1);
            }
        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
