package com.wikia.akai;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserDataFragment extends Fragment {

    private static final String USERNAME_KEY = "username";

    private SharedPreferences mSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());

        View layout = inflater.inflate(R.layout.fragment_user_data, container, false);
        final EditText userName = (EditText) layout.findViewById(R.id.username);
        userName.setText(mSettings.getString(USERNAME_KEY, ""));

        final Button button = (Button) layout.findViewById(R.id.send);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                String userNameString = userName.getText().toString();

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(USERNAME_KEY, userNameString);
                editor.apply();
                
                Toast.makeText(getActivity(), getResources().getString(R.string.username_send, userNameString), 
                        Toast.LENGTH_SHORT).show();
            }
        });
        
        return layout;
    }
}
