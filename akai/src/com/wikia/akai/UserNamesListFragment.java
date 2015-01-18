package com.wikia.akai;

import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class UserNamesListFragment extends Fragment {

    private static final String USERNAME_KEY = "username";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_user_names_list, container, false);
        final TextView userNames = (TextView) layout.findViewById(R.id.usernames);

        final Button button = (Button) layout.findViewById(R.id.load);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                loadUserNamesList(userNames);
            }
        });

        return layout;
    }

    private void loadUserNamesList( final TextView userName ){
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("UsersData");
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    String userNamesList = "";
                    for (ParseObject userDataObject : objects) {
                        userNamesList += userDataObject.get(USERNAME_KEY).toString() + "\n";
                     }
                    userName.setText(userNamesList);
                } else {
                    Log.d("UsersData", "Error: " + e.getMessage());
                }
            }
        });
    }
}