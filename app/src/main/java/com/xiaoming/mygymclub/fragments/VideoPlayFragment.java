package com.xiaoming.mygymclub.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.dou361.ijkplayer.widget.IRenderView;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.xiaoming.mygymclub.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VideoPlayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VideoPlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoPlayFragment extends BaseBackFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_URL = "url";

    private String mVideoUrl;

    @BindView(R.id.video_view)
    IjkVideoView mVideoView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private OnFragmentInteractionListener mListener;

    public VideoPlayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VideoPlayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoPlayFragment newInstance(String url) {
        VideoPlayFragment fragment = new VideoPlayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mVideoUrl = getArguments().getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video_play, container, false);
        ButterKnife.bind(this, v);

        mVideoView.setAspectRatio(IRenderView.AR_ASPECT_FIT_PARENT);
        mVideoView.setVideoURI(Uri.parse(mVideoUrl));
        mVideoView.start();

        mToolbar.setTitle("Teaching video");
        initToolbarNav(mToolbar);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        mVideoView.release(true);
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
