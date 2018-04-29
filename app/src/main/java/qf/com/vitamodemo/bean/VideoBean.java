package qf.com.vitamodemo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/11 0011.
 */
public class VideoBean implements Serializable{

    private String id;
    private String title;
    private String trunk;
    private String img_url;
    private String horizontal_poster;
    private String intro;
    private String rating;
    private String duration;
    private String pubtime;
    private String site_type;
    private String play_filter;
    private String bdhd;
    private String default_pos;
    private String foreign_ip;
    private boolean buy_ticket;
    private ArrayList<String> director;
    private ArrayList<String> actor;
    private ArrayList<String> area;
    private ArrayList<String> type;
    private ArrayList<String> tags;
    private ArrayList<SitesEntity> sites;

    private int season_num;

    public int getCur_episode() {
        return cur_episode;
    }

    public void setCur_episode(int cur_episode) {
        this.cur_episode = cur_episode;
    }

    private int cur_episode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrunk() {
        return trunk;
    }

    public void setTrunk(String trunk) {
        this.trunk = trunk;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getHorizontal_poster() {
        return horizontal_poster;
    }

    public void setHorizontal_poster(String horizontal_poster) {
        this.horizontal_poster = horizontal_poster;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public String getSite_type() {
        return site_type;
    }

    public void setSite_type(String site_type) {
        this.site_type = site_type;
    }

    public String getPlay_filter() {
        return play_filter;
    }

    public void setPlay_filter(String play_filter) {
        this.play_filter = play_filter;
    }

    public String getBdhd() {
        return bdhd;
    }

    public void setBdhd(String bdhd) {
        this.bdhd = bdhd;
    }

    public String getDefault_pos() {
        return default_pos;
    }

    public void setDefault_pos(String default_pos) {
        this.default_pos = default_pos;
    }

    public String getForeign_ip() {
        return foreign_ip;
    }

    public void setForeign_ip(String foreign_ip) {
        this.foreign_ip = foreign_ip;
    }

    public boolean getBuy_ticket() {
        return buy_ticket;
    }

    public void setBuy_ticket(boolean buy_ticket) {
        this.buy_ticket = buy_ticket;
    }

    public ArrayList<String> getDirector() {
        return director;
    }

    public void setDirector(ArrayList<String> director) {
        this.director = director;
    }

    public ArrayList<String> getActor() {
        return actor;
    }

    public void setActor(ArrayList<String> actor) {
        this.actor = actor;
    }

    public ArrayList<String> getArea() {
        return area;
    }

    public void setArea(ArrayList<String> area) {
        this.area = area;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<SitesEntity> getSites() {
        return sites;
    }

    public void setSites(ArrayList<SitesEntity> sites) {
        this.sites = sites;
    }

    public int getSeason_num() {
        return season_num;
    }

    public void setSeason_num(int season_num) {
        this.season_num = season_num;
    }

    public static class SitesEntity implements Serializable{
        /**
         * site_name : 爱奇艺
         * site_logo : http://c.hiphotos.baidu
         * .com/video/pic/item/c2cec3fdfc039245fbec49718494a4c27d1e2576.png
         * site_url : http://www.iqiyi.com/v_19rrohm0ag.html?src=frbdaldjunest
         * tvid : 372657300
         * download : 1
         * download_filter : 2
         * value : 0
         * type : movie
         * bcs_url :
         * width : 0
         * height : 0
         * coprctl_play_mode : 0
         * coprctl_full_screen : 0
         */

        private String site_name;
        private String site_logo;
        private String site_url;
        private String tvid;
        private String download;
        private String download_filter;
        private String value;
        private String type;
        private String bcs_url;
        private String width;
        private String height;
        private int coprctl_play_mode;
        private int coprctl_full_screen;

        public String getSite_name() {
            return site_name;
        }

        public void setSite_name(String site_name) {
            this.site_name = site_name;
        }

        public String getSite_logo() {
            return site_logo;
        }

        public void setSite_logo(String site_logo) {
            this.site_logo = site_logo;
        }

        public String getSite_url() {
            return site_url;
        }

        public void setSite_url(String site_url) {
            this.site_url = site_url;
        }

        public String getTvid() {
            return tvid;
        }

        public void setTvid(String tvid) {
            this.tvid = tvid;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getDownload_filter() {
            return download_filter;
        }

        public void setDownload_filter(String download_filter) {
            this.download_filter = download_filter;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBcs_url() {
            return bcs_url;
        }

        public void setBcs_url(String bcs_url) {
            this.bcs_url = bcs_url;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public int getCoprctl_play_mode() {
            return coprctl_play_mode;
        }

        public void setCoprctl_play_mode(int coprctl_play_mode) {
            this.coprctl_play_mode = coprctl_play_mode;
        }

        public int getCoprctl_full_screen() {
            return coprctl_full_screen;
        }

        public void setCoprctl_full_screen(int coprctl_full_screen) {
            this.coprctl_full_screen = coprctl_full_screen;
        }
    }
}
