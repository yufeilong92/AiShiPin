package qf.com.vitamodemo.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import qf.com.vitamodemo.OnClickListener;
import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.AbsRecyclerAdapter;
import qf.com.vitamodemo.config.Config;

/**
 * create an instance of this fragment.
 */
public class TvListFragment extends Fragment {

    private RecyclerView recyclerView;
    private OnClickListener listener;

    public TvListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof OnClickListener) {
            listener = (OnClickListener) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.tv_list_recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Integer> datas = new ArrayList<>();
        int size = getArguments().getInt(Config.SIZE);
        for (int i = 1; i <= size; i++) {
            datas.add(i);
        }
        AbsRecyclerAdapter adapter = new AbsRecyclerAdapter<Integer>(getActivity(), R
                .layout.item_tv_list, datas) {
            @Override
            public void showData(MyViewHolder vHolder, final Integer data, final int position) {
                Button button = (Button) vHolder.getView(R.id.item_tv_list_btn);
                button.setText(data + "");

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onClick(v, position);
                    }
                });
            }
        };

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        recyclerView.setAdapter(adapter);
    }

    public void setListener(OnClickListener listener){
        this.listener = listener;
    }
}
