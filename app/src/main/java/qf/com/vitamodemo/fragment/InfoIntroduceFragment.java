package qf.com.vitamodemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import qf.com.vitamodemo.R;
import qf.com.vitamodemo.config.Config;

/**
 */
public class InfoIntroduceFragment extends Fragment {

    public InfoIntroduceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_introduce, container, false);

        TextView directorName = (TextView) view.findViewById(R.id.info_director);
        TextView actors = (TextView) view.findViewById(R.id.info_actor_below);
        TextView typeName = (TextView) view.findViewById(R.id.info_type);
        ArrayList<String> director = getArguments().getStringArrayList(Config.DIRECTOR);
        if (director != null && director.size() > 0) {
            for (String s : director) {
                directorName.append(s + "  ");
            }
        } else {
            directorName.setVisibility(View.GONE);
        }

        ArrayList<String> actor = getArguments().getStringArrayList(Config.ACTORS);
        if (actor != null && actor.size() > 0) {
            for (String s : actor) {
                actors.append(s + "  ");
            }
        } else {
            actors.setVisibility(View.GONE);
        }

        ArrayList<String> types = getArguments().getStringArrayList(Config.TYPES);
        if (types != null) {
            for (String s : types) {
                typeName.append(s + "  ");
            }
        } else {
            typeName.setVisibility(View.GONE);
        }

        TextView contentView = (TextView) view.findViewById(R.id.info_introduce);
        contentView.setText(getArguments().getString(Config.INTRODUCE));
        return view;
    }
}
