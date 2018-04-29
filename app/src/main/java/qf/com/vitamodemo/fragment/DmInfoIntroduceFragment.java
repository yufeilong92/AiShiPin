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
public class DmInfoIntroduceFragment extends Fragment {

    public DmInfoIntroduceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dm_info_introduce, container, false);

        TextView typeName = (TextView) view.findViewById(R.id.info_type);

        ArrayList<String> types = getArguments().getStringArrayList(Config.TYPES);
        if(types!=null && types.size()>0){
            for (String s : getArguments().getStringArrayList(Config.TYPES)) {
                typeName.append(s + "  ");
            }
        }else {
            typeName.setVisibility(View.GONE);
        }
        TextView contentView = (TextView) view.findViewById(R.id.info_introduce);
        contentView.setText(getArguments().getString(Config.INTRODUCE));
        return view;
    }

}
