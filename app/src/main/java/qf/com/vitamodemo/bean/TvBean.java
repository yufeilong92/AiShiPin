package qf.com.vitamodemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2015/10/15 0015.
 */
public class TvBean {
    /**
     * id : 10985
     * title : 美人心计
     * trunk : 美人心计
     * img_url : http://b.hiphotos.baidu
     * .com/video/pic/item/78310a55b319ebc4110610c68126cffc1e171676.jpg
     * horizontal_poster :
     * intro :
     * 西汉初年，幼年时期的窦漪房（原名云汐）因母亲卷入后宫斗争被追杀，导致满门抄斩，长大后误打误撞被选入宫为奴成为家人子。她设计将周采女生的儿子换给吕后的外孙女—皇后张嫣，吕后欣赏她的聪明能干，以赐婚为名派往代国监视刘恒母子。为天下苍生不再受苦，也为吕后能更信任她，漪房提议刘恒以修陵寝为名秘密练兵，令所有人都觉得她是祸水。只有刘恒始终相信她并封后，夫妻俩走过一个又一个难关，终于成就千秋大业。母仪天下的她发现，拥有权力的同时感情却在渐渐流逝，她努力挽回丈夫的心，阻止儿子们互相残杀，运用女性独特的手法化解了一次又一次的危机，并且为西汉创立了历史上有名的文景之治。她的名字也载入史册，为后人所称颂。
     * is_finish : 1
     * pubtime : 2010
     * cur_episode : 40
     * max_episode : 40
     * director : ["吴锦源","梁欣全","陈国华"]
     * actor : ["林心如","陈键锋","杨幂"]
     * area : ["内地"]
     * season_num : 0
     * type : ["爱情","古装"]
     * rating : 76
     * play_filter : 0
     * tags : ["古代","古装","历史","复仇","权力斗争","女性"]
     * default_pos : singles
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
    private String rating;
    private String play_filter;
    private String default_pos;
    private String foreign_ip;
    private List<String> director;
    private List<String> actor;
    private List<String> area;
    private List<String> type;
    private List<String> tags;

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

    public void setRating(String rating) {
        this.rating = rating;
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

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public void setActor(List<String> actor) {
        this.actor = actor;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

    public String getRating() {
        return rating;
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

    public List<String> getDirector() {
        return director;
    }

    public List<String> getActor() {
        return actor;
    }

    public List<String> getArea() {
        return area;
    }

    public List<String> getType() {
        return type;
    }

    public List<String> getTags() {
        return tags;
    }
}
