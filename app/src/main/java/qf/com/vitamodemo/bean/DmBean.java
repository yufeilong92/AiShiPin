package qf.com.vitamodemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/15 0015.
 */
public class DmBean {

    /**
     * id : 7513
     * title : 海绵宝宝国语
     * trunk : 海绵宝宝
     * img_url : http://c.hiphotos.baidu
     * .com/video/pic/item/4ec2d5628535e5ddf4cee34874c6a7efcf1b6242.jpg
     * horizontal_poster :
     * intro : 《海绵宝宝》（SpongeBob
     * SquarePants）是美国著名的系列电视动画，1999年在尼克国际儿童频道开播，至今仍持续制播中，创始者是史蒂芬·海伦伯格（Stephen
     * Hillenburg）。动画场景设定于太平洋海底，一座称为比奇堡（Bikini
     * Bottom）的城市，故事围绕主角海绵宝宝和他的好朋友们展开。由于剧情幽默，寓教于乐且充满想象力，受到许多儿童及成年观众喜爱，并被翻译成多国语言版本，成为风靡世界的作品。伴随着动画热播，推出游戏，电影及各类周边商品。。。。
     * is_finish : 1
     * pubtime : 2011
     * cur_episode : 227
     * max_episode : 225
     * season_num : 7
     * area : ["欧美"]
     * type : ["搞笑","亲子","益智"]
     * raing : 73
     * play_filter : 0
     * tags : [""]
     * default_pos : singles
     * seasons : [{"season_id":"7513","season_name":"第2部","season_no":"1"},{"season_id":"14189",
     * "season_name":"第4部","season_no":"3"},{"season_id":"14116","season_name":"第5部",
     * "season_no":"4"},{"season_id":"14117","season_name":"第6部","season_no":"5"},
     * {"season_id":"13825","season_name":"第7部","season_no":"6"},{"season_id":"14123",
     * "season_name":"第8部","season_no":"7"},{"season_id":"14063","season_name":"第9部",
     * "season_no":"8"}]
     * foreign_ip : 0
     */

    private String id;
    private String title;
    private String trunk;
    private String img_url;
    private String horizontal_poster;
    private String intro;
    private String is_finish;
    private String pubtime;
    private int cur_episode;
    private String max_episode;
    private int season_num;
    private String raing;
    private String play_filter;
    private String default_pos;
    private String foreign_ip;
    private List<String> area;
    private ArrayList<String> type;
    private List<String> tags;
    private List<SeasonsEntity> seasons;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrunk(String trunk) {
        this.trunk = trunk;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setHorizontal_poster(String horizontal_poster) {
        this.horizontal_poster = horizontal_poster;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setIs_finish(String is_finish) {
        this.is_finish = is_finish;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public void setCur_episode(int cur_episode) {
        this.cur_episode = cur_episode;
    }

    public void setMax_episode(String max_episode) {
        this.max_episode = max_episode;
    }

    public void setSeason_num(int season_num) {
        this.season_num = season_num;
    }

    public void setRaing(String raing) {
        this.raing = raing;
    }

    public void setPlay_filter(String play_filter) {
        this.play_filter = play_filter;
    }

    public void setDefault_pos(String default_pos) {
        this.default_pos = default_pos;
    }

    public void setForeign_ip(String foreign_ip) {
        this.foreign_ip = foreign_ip;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setSeasons(List<SeasonsEntity> seasons) {
        this.seasons = seasons;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTrunk() {
        return trunk;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getHorizontal_poster() {
        return horizontal_poster;
    }

    public String getIntro() {
        return intro;
    }

    public String getIs_finish() {
        return is_finish;
    }

    public String getPubtime() {
        return pubtime;
    }

    public int getCur_episode() {
        return cur_episode;
    }

    public String getMax_episode() {
        return max_episode;
    }

    public int getSeason_num() {
        return season_num;
    }

    public String getRaing() {
        return raing;
    }

    public String getPlay_filter() {
        return play_filter;
    }

    public String getDefault_pos() {
        return default_pos;
    }

    public String getForeign_ip() {
        return foreign_ip;
    }

    public List<String> getArea() {
        return area;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<SeasonsEntity> getSeasons() {
        return seasons;
    }

    public static class SeasonsEntity {
        /**
         * season_id : 7513
         * season_name : 第2部
         * season_no : 1
         */

        private String season_id;
        private String season_name;
        private String season_no;

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public void setSeason_name(String season_name) {
            this.season_name = season_name;
        }

        public void setSeason_no(String season_no) {
            this.season_no = season_no;
        }

        public String getSeason_id() {
            return season_id;
        }

        public String getSeason_name() {
            return season_name;
        }

        public String getSeason_no() {
            return season_no;
        }
    }
}
