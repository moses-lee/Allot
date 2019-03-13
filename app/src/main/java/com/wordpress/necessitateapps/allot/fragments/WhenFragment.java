package com.wordpress.necessitateapps.allot.fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wordpress.necessitateapps.allot.AlarmReceiver;
import com.wordpress.necessitateapps.allot.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WhenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WhenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WhenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static String REMINDER_SUBJECT = "reminder_subject";
    private String subject_text;

    @BindView(R.id.text_reminder)
    TextView textReminder;



    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;



    public WhenFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static WhenFragment newInstance(String subject) {
        WhenFragment fragment = new WhenFragment();

        Bundle args = new Bundle();
        args.putString(REMINDER_SUBJECT, subject);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            subject_text = getArguments().getString(REMINDER_SUBJECT);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_when, container, false);

        ButterKnife.bind(this, view);

        String temp_subject_text = subject_text + '\n' + "When";
        textReminder.setText(temp_subject_text);

       return view;
    }

    @OnClick({ R.id.time_button1, R.id.time_button2, R.id.time_button3, R.id.time_button4, R.id.time_button5, R.id.time_button6 })
    public void onClick(Button button) {
        getNotif();
    }

    /*NOTIFICATIONS*/
    private void getNotif() {

        AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(getActivity(), AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.add(Calendar.HOUR, 7);
        calendar.add(Calendar.MINUTE, 15);
//        calendar.add(Calendar.SECOND, 1);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), broadcast);
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
