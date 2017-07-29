package com.example.lenovo.jianningtianqi.entity;

import java.util.List;

/**
 * Created by lenovo on 2017/7/27.
 */

public class Answer_message {

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":"1147","quest":"我们常说的\u201c一打\u201d啤酒是指多少瓶啤酒？","result":"12瓶"}]
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
        @Override
        public String toString() {
            return "NewslistBean{" +
                    "id='" + id + '\'' +
                    ", quest='" + quest + '\'' +
                    ", result='" + result + '\'' +
                    '}';
        }

        /**
         * id : 1147
         * quest : 我们常说的“一打”啤酒是指多少瓶啤酒？
         * result : 12瓶
         */

        private String id;
        private String quest;
        private String result;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuest() {
            return quest;
        }

        public void setQuest(String quest) {
            this.quest = quest;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
