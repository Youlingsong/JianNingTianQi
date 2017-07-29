package com.example.lenovo.jianningtianqi.entity;

import java.util.List;

/**
 * Created by lenovo on 2017/7/25.
 */

public class Joke_message {


    /**
     * code : 200
     * msg : success
     * newslist : [{"id":1295,"title":"中国移动在香港的68港元(约54元人民币)套餐在网络走红","content":"中国移动在香港的68港元(约54元人民币)套餐在网络走红：1700分钟通话，10000条短信，上网流量不限。而价格相似的中国移动内地58元套餐：350分钟，10MB流量。【神吐槽】1. 很简单，在香港有大量竞争，而内地就是垄断2. 一国两制的先进性3. 少壮不努力，一生在内地"}]
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
         * id : 1295
         * title : 中国移动在香港的68港元(约54元人民币)套餐在网络走红
         * content : 中国移动在香港的68港元(约54元人民币)套餐在网络走红：1700分钟通话，10000条短信，上网流量不限。而价格相似的中国移动内地58元套餐：350分钟，10MB流量。【神吐槽】1. 很简单，在香港有大量竞争，而内地就是垄断2. 一国两制的先进性3. 少壮不努力，一生在内地
         */

        private int id;
        private String title;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
