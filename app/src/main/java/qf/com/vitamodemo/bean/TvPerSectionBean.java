package qf.com.vitamodemo.bean;

import java.util.List;

/**
 * 动漫每一季的bean
 * Created by Administrator on 2015/10/15 0015.
 */
public class TvPerSectionBean {

    private String id;
    private String site;
    private int total_num;
    private List<SitesEntity> sites;
    private List<DsitesEntity> dsites;
    private List<String> years;
    private List<VideosEntity> videos;

    public void setId(String id) {
        this.id = id;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public void setSites(List<SitesEntity> sites) {
        this.sites = sites;
    }

    public void setDsites(List<DsitesEntity> dsites) {
        this.dsites = dsites;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    public void setVideos(List<VideosEntity> videos) {
        this.videos = videos;
    }

    public String getId() {
        return id;
    }

    public String getSite() {
        return site;
    }

    public int getTotal_num() {
        return total_num;
    }

    public List<SitesEntity> getSites() {
        return sites;
    }

    public List<DsitesEntity> getDsites() {
        return dsites;
    }

    public List<String> getYears() {
        return years;
    }

    public List<VideosEntity> getVideos() {
        return videos;
    }

    public static class SitesEntity {
        /**
         * site_name : PPTV
         * site_url : pptv.com
         * site_no : 1
         * site_logo : http://g.hiphotos.baidu
         * .com/video/pic/item/e850352ac65c103892aa66bcb1119313b17e89fc.png
         * max_episode : 40
         * download_filter : 0
         * value : 0
         * type : tvplay
         * width : 0
         * height : 0
         */

        private String site_name;
        private String site_url;
        private int site_no;
        private String site_logo;
        private int max_episode;
        private String download_filter;
        private String value;
        private String type;
        private String width;
        private String height;

        public void setSite_name(String site_name) {
            this.site_name = site_name;
        }

        public void setSite_url(String site_url) {
            this.site_url = site_url;
        }

        public void setSite_no(int site_no) {
            this.site_no = site_no;
        }

        public void setSite_logo(String site_logo) {
            this.site_logo = site_logo;
        }

        public void setMax_episode(int max_episode) {
            this.max_episode = max_episode;
        }

        public void setDownload_filter(String download_filter) {
            this.download_filter = download_filter;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getSite_name() {
            return site_name;
        }

        public String getSite_url() {
            return site_url;
        }

        public int getSite_no() {
            return site_no;
        }

        public String getSite_logo() {
            return site_logo;
        }

        public int getMax_episode() {
            return max_episode;
        }

        public String getDownload_filter() {
            return download_filter;
        }

        public String getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public String getWidth() {
            return width;
        }

        public String getHeight() {
            return height;
        }
    }

    public static class DsitesEntity {
        /**
         * site_name : PPTV
         * site_url : pptv.com
         * site_no : 1
         * site_logo : http://g.hiphotos.baidu
         * .com/video/pic/item/e850352ac65c103892aa66bcb1119313b17e89fc.png
         * max_episode : 40
         * download_filter : 0
         * value : 0
         * type : tvplay
         * width : 0
         * height : 0
         */

        private String site_name;
        private String site_url;
        private int site_no;
        private String site_logo;
        private int max_episode;
        private String download_filter;
        private String value;
        private String type;
        private String width;
        private String height;

        public void setSite_name(String site_name) {
            this.site_name = site_name;
        }

        public void setSite_url(String site_url) {
            this.site_url = site_url;
        }

        public void setSite_no(int site_no) {
            this.site_no = site_no;
        }

        public void setSite_logo(String site_logo) {
            this.site_logo = site_logo;
        }

        public void setMax_episode(int max_episode) {
            this.max_episode = max_episode;
        }

        public void setDownload_filter(String download_filter) {
            this.download_filter = download_filter;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getSite_name() {
            return site_name;
        }

        public String getSite_url() {
            return site_url;
        }

        public int getSite_no() {
            return site_no;
        }

        public String getSite_logo() {
            return site_logo;
        }

        public int getMax_episode() {
            return max_episode;
        }

        public String getDownload_filter() {
            return download_filter;
        }

        public String getValue() {
            return value;
        }

        public String getType() {
            return type;
        }

        public String getWidth() {
            return width;
        }

        public String getHeight() {
            return height;
        }
    }

    //每一集的对象
    public static class VideosEntity {
        /**
         * title : 美人心计
         * url : http://v.pptv.com/show/J8aVE3vhUYicKRq4.html
         * isper : 0
         * is_play : 1
         * episode : 1
         * img_url : http://t2.baidu.com/it/u=1911239363,3541093466&fm=20
         * tvid : 0
         * download : 1
         * value : 0
         * sec : 7144
         * di : faa1308dc003ab9e
         * coprctl_play_mode : 1
         * coprctl_full_screen : 0
         */

        private String title;
        private String url;
        private int isper;
        private String is_play;
        private String episode;
        private String img_url;
        private String tvid;
        private String download;
        private String value;
        private int sec;
        private String di;
        private int coprctl_play_mode;
        private int coprctl_full_screen;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setIsper(int isper) {
            this.isper = isper;
        }

        public void setIs_play(String is_play) {
            this.is_play = is_play;
        }

        public void setEpisode(String episode) {
            this.episode = episode;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public void setTvid(String tvid) {
            this.tvid = tvid;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setSec(int sec) {
            this.sec = sec;
        }

        public void setDi(String di) {
            this.di = di;
        }

        public void setCoprctl_play_mode(int coprctl_play_mode) {
            this.coprctl_play_mode = coprctl_play_mode;
        }

        public void setCoprctl_full_screen(int coprctl_full_screen) {
            this.coprctl_full_screen = coprctl_full_screen;
        }

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        public int getIsper() {
            return isper;
        }

        public String getIs_play() {
            return is_play;
        }

        public String getEpisode() {
            return episode;
        }

        public String getImg_url() {
            return img_url;
        }

        public String getTvid() {
            return tvid;
        }

        public String getDownload() {
            return download;
        }

        public String getValue() {
            return value;
        }

        public int getSec() {
            return sec;
        }

        public String getDi() {
            return di;
        }

        public int getCoprctl_play_mode() {
            return coprctl_play_mode;
        }

        public int getCoprctl_full_screen() {
            return coprctl_full_screen;
        }
    }
}
