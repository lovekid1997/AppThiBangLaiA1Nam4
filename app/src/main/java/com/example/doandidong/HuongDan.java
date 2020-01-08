package com.example.doandidong;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HuongDan extends Fragment {

    VideoView videoView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_huong_dan, container, false);
        // Inflate the layout for this fragment
        videoView = view.findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getContext().getPackageName() + "/" +
                R.raw.videoplayback));
        videoView.start();
        return view;
    }

}
