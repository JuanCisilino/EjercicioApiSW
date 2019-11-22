package com.xappia.ejercicioapisw.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xappia.ejercicioapisw.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetallePersonaje extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_personaje, container, false);


        return view;
    }

}
