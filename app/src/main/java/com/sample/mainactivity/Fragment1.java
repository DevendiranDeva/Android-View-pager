package com.sample.mainactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }

    ListView lv_languages;


    LanguagesListAdapter list_adapter;


    String[] languages = new String[]{"ROHAN RATHORE LYRICS",
            "ROHAN RATHORE LYRICS",
            "ROHAN RATHORE LYRICS",
            "ROHAN RATHORE LYRICS",
            "ROHAN RATHORE LYRICS"


    };


    String[] Hours = new String[]{

            "10 Hours ago ",
            "12 Hours ago ",
            "16 Hours ago ",
            "19 Hours ago ",
            "22 Hours ago "


    };


    String[] Discription = new String[]{

            "Oh, love of mine With a song and a whine You're harsh and divine Like truths and a lie",
            "Oh, love of mine With a song and a whine You're harsh and divine Like truths and a lie",
            "Oh, love of mine With a song and a whine You're harsh and divine Like truths and a lie",
            "Oh, love of mine With a song and a whine You're harsh and divine Like truths and a lie",
            "Oh, love of mine With a song and a whine You're harsh and divine Like truths and a lie"



    };




    String [] language_images = {

             "http://2.bp.blogspot.com/-xmxsZKwq_vo/VMdb4Ubb_nI/AAAAAAAAAFE/hwQDAe-30c0/s1600/ce7864977a84dddb73823b5911cb9c65.jpg",
             "https://assets.audiomack.com/essxaar/tu-hi-tu-qassam-hussain-essxaar-275-275-1484588603.jpg",
             "https://assets.audiomack.com/essxaar/da68b8b9144f0e2efcd6441be1f91c72-275-275.jpeg",
             "https://images-na.ssl-images-amazon.com/images/I/51QcyrXry7L._SS500.jpg",
             "https://images-na.ssl-images-amazon.com/images/I/51h5B-i1zML._SS500.jpg"
     };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);


        lv_languages = (ListView) view.findViewById(R.id.lv_languages);
        list_adapter = new LanguagesListAdapter(getActivity(), languages,language_images,Hours,Discription);
        lv_languages.setAdapter(list_adapter);

        return view;
    }


}