package com.example.duanwu.project3.bean.GankBean;

import java.util.List;

public class FrontendBean {


    /**
     * error : false
     * results : [{"_id":"5c6a16559d2122267ad2c501","createdAt":"2019-02-18T02:20:05.182Z","desc":"JavaScript是如何工作的：引擎，运行时和调用堆栈的概述！","publishedAt":"2019-02-18T02:20:22.190Z","source":"web","type":"前端","url":"https://segmentfault.com/a/1190000017352941","used":true,"who":"bym"},{"_id":"5c52fa699d212243205cc803","createdAt":"2019-02-13T03:14:03.948Z","desc":"一个漂亮的前端网站导航~","publishedAt":"2019-02-13T03:14:10.219Z","source":"web","type":"前端","url":"http://nav.web-hub.cn/","used":true,"who":"lijinshanmx"},{"_id":"5c5c46d39d212243283ecd1b","createdAt":"2019-02-13T03:12:23.79Z","desc":"Bootstrap Table 表格插件，简单配置便可拥有强大的单选、多选、排序、分页，以及编辑、导出、过滤等等.","publishedAt":"2019-02-13T03:13:00.278Z","source":"web","type":"前端","url":"https://github.com/wenzhixin/bootstrap-table","used":true,"who":"lijinshanmx"},{"_id":"5c6389999d2122132ba0cae4","createdAt":"2019-02-13T03:06:01.229Z","desc":"🦎一套代码运行多端，一端所见即多端所见,滴滴发布的跨端整体解决方案.","images":["http://img.gank.io/a7a104ee-6e5e-460e-9a31-d90d064ca7b6","http://img.gank.io/bfa17787-8671-42c6-af89-240b60bc0165","http://img.gank.io/26f08070-3fd7-4e2e-9607-966d3edada17","http://img.gank.io/7ae3f909-ce15-40aa-989e-b5b2178d967d","http://img.gank.io/5cd11a95-8aba-45d6-b9c1-b0d67fb500fc"],"publishedAt":"2019-02-13T03:07:00.519Z","source":"chrome","type":"前端","url":"https://github.com/didi/chameleon","used":true,"who":"lijinshanmx"},{"_id":"5c628ffe9d212243235e6428","createdAt":"2019-02-12T09:21:02.679Z","desc":"近一万字的ES6语法知识点补充","publishedAt":"2019-02-12T09:21:51.624Z","source":"web","type":"前端","url":"https://juejin.im/post/5c6234f16fb9a049a81fcca5","used":true,"who":"bym"},{"_id":"5c612ce29d212243283ecd1f","createdAt":"2019-02-11T08:05:54.928Z","desc":"用 JavaScript 和 Emoji 做地址栏动画","publishedAt":"2019-02-11T08:07:26.974Z","source":"web","type":"前端","url":"https://juejin.im/post/5c49b822f265da6142743a87","used":true,"who":"bym"},{"_id":"5c5489879d212243235e641c","createdAt":"2019-02-01T18:01:43.288Z","desc":"React 服务端渲染完美的解决方案","publishedAt":"2019-02-11T08:07:16.702Z","source":"web","type":"前端","url":"https://segmentfault.com/a/1190000017361781","used":true,"who":"bym"},{"_id":"5c4fff459d212243283ecd13","createdAt":"2019-01-29T07:22:45.27Z","desc":" 正则全攻略使用手册","publishedAt":"2019-01-29T07:23:03.67Z","source":"web","type":"前端","url":"https://segmentfault.com/a/1190000018042746","used":true,"who":"bym"},{"_id":"5c4dbd2d9d21224326203318","createdAt":"2019-01-27T14:16:13.365Z","desc":"前端组件设计原则","publishedAt":"2019-01-27T14:18:06.726Z","source":"web","type":"前端","url":"https://juejin.im/post/5c49cff56fb9a049bd42a90f","used":true,"who":"bym"},{"_id":"5c4bfdc19d212243205cc7f3","createdAt":"2019-01-26T06:27:13.191Z","desc":"这篇文章聊明白管理状态这一堆看起来挺复杂的东西。","publishedAt":"2019-01-27T14:18:02.608Z","source":"web","type":"前端","url":"https://zhuanlan.zhihu.com/p/53599723","used":true,"who":"bym"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5c6a16559d2122267ad2c501
         * createdAt : 2019-02-18T02:20:05.182Z
         * desc : JavaScript是如何工作的：引擎，运行时和调用堆栈的概述！
         * publishedAt : 2019-02-18T02:20:22.190Z
         * source : web
         * type : 前端
         * url : https://segmentfault.com/a/1190000017352941
         * used : true
         * who : bym
         * images : ["http://img.gank.io/a7a104ee-6e5e-460e-9a31-d90d064ca7b6","http://img.gank.io/bfa17787-8671-42c6-af89-240b60bc0165","http://img.gank.io/26f08070-3fd7-4e2e-9607-966d3edada17","http://img.gank.io/7ae3f909-ce15-40aa-989e-b5b2178d967d","http://img.gank.io/5cd11a95-8aba-45d6-b9c1-b0d67fb500fc"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
