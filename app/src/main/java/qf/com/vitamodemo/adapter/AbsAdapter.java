package qf.com.vitamodemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 普通adapter的基类
 * @param <T>
 */
public abstract class AbsAdapter<T> extends BaseAdapter {

    public Context context;
    public List<T> datas;
    public int layoutRes; //item布局资源标识
    public Animation animation;
    private Map<Integer, Boolean> isFrist;
    //构造器
    public AbsAdapter(Context context, int layoutRes, List<T> datas) {
        this(context, layoutRes, datas, 0);
    }
    //有动画效果的构造器
        public AbsAdapter(Context context, int layoutRes, List<T> datas, int anmiationRes) {
        this.context = context;
        this.datas = datas;
        this.layoutRes = layoutRes;

        //0的话就不加载动画
        if (anmiationRes != 0) {
            this.animation = AnimationUtils.loadAnimation(context, anmiationRes);
            isFrist = new HashMap<>();
        }
    }

    //显示的数目
    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    //获得某一条目
    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //获得该条目的视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
            vHolder = new ViewHolder(convertView);
            convertView.setTag(vHolder);

        } else {
            vHolder = (ViewHolder) convertView.getTag();
        }

        if (animation != null) {
            // 如果是第一次加载该view，则使用动画
            if (isFrist.get(position) == null || isFrist.get(position)) {
                convertView.startAnimation(animation);
                isFrist.put(position, false);
            }
        }

        //显示数据
        showData(vHolder, datas.get(position), position);
        return convertView;
    }

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

    public void delete(int position){
        datas.remove(position);
        notifyDataSetChanged();
    }

    public void delete(T data){
        datas.remove(data);
        notifyDataSetChanged();
    }

        public abstract void showData(ViewHolder vHolder, T data, int position);

        public class ViewHolder {
            private Map<Integer, View> views;  //用于封装从item布局中查找的控件
            private View itemView; //item布局对象

            public ViewHolder(View itemView) {
                this.itemView = itemView;
                views = new HashMap<>();
            }

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
