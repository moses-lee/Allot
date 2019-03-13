package com.wordpress.necessitateapps.allot.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wordpress.necessitateapps.allot.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WhatFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WhatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WhatFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;


    public WhatFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static WhatFragment newInstance() {
        WhatFragment fragment = new WhatFragment();

//        Bundle args = new Bundle();
//        args.putString(TEXT, text);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_what, container, false);
        ButterKnife.bind(this, view);
       //getButtonTitles();

       return view;
    }

    private void nextFrag(String subject) {
        WhenFragment whenFragment = WhenFragment.newInstance(subject);
        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
        transaction.addToBackStack(null);
        transaction.add(R.id.frame, whenFragment, "WHEN_FRAGMENT").commit();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void sendBack(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @OnClick({ R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6 })
    public void onClick(Button button) {
        nextFrag(button.getText().toString());
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
