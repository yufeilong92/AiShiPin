package qf.com.vitamodemo.bean;

/**
 * Created by Administrator on 2015/10/11 0011.
 */
public class OtherTvBean {

    /**
     * title : 冲上云霄
     * works_id : 119398
     * img_url : http://t3.baidu.com/it/u=4153804357,822274411&fm=20
     * url : http://app.video.baidu.com/movieintro/?page=1&id=119398
     * update : 0
     * duration : 0:0
     * rating : 44
     * is_yingyin : 0
     * play_filter : 0
     * nsclick_v : ?pid={pid}&block_type=hot&block_name=2015_all_all_all_all&video_url=http%3A%2F
     * %2Fapp.video.baidu.com%2Fmovieintro%2F%3Fpage%3D1%26id%3D119398&video_name=%E5%86%B2%E4%B8
     * %8A%E4%BA%91%E9%9C%84&to=xq&pn=0_18&pos=videos_&video_type=long_video&works_type=movie
     * &video_id=119398&tpl=long_channel&channel_name=channel_movie&tpl_time=1444564774
     */

    private String title;
    private String works_id;
    private String img_url;
    private String url;
    private String update;
    private String duration;
    private String rating;
    private int is_yingyin;
    private String play_filter;
    private String nsclick_v;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWorks_id(String works_id) {
        this.works_id = works_id;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setIs_yingyin(int is_yingyin) {
        this.is_yingyin = is_yingyin;
    }

    public void setPlay_filter(String play_filter) {
        this.play_filter = play_filter;
    }

    public void setNsclick_v(String nsclick_v) {
        this.nsclick_v = nsclick_v;
    }

    public String getTitle() {
        return title;
    }

    public String getWorks_id() {
        return works_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getUrl() {
        return url;
    }

    public String getUpdate() {
        return update;
    }

    public String getDuration() {
        return duration;
    }

    public String getRating() {
        return rating;
    }

    public int getIs_yingyin() {
        return is_yingyin;
    }

    public String getPlay_filter() {
        return play_filter;
    }

    public String getNsclick_v() {
        return nsclick_v;
    }
}
