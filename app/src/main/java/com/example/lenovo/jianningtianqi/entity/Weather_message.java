package com.example.lenovo.jianningtianqi.entity;

import java.util.List;

/**
 * Created by lenovo on 2017/7/27.
 */

public class Weather_message {


    private List<HeWeatherBean> HeWeather;

    public List<HeWeatherBean> getHeWeather() {
        return HeWeather;
    }

    public void setHeWeather(List<HeWeatherBean> HeWeather) {
        this.HeWeather = HeWeather;
    }

    public static class HeWeatherBean {
        /**
         * aqi : {"city":{"aqi":"50","co":"1","no2":"22","o3":"161","pm10":"44","pm25":"35","qlty":"优","so2":"8"}}
         * basic : {"city":"苏州","cnty":"中国","id":"CN101190401","lat":"31.29937935","lon":"120.61958313","update":{"loc":"2017-07-27 14:48","utc":"2017-07-27 06:48"}}
         * daily_forecast : [{"astro":{"mr":"08:59","ms":"21:44","sr":"05:12","ss":"18:58"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2017-07-27","hum":"56","pcpn":"0.0","pop":"0","pres":"1005","tmp":{"max":"39","min":"29"},"uv":"11","vis":"20","wind":{"deg":"122","dir":"东南风","sc":"微风","spd":"12"}},{"astro":{"mr":"09:58","ms":"22:19","sr":"05:12","ss":"18:57"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2017-07-28","hum":"62","pcpn":"0.0","pop":"0","pres":"1006","tmp":{"max":"38","min":"29"},"uv":"11","vis":"20","wind":{"deg":"120","dir":"东南风","sc":"微风","spd":"10"}},{"astro":{"mr":"10:55","ms":"22:53","sr":"05:13","ss":"18:56"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-07-29","hum":"65","pcpn":"0.0","pop":"2","pres":"1005","tmp":{"max":"37","min":"29"},"uv":"11","vis":"19","wind":{"deg":"136","dir":"东南风","sc":"微风","spd":"16"}}]
         * hourly_forecast : [{"cond":{"code":"100","txt":"晴"},"date":"2017-07-27 16:00","hum":"44","pop":"0","pres":"1004","tmp":"37","wind":{"deg":"135","dir":"东南风","sc":"3-4","spd":"18"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-07-27 19:00","hum":"58","pop":"0","pres":"1004","tmp":"35","wind":{"deg":"126","dir":"东南风","sc":"3-4","spd":"19"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-07-27 22:00","hum":"69","pop":"0","pres":"1006","tmp":"31","wind":{"deg":"128","dir":"东南风","sc":"3-4","spd":"19"}}]
         * now : {"cond":{"code":"100","txt":"晴"},"fl":"41","hum":"41","pcpn":"0","pres":"1006","tmp":"38","vis":"5","wind":{"deg":"86","dir":"东风","sc":"微风","spd":"7"}}
         * status : ok
         * suggestion : {"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"很不舒适","txt":"白天天气晴好，但烈日炎炎会使您会感到很热，很不舒适。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},"sport":{"brf":"较不宜","txt":"天气较好，但气温很高，风力较大，请减少运动时间并降低运动强度，户外运动须注意避风防晒。"},"trav":{"brf":"较不宜","txt":"天气较好，很热，但4、5级风能缓解炎热的感觉。出游请注意防暑防晒，可以选择水上娱乐等较清凉项目。"},"uv":{"brf":"很强","txt":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"}}
         */

        private AqiBean aqi;
        private BasicBean basic;
        private NowBean now;
        private String status;
        private SuggestionBean suggestion;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyForecastBean> hourly_forecast;

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyForecastBean> getHourly_forecast() {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }

        public static class AqiBean {
            /**
             * city : {"aqi":"50","co":"1","no2":"22","o3":"161","pm10":"44","pm25":"35","qlty":"优","so2":"8"}
             */

            private CityBean city;

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            public static class CityBean {
                /**
                 * aqi : 50
                 * co : 1
                 * no2 : 22
                 * o3 : 161
                 * pm10 : 44
                 * pm25 : 35
                 * qlty : 优
                 * so2 : 8
                 */

                private String aqi;
                private String co;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25;
                private String qlty;
                private String so2;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }
            }
        }

        public static class BasicBean {
            /**
             * city : 苏州
             * cnty : 中国
             * id : CN101190401
             * lat : 31.29937935
             * lon : 120.61958313
             * update : {"loc":"2017-07-27 14:48","utc":"2017-07-27 06:48"}
             */

            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            private UpdateBean update;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public static class UpdateBean {
                /**
                 * loc : 2017-07-27 14:48
                 * utc : 2017-07-27 06:48
                 */

                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowBean {
            /**
             * cond : {"code":"100","txt":"晴"}
             * fl : 41
             * hum : 41
             * pcpn : 0
             * pres : 1006
             * tmp : 38
             * vis : 5
             * wind : {"deg":"86","dir":"东风","sc":"微风","spd":"7"}
             */

            private CondBean cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private WindBean wind;

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class CondBean {
                /**
                 * code : 100
                 * txt : 晴
                 */

                private String code;
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindBean {
                /**
                 * deg : 86
                 * dir : 东风
                 * sc : 微风
                 * spd : 7
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class SuggestionBean {
            /**
             * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
             * comf : {"brf":"很不舒适","txt":"白天天气晴好，但烈日炎炎会使您会感到很热，很不舒适。"}
             * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
             * drsg : {"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"}
             * flu : {"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"}
             * sport : {"brf":"较不宜","txt":"天气较好，但气温很高，风力较大，请减少运动时间并降低运动强度，户外运动须注意避风防晒。"}
             * trav : {"brf":"较不宜","txt":"天气较好，很热，但4、5级风能缓解炎热的感觉。出游请注意防暑防晒，可以选择水上娱乐等较清凉项目。"}
             * uv : {"brf":"很强","txt":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"}
             */

            private AirBean air;
            private AirBean comf;
            private AirBean cw;
            private AirBean drsg;
            private AirBean flu;
            private AirBean sport;
            private AirBean trav;
            private AirBean uv;

            public AirBean getAir() {
                return air;
            }

            public void setAir(AirBean air) {
                this.air = air;
            }

            public AirBean getComf() {
                return comf;
            }

            public void setComf(AirBean comf) {
                this.comf = comf;
            }

            public AirBean getCw() {
                return cw;
            }

            public void setCw(AirBean cw) {
                this.cw = cw;
            }

            public AirBean getDrsg() {
                return drsg;
            }

            public void setDrsg(AirBean drsg) {
                this.drsg = drsg;
            }

            public AirBean getFlu() {
                return flu;
            }

            public void setFlu(AirBean flu) {
                this.flu = flu;
            }

            public AirBean getSport() {
                return sport;
            }

            public void setSport(AirBean sport) {
                this.sport = sport;
            }

            public AirBean getTrav() {
                return trav;
            }

            public void setTrav(AirBean trav) {
                this.trav = trav;
            }

            public AirBean getUv() {
                return uv;
            }

            public void setUv(AirBean uv) {
                this.uv = uv;
            }

            public static class AirBean {
                /**
                 * brf : 中
                 * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
                 */

                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean {
            /**
             * astro : {"mr":"08:59","ms":"21:44","sr":"05:12","ss":"18:58"}
             * cond : {"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"}
             * date : 2017-07-27
             * hum : 56
             * pcpn : 0.0
             * pop : 0
             * pres : 1005
             * tmp : {"max":"39","min":"29"}
             * uv : 11
             * vis : 20
             * wind : {"deg":"122","dir":"东南风","sc":"微风","spd":"12"}
             */

            private AstroBean astro;
            private CondBeanX cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            private TmpBean tmp;
            private String uv;
            private String vis;
            private NowBean.WindBean wind;

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public CondBeanX getCond() {
                return cond;
            }

            public void setCond(CondBeanX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public NowBean.WindBean getWind() {
                return wind;
            }

            public void setWind(NowBean.WindBean wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                /**
                 * mr : 08:59
                 * ms : 21:44
                 * sr : 05:12
                 * ss : 18:58
                 */

                private String mr;
                private String ms;
                private String sr;
                private String ss;

                public String getMr() {
                    return mr;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public String getMs() {
                    return ms;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondBeanX {
                /**
                 * code_d : 100
                 * code_n : 100
                 * txt_d : 晴
                 * txt_n : 晴
                 */

                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public String getCode_d() {
                    return code_d;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpBean {
                /**
                 * max : 39
                 * min : 29
                 */

                private String max;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }
        }

        public static class HourlyForecastBean {
            /**
             * cond : {"code":"100","txt":"晴"}
             * date : 2017-07-27 16:00
             * hum : 44
             * pop : 0
             * pres : 1004
             * tmp : 37
             * wind : {"deg":"135","dir":"东南风","sc":"3-4","spd":"18"}
             */

            private NowBean.CondBean cond;
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            private NowBean.WindBean wind;

            public NowBean.CondBean getCond() {
                return cond;
            }

            public void setCond(NowBean.CondBean cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public NowBean.WindBean getWind() {
                return wind;
            }

            public void setWind(NowBean.WindBean wind) {
                this.wind = wind;
            }
        }
    }
}
