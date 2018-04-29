package qf.com.vitamodemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/10/13 0013.
 */
public class AboutTv implements Serializable {

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

        private String title;
        private String works_id;
        private String rating;
        private String poster;
        private String big_poster;
        private int season_num;
        private String season;
        private String max_episode;
        private String oneword;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setWorks_id(String works_id) {
            this.works_id = works_id;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public void setBig_poster(String big_poster) {
            this.big_poster = big_poster;
        }

        public void setSeason_num(int season_num) {
            this.season_num = season_num;
        }

        public void setSeason(String season) {
            this.season = season;
        }

        public void setMax_episode(String max_episode) {
            this.max_episode = max_episode;
        }

        public void setOneword(String oneword) {
            this.oneword = oneword;
        }

        public String getTitle() {
            return title;
        }

        public String getWorks_id() {
            return works_id;
        }

        public String getRating() {
            return rating;
        }

        public String getPoster() {
            return poster;
        }

        public String getBig_poster() {
            return big_poster;
        }

        public int getSeason_num() {
            return season_num;
        }

        public String getSeason() {
            return season;
        }

        public String getMax_episode() {
            return max_episode;
        }

        public String getOneword() {
            return oneword;
        }
    }

    public static class DirectorEntity {
        /**
         * title : 精武门国语
         * works_id : 10856
         * rating : 80
         * poster : http://t2.baidu.com/it/u=1401158133,1005839263&fm=20
         * big_poster : http://t2.baidu.com/it/u=1987917226,3538372542&fm=20
         * season_num : 0
         * season : 0
         * max_episode : 0
         * oneword :
         */

        private String title;
        private String works_id;
        private String rating;
        private String poster;
        private String big_poster;
        private int season_num;
        private String season;
        private String max_episode;
        private String oneword;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setWorks_id(String works_id) {
            this.works_id = works_id;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public void setBig_poster(String big_poster) {
            this.big_poster = big_poster;
        }

        public void setSeason_num(int season_num) {
            this.season_num = season_num;
        }

        public void setSeason(String season) {
            this.season = season;
        }

        public void setMax_episode(String max_episode) {
            this.max_episode = max_episode;
        }

        public void setOneword(String oneword) {
            this.oneword = oneword;
        }

        public String getTitle() {
            return title;
        }

        public String getWorks_id() {
            return works_id;
        }

        public String getRating() {
            return rating;
        }

        public String getPoster() {
            return poster;
        }

        public String getBig_poster() {
            return big_poster;
        }

        public int getSeason_num() {
            return season_num;
        }

        public String getSeason() {
            return season;
        }

        public String getMax_episode() {
            return max_episode;
        }

        public String getOneword() {
            return oneword;
        }
    }

    public static class ActorEntity {
        /**
         * title : 仙剑奇侠传国语
         * works_id : 11425
         * rating : 72
         * poster : http://t2.baidu.com/it/u=295295143,3877348854&fm=20
         * big_poster : http://t3.baidu.com/it/u=740311957,4167325756&fm=20
         * season_num : 1
         * season : 3
         * max_episode : 3
         * oneword :
         */

        private String title;
        private String works_id;
        private String rating;
        private String poster;
        private String big_poster;
        private int season_num;
        private String season;
        private String max_episode;
        private String oneword;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setWorks_id(String works_id) {
            this.works_id = works_id;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public void setBig_poster(String big_poster) {
            this.big_poster = big_poster;
        }

        public void setSeason_num(int season_num) {
            this.season_num = season_num;
        }

        public void setSeason(String season) {
            this.season = season;
        }

        public void setMax_episode(String max_episode) {
            this.max_episode = max_episode;
        }

        public void setOneword(String oneword) {
            this.oneword = oneword;
        }

        public String getTitle() {
            return title;
        }

        public String getWorks_id() {
            return works_id;
        }

        public String getRating() {
            return rating;
        }

        public String getPoster() {
            return poster;
        }

        public String getBig_poster() {
            return big_poster;
        }

        public int getSeason_num() {
            return season_num;
        }

        public String getSeason() {
            return season;
        }

        public String getMax_episode() {
            return max_episode;
        }

        public String getOneword() {
            return oneword;
        }
    }
}
