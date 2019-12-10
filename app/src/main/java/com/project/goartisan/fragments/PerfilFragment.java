package com.project.goartisan.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.project.goartisan.R;
import com.project.goartisan.activities.LoginActivity;


public class PerfilFragment extends Fragment {

    private EditText et_correo;
    private EditText et_nombre;
    private EditText et_apellidos;
    private Button btnLogout;




    public PerfilFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v=inflater.inflate(R.layout.fragment_perfil,container,false);
        Button btnLogout=v.findViewById(R.id.btnLogout);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
        return v;

    }

    private void Logout() {
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);
    }


}
