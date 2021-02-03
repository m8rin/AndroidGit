package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    final String name = "Fragment1";
    private String TAG = "myTag";

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Toast.makeText(getContext(), name +" is attached", Toast.LENGTH_SHORT).show();
        Log.i(TAG,name +" is attached" );
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), name +" is created", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name +" is created");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        Toast.makeText(getContext(), name + " createView", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name + " createView");
        return inflater.inflate(R.layout.fragment1, null);
    }

    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        Toast.makeText(getContext(), name + " createActivity", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name + " createActivity");
    }

    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), name + " is started", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name + " is started");
    }

    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), name + " is resumed", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name + " is resumed");
    }

    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), name + " paused", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name + " paused");
    }

    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), name + " stoped", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name + " stoped");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), name + " destroyView", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name + " destroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), name + " destroied", Toast.LENGTH_SHORT).show();
        Log.i(TAG,name + " destroied" );

    }

    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(), name + "detached", Toast.LENGTH_SHORT).show();
        Log.i(TAG, name + "detached");
    }
}


