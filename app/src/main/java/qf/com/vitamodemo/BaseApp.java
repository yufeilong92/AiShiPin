package qf.com.vitamodemo;

        import android.app.Application;
        import android.content.Context;
        import android.graphics.Bitmap;

        import com.android.volley.RequestQueue;
        import com.android.volley.toolbox.Volley;
        import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
        import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
        import com.nostra13.universalimageloader.core.DisplayImageOptions;
        import com.nostra13.universalimageloader.core.ImageLoader;
        import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
        import com.nostra13.universalimageloader.core.assist.ImageScaleType;
        import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
        import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
        import com.nostra13.universalimageloader.utils.StorageUtils;

        import java.io.File;


/**
 * 图片加载 提供网络访问
 * Created by Administrator on 2015/9/11 0011.
 */
public class BaseApp extends Application {

    private static RequestQueue queue;

    //
    public static void initImageLoader(Context context) {

        File cacheDir = StorageUtils.getOwnCacheDirectory(context, context.getPackageName() +
                "/Cache");

        //图片缓存全局设置
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);

        //线程优先级
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        //缓存显示不同大小的同一张图片
        config.denyCacheImageMultipleSizesInMemory();
        //
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        //
        config.memoryCacheSize(2 * 1024 * 1024);
        //
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        //自定义缓存路径
        config.discCache(new UnlimitedDiskCache(cacheDir));
        //
        config.tasksProcessingOrder(QueueProcessingType.LIFO);

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }

    //DisplayImageOptions 具体的图片具体的设置
    public static DisplayImageOptions getDisplayImageOptions(BitmapDisplayer
                                                                     bitmapDisplayer) {
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        //启用内存缓存
        builder.cacheInMemory(true);//设置下载的图片是否缓存在内存中
        builder.cacheOnDisk(true);//设置下载的图片是否缓存在SD卡中

        builder.showImageOnLoading(R.mipmap.defaultbackground);
        builder.showImageForEmptyUri(R.mipmap.defaultbackground);//设置图片Uri为空或是错误的时候显示的图片
        builder.showImageOnFail(R.mipmap.defaultbackground);  //设置图片加载/解码过程中错误时候显示的图片

        builder.considerExifParams(true);  //是否考虑JPEG图像EXIF参数（旋转，翻转）
        builder.bitmapConfig(Bitmap.Config.RGB_565);//设置图片的解码类型
        builder.imageScaleType(ImageScaleType.EXACTLY);//设置图片以如何的编码方式显示

        builder.displayer(bitmapDisplayer);//设置图片显示的方式，圆角或者其他
        return builder.build();
    }

    public static RequestQueue getQueue(Context context) {
        if (queue == null) {
            //网络通信框架——Volley 适用于数据量不大但频繁使用网络的操作
            queue = Volley.newRequestQueue(context);
        }

        return queue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(this);
    }
}
