package qf.com.vitamodemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qf.com.vitamodemo.R;

public abstract class AbsRecyclerAdapter<T> extends RecyclerView.Adapter<AbsRecyclerAdapter
        .MyViewHolder> {

    protected static final int TYPE_HEADER = 0;
    protected static final int TYPE_CONTENT = 1;

    public Context context;
    public List<T> datas;
    public int layoutRes; //item布局资源标识
    public Animation animation;
    public Map<Integer, Boolean> isFrist;
    public LayoutInflater inflater;

    //构造函数1 上下文 item布局资源标识 显示数据
    public AbsRecyclerAdapter(Context context, int layoutRes, List<T> datas) {
        this(context, layoutRes, datas, 0);
    }
   //构造函数2  上下文 item资源布局 数据 动画效果
    public AbsRecyclerAdapter(Context context, int layoutRes, List<T> datas, int anmiationRes) {
        this.context = context;
        this.datas = datas;
        this.layoutRes = layoutRes;

        if (anmiationRes != 0) {
            this.animation = AnimationUtils.loadAnimation(context, anmiationRes);
            isFrist = new HashMap<>();
        }

        inflater = LayoutInflater.from(context);
    }

    //获得条目
    @Override
    public int getItemViewType(int position) {
        if (!hasHeader()) {

            return super.getItemViewType(position);
        }

        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_CONTENT;
        }
    }

    public boolean hasHeader() {
        return false;
    }

    /**
     * 获取总数据个数
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //把数据添加到布局上
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      /*  if (animation != null) {
            // 如果是第一次加载该view，则使用动画
            if (isFrist.get(position) == null || isFrist.get(position)) {
                holder.itemView.startAnimation(animation);
                isFrist.put(position, false);
            }
        }*/
        showData(holder, datas.get(position), position);
    }

    //为每个item生成一个view 布局加载 其中viewholder需要自己写
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(layoutRes, parent, false);
        if (hasHeader()) {
            if (viewType == 0) {
                view = inflater.inflate(R.layout.item_header, parent, false);
            }
        }
        return new MyViewHolder(view);
    }
    //清除数据
    public void clear() {
        datas.clear();

        notifyDataSetChanged();
    }

    public void addAll(List<T> all) {
        datas.addAll(all);
        notifyDataSetChanged();
    }

    public void add(T data) {
        datas.add(data);
        notifyDataSetChanged();
    }

    public void add(int position, T data) {
        datas.add(position, data);
        notifyDataSetChanged();
    }


    public void delete(int position) {
        datas.remove(position);
        notifyDataSetChanged();
    }

    public void delete(T data) {
        datas.remove(data);
        notifyDataSetChanged();
    }

    //不同的页面显示数据不同，所以要做成抽象的
    //T代表任意类型
    public abstract void showData(MyViewHolder vHolder, T data, int position);

    //自定义viewHolder 加载布局
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private Map<Integer, View> views;  //用于封装从item布局中查找的控件
        private View itemView; //item布局对象

        public MyViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            views = new HashMap<>();
        }

        /**
         *
         * @param id map里面下标
         * @return
         */
        public View getView(int id) {
            View view = views.get(id);
            if (view == null) { //第一次查找指定id的控件
                view = itemView.findViewById(id);

                views.put(id, view);
            }
            return view;
        }

        public void setText(int id, String text) {
            TextView textView = (TextView) getView(id);
            textView.setText(text);
        }
    }
}
