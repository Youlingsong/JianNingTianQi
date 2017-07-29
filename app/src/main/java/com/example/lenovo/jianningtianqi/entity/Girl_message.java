package com.example.lenovo.jianningtianqi.entity;

import java.util.List;

/**
 * Created by lenovo on 2017/7/22.
 */

public class Girl_message {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-04-23 15:00","title":"任性刘美辰性感荷叶边WILFUL比基尼","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/02/m.xxxiao.com_5161ae1dad570a8ac9f13d05526d917d-760x500.jpg","url":"http://m.xxxiao.com/41462"},{"ctime":"2016-04-23 16:00","title":"清纯刘雪妮Verna私房养眼美拍","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/02/m.xxxiao.com_68d1fd39990f101a5f6f2a1b370b709f-760x500.jpg","url":"http://m.xxxiao.com/34833"},{"ctime":"2016-04-23 18:00","title":"灵动清秀  晶莹美丝","description":"华声美女","picUrl":"http://image.hnol.net/c/2016-04/23/17/201604231702114811-2381913.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7173552-0-1.html"},{"ctime":"2016-04-23 19:00","title":"美女骑手性感丝袜外拍","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/12/m.xxxiao.com_1767428a6b29defd40e1ab85c0e7ab51-760x500.jpg","url":"http://m.xxxiao.com/6361"},{"ctime":"2016-04-23 21:00","title":"[贴图]红衣娇妹","description":"华声美女","picUrl":"http://image.hnol.net/c/2016-04/23/20/201604232024545991-4217076.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7173694-0-1.html"},{"ctime":"2016-04-23 21:00","title":"[贴图]漂亮气质旗袍女","description":"华声美女","picUrl":"http://image.hnol.net/c/2016-04/23/20/201604232017511521-4217076.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7173688-0-1.html"},{"ctime":"2016-04-24 10:00","title":"纤纤淑女王馨瑶窈窕紧致尽显性感","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_add06bfa5f193520386501d15d0b7418-760x500.jpg","url":"http://m.xxxiao.com/20679"},{"ctime":"2016-04-24 12:00","title":"美女孙宁高清壁纸","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/12/m.xxxiao.com_b76b49d7c134055e6c31d10f9cd973e5-760x500.jpg","url":"http://m.xxxiao.com/15951"},{"ctime":"2016-04-24 13:00","title":"美艳蚀骨王瑞儿让人意乱情迷臆想翩翩性感美照","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/04/m.xxxiao.com_d27ebcb5731046a3513fe326ff30303f-760x500.jpg","url":"http://m.xxxiao.com/46339"},{"ctime":"2016-04-24 15:00","title":"I邻家女孩\u2026\u2026[楚楚动人 李妞妞 116p]\u2026\u2026第八百七十九辑","description":"华声美女","picUrl":"http://image.hnol.net/c/2016-04/24/14/2016042414371971-1559530.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7174206-0-1.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2016-04-23 15:00
         * title : 任性刘美辰性感荷叶边WILFUL比基尼
         * description : 美女写真
         * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2016/02/m.xxxiao.com_5161ae1dad570a8ac9f13d05526d917d-760x500.jpg
         * url : http://m.xxxiao.com/41462
         */

        public String ctime;
        public String title;
        public String description;
        public String picUrl;
        public String url;

        @Override
        public String toString() {
            return "NewslistBean{" +
                    "ctime='" + ctime + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public String toString() {
        return "Girl_message{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist +
                '}';
    }
}
