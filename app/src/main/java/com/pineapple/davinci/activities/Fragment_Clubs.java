package com.pineapple.davinci.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.pineapple.davinci.R;
import com.pineapple.davinci.clubutils.Club;
import com.pineapple.davinci.clubutils.ClubsDashboard_ImageAdapter;
import com.pineapple.davinci.resources.Constants;
import com.pineapple.davinci.resources.Singleton;
import com.pineapple.davinci.studentutils.Student;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Clubs.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Clubs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Clubs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Club> studentClubs;
    ImageButton settings;

    private OnFragmentInteractionListener mListener;

    public Fragment_Clubs() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Clubs.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Clubs newInstance(String param1, String param2) {
        Fragment_Clubs fragment = new Fragment_Clubs();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { //TODO: no UI init here!!
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clubs, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO: THIS IS ONCREATE FOR FRAGMENTS
        Student student = Singleton.getInstance().getCurrStudent();
        studentClubs = student.getClubList();

        GridView gridview = view.findViewById(R.id.gridview);
        gridview.setAdapter(new ClubsDashboard_ImageAdapter(getActivity(), studentClubs, this.getResources().getDisplayMetrics().density));
        //setGridViewHeightBasedOnChildren(gridview, gridview.getNumColumns());

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        settings = view.findViewById(R.id.imageButton3);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent startIntent = new Intent(getApplicationContext(), Activity_SignOut.class);
                //startActivity(startIntent);
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //mListener.onFragmentInteraction(uri);
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
    public void onResume() {
        super.onResume();
        mListener.updateNavBar(Constants.FRAG_CLUBS);
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
        void updateNavBar(String fragType);
        void selectClub(String clubName);
    }
}
