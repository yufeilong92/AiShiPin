package qf.com.vitamodemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2015/10/11 0011.
 */
public class VideoCategory {

    private String name;
    private String type;
    private String weight;
    private String nsclick_v;
    private List<VideosEntity> videos;
    private List<VideosEntity> hot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNsclick_v() {
        return nsclick_v;
    }

    public void setNsclick_v(String nsclick_v) {
        this.nsclick_v = nsclick_v;
    }

    public List<VideosEntity> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosEntity> videos) {
        this.videos = videos;
    }

    public List<VideosEntity> getHot() {
        return hot;
    }

    public void setHot(List<VideosEntity> hot) {
        this.hot = hot;
    }

    public static class VideosEntity {
        /**
         * works_id : 26824
         * other_works_id :
         * works_type : movie
         * title : 沙漠之花
         * url :
         * rating : 87
         * imgh_url : http://c.hiphotos.baidu
         * .com/video/pic/item/b58f8c5494eef01fe37e9b52e6fe9925bc317d3b.jpg
         * imgv_url : http://t1.baidu.com/it/u=463093337,3833117512&fm=20
         * label :
         * brief : 我一定不会让你觉得痛
         * tag : null
         * metic_img :
         * metic_url :
         * version :
         * corner_mark :
         * is_long_video : 0
         * nsclick_v : ?pid={pid}&id=&channel_name=adnativemovie&block_type=hanguo&block_name
         * =%E5%BD%B1%E8%BF%B7%E9%9B%86%E4%B8%AD%E8%90%A5&works_type=movie&video_type
         * =long_video&video_id=26824&video_name=%E6%B2%99%E6%BC%A0%E4%B9%8B%E8%8A%B1
         * &video_url=&tpl=selected&pos=_slices_0_videos_0
         */

        private String works_id;
        private String other_works_id;
        private String works_type;
        private String title;
        private String url;
        private String rating;
        private String imgh_url;
        private String imgv_url;
        private String label;
        private String brief;
        private String tag;
        private String metic_img;
        private String metic_url;
        private String version;
        private String corner_mark;
        private String is_long_video;
        private String nsclick_v;
        private String update;

        public String getWorks_id() {
            return works_id;
        }

        public void setWorks_id(String works_id) {
            this.works_id = works_id;
        }

        public String getOther_works_id() {
            return other_works_id;
        }

        public void setOther_works_id(String other_works_id) {
            this.other_works_id = other_works_id;
        }

        public String getWorks_type() {
            return works_type;
        }

        public void setWorks_type(String works_type) {
            this.works_type = works_type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getImgh_url() {
            return imgh_url;
        }

        public void setImgh_url(String imgh_url) {
            this.imgh_url = imgh_url;
        }

        public String getImgv_url() {
            return imgv_url;
        }

        public void setImgv_url(String imgv_url) {
            this.imgv_url = imgv_url;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getMetic_img() {
            return metic_img;
        }

        public void setMetic_img(String metic_img) {
            this.metic_img = metic_img;
        }

        public String getMetic_url() {
            return metic_url;
        }

        public void setMetic_url(String metic_url) {
            this.metic_url = metic_url;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getCorner_mark() {
            return corner_mark;
        }

        public void setCorner_mark(String corner_mark) {
            this.corner_mark = corner_mark;
        }

        public String getIs_long_video() {
            return is_long_video;
        }

        public void setIs_long_video(String is_long_video) {
            this.is_long_video = is_long_video;
        }

        public String getNsclick_v() {
            return nsclick_v;
        }

        public void setNsclick_v(String nsclick_v) {
            this.nsclick_v = nsclick_v;
        }

        public String getUpdate() {
            return update;
        }

        public void setUpdate(String update) {
            this.update = update;
        }
    }
}
