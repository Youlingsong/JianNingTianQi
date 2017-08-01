package com.example.lenovo.jianningtianqi.entity;

/**
 * Created by lenovo on 2017/7/29.
 */

public class JiQiRen_message  {

    /**
     * result : {"code":"100000","text":"是图灵机器人，一枚大帅哥～","list":null}
     * error_code : 0
     * reason : Succes
     */

    private ResultBean result;
    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        /**
         * code : 100000
         * text : 是图灵机器人，一枚大帅哥～
         * list : null
         */

        private String code;
        private String text;
        private Object list;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Object getList() {
            return list;
        }

        public void setList(Object list) {
            this.list = list;
        }
    }
}
