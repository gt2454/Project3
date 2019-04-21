package com.example.duanwu.project3.bean;

import java.util.List;

/**
 * Created by asus on 2019/3/19.
 */

public class DailyNewsBean {

    /**
     * date : 20190319
     * stories : [{"title":"瞧瞧，这些奇葩的进化啊","ga_prefix":"031909","images":["https://pic4.zhimg.com/v2-9ea7f914da080936b48f1dfd7d435ed7.jpg"],"multipic":true,"type":0,"id":9708910},{"images":["https://pic4.zhimg.com/v2-9cf4888a1590084b53b9a62ebff65a27.jpg"],"type":0,"id":9709102,"ga_prefix":"031908","title":"从卖卖卖到建建建，李嘉诚退休这一年发生了什么？"},{"images":["https://pic3.zhimg.com/v2-ca0316bec83d6358f8c31e859034691e.jpg"],"type":0,"id":9708920,"ga_prefix":"031907","title":"职业规划，可不是「十年内做到 XX 总监」这么简单"},{"images":["https://pic3.zhimg.com/v2-780208f5f0d109177d8a0bec504c9bc6.jpg"],"type":0,"id":9709037,"ga_prefix":"031906","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-7a2a92133f0467690bf3dd09b2c8c355.jpg","type":0,"id":9708920,"ga_prefix":"031907","title":"职业规划，可不是「十年内做到 XX 总监」这么简单"},{"image":"https://pic3.zhimg.com/v2-6ee1e653465615d1e1575c942c34c31a.jpg","type":0,"id":9709102,"ga_prefix":"031908","title":"从卖卖卖到建建建，李嘉诚退休这一年发生了什么？"},{"image":"https://pic1.zhimg.com/v2-ba270476065e35eb080fe986d79e8434.jpg","type":0,"id":9709069,"ga_prefix":"031819","title":"想解约？好，「邓紫棋」这个名字我回收了"},{"image":"https://pic1.zhimg.com/v2-137295428bd17f3732449ae23c76f32c.jpg","type":0,"id":9709061,"ga_prefix":"031817","title":"电子烟，可根本不是戒烟神器"},{"image":"https://pic2.zhimg.com/v2-503dbf6ffd00cdfe0771b1563787b8cd.jpg","type":0,"id":9709018,"ga_prefix":"031807","title":"冷冻减肥、椰子油、酵素，这些年你跟着明星交了多少智商税？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 瞧瞧，这些奇葩的进化啊
         * ga_prefix : 031909
         * images : ["https://pic4.zhimg.com/v2-9ea7f914da080936b48f1dfd7d435ed7.jpg"]
         * multipic : true
         * type : 0
         * id : 9708910
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-7a2a92133f0467690bf3dd09b2c8c355.jpg
         * type : 0
         * id : 9708920
         * ga_prefix : 031907
         * title : 职业规划，可不是「十年内做到 XX 总监」这么简单
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
