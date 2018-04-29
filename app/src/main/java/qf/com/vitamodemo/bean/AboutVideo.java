package qf.com.vitamodemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/10/13 0013.
 */
public class AboutVideo implements Serializable {

    private List<SimilaryEntity> similary;
    private List<DirectorEntity> director;
    private List<ActorEntity> actor;

    public void setSimilary(List<SimilaryEntity> similary) {
        this.similary = similary;
    }

    public void setDirector(List<DirectorEntity> director) {
        this.director = director;
    }

    public void setActor(List<ActorEntity> actor) {
        this.actor = actor;
    }

    public List<SimilaryEntity> getSimilary() {
        return similary;
    }

    public List<DirectorEntity> getDirector() {
        return director;
    }

    public List<ActorEntity> getActor() {
        return actor;
    }

    public static class SimilaryEntity {
        /**
         * title : 特工艾米拉国语
         * net_show_time : 2014
         * works_id : 116524
         * rating : 60
         * vertical_img_url : http://d.hiphotos.baidu
         * .com/video/pic/item/9d82d158ccbf6c8103b63c26be3eb13532fa407e.jpg
         * big_poster : http://d.hiphotos.baidu
         * .com/video/pic/item/9d82d158ccbf6c8103b63c26be3eb13532fa407e.jpg
         * oneword :
         */

        private String title;
        private String net_show_time;
        private String works_id;
        private String rating;
        private String vertical_img_url;
        private String big_poster;
        private String oneword;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setNet_show_time(String net_show_time) {
            this.net_show_time = net_show_time;
        }

        public void setWorks_id(String works_id) {
            this.works_id = works_id;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public void setVertical_img_url(String vertical_img_url) {
            this.vertical_img_url = vertical_img_url;
        }

        public void setBig_poster(String big_poster) {
            this.big_poster = big_poster;
        }

        public void setOneword(String oneword) {
            this.oneword = oneword;
        }

        public String getTitle() {
            return title;
        }

        public String getNet_show_time() {
            return net_show_time;
        }

        public String getWorks_id() {
            return works_id;
        }

        public String getRating() {
            return rating;
        }

        public String getVertical_img_url() {
            return vertical_img_url;
        }

        public String getBig_poster() {
            return big_poster;
        }

        public String getOneword() {
            return oneword;
        }
    }

    public static class DirectorEntity {
        /**
         * title : 百万富翁的初恋
         * net_show_time : 2006
         * works_id : 23074
         * rating : 66
         * vertical_img_url : http://t2.baidu.com/it/u=1829746464,4285416562&fm=20
         * big_poster : http://t3.baidu.com/it/u=1070020094,1351028136&fm=20
         * oneword :
         */

        private String title;
        private String net_show_time;
        private String works_id;
        private String rating;
        private String vertical_img_url;
        private String big_poster;
        private String oneword;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setNet_show_time(String net_show_time) {
            this.net_show_time = net_show_time;
        }

        public void setWorks_id(String works_id) {
            this.works_id = works_id;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public void setVertical_img_url(String vertical_img_url) {
            this.vertical_img_url = vertical_img_url;
        }

        public void setBig_poster(String big_poster) {
            this.big_poster = big_poster;
        }

        public void setOneword(String oneword) {
            this.oneword = oneword;
        }

        public String getTitle() {
            return title;
        }

        public String getNet_show_time() {
            return net_show_time;
        }

        public String getWorks_id() {
            return works_id;
        }

        public String getRating() {
            return rating;
        }

        public String getVertical_img_url() {
            return vertical_img_url;
        }

        public String getBig_poster() {
            return big_poster;
        }

        public String getOneword() {
            return oneword;
        }
    }

    public static class ActorEntity {
        /**
         * title : 委托人
         * net_show_time : 2011
         * works_id : 30960
         * rating : 71
         * vertical_img_url : http://t3.baidu.com/it/u=1465710398,576583869&fm=20
         * big_poster : http://t3.baidu.com/it/u=1319464860,1986471956&fm=20
         * oneword :
         */

        private String title;
        private String net_show_time;
        private String works_id;
        private String rating;
        private String vertical_img_url;
        private String big_poster;
        private String oneword;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setNet_show_time(String net_show_time) {
            this.net_show_time = net_show_time;
        }

        public void setWorks_id(String works_id) {
            this.works_id = works_id;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public void setVertical_img_url(String vertical_img_url) {
            this.vertical_img_url = vertical_img_url;
        }

        public void setBig_poster(String big_poster) {
            this.big_poster = big_poster;
        }

        public void setOneword(String oneword) {
            this.oneword = oneword;
        }

        public String getTitle() {
            return title;
        }

        public String getNet_show_time() {
            return net_show_time;
        }

        public String getWorks_id() {
            return works_id;
        }

        public String getRating() {
            return rating;
        }

        public String getVertical_img_url() {
            return vertical_img_url;
        }

        public String getBig_poster() {
            return big_poster;
        }

        public String getOneword() {
            return oneword;
        }
    }
}
