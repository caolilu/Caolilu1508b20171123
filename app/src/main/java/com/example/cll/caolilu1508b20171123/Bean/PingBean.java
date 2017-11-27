package com.example.cll.caolilu1508b20171123.Bean;

import java.util.List;

/**
 * Created by cll on 2017/11/24.
 */

public class PingBean {
    /**
     * msg : 成功
     * ret : {"pnum":1,"totalRecords":7,"records":20,"list":[{"msg":"下面的说的假不假","phoneNumber":"18403415831","dataId":"ff8080815de4a85a015df3e73f0449f2","userPic":"","time":"2017-08-18 13:53:24","likeNum":0},{"msg":"电影好看！","phoneNumber":"ghj","dataId":"ff8080815db7e5a9015db8a6db35327e","userPic":"http://q.qlogo.cn/qqapp/1101034181/9168D7906ED54774BCDA4B6AD21834BB/40","time":"2017-08-07 01:45:29","likeNum":0},{"msg":"好看","phoneNumber":"ghj","dataId":"ff8080815db7e649015db8a60ac130d9","userPic":"http://q.qlogo.cn/qqapp/1101034181/9168D7906ED54774BCDA4B6AD21834BB/40","time":"2017-08-07 01:44:35","likeNum":0},{"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"逞强的笑","dataId":"ff8080815d9c29c6015da120be9338bc","userPic":"","time":"2017-07-28 13:03:26","likeNum":0},{"msg":"挺好的，喜欢这个导演。","phoneNumber":"我们终成陌生人","dataId":"ff8080815d9c29c6015da120be9538bd","userPic":"","time":"2017-07-27 22:13:17","likeNum":0},{"msg":"这部片子得抽空再看一遍才行，拍的挺好的。","phoneNumber":"静等一旧人","dataId":"ff8080815d9c29c6015da120be9138bb","userPic":"","time":"2017-07-27 16:15:43","likeNum":0},{"msg":"朋友推荐的这部片子，看完之后觉得真的很棒！","phoneNumber":"静等一旧人","dataId":"ff8080815d9c29c6015da120be8f38ba","userPic":"","time":"2017-07-25 11:34:17","likeNum":3}],"totalPnum":1}
     * code : 200
     */

    private String msg;
    private RetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class RetBean {
        /**
         * pnum : 1
         * totalRecords : 7
         * records : 20
         * list : [{"msg":"下面的说的假不假","phoneNumber":"18403415831","dataId":"ff8080815de4a85a015df3e73f0449f2","userPic":"","time":"2017-08-18 13:53:24","likeNum":0},{"msg":"电影好看！","phoneNumber":"ghj","dataId":"ff8080815db7e5a9015db8a6db35327e","userPic":"http://q.qlogo.cn/qqapp/1101034181/9168D7906ED54774BCDA4B6AD21834BB/40","time":"2017-08-07 01:45:29","likeNum":0},{"msg":"好看","phoneNumber":"ghj","dataId":"ff8080815db7e649015db8a60ac130d9","userPic":"http://q.qlogo.cn/qqapp/1101034181/9168D7906ED54774BCDA4B6AD21834BB/40","time":"2017-08-07 01:44:35","likeNum":0},{"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"逞强的笑","dataId":"ff8080815d9c29c6015da120be9338bc","userPic":"","time":"2017-07-28 13:03:26","likeNum":0},{"msg":"挺好的，喜欢这个导演。","phoneNumber":"我们终成陌生人","dataId":"ff8080815d9c29c6015da120be9538bd","userPic":"","time":"2017-07-27 22:13:17","likeNum":0},{"msg":"这部片子得抽空再看一遍才行，拍的挺好的。","phoneNumber":"静等一旧人","dataId":"ff8080815d9c29c6015da120be9138bb","userPic":"","time":"2017-07-27 16:15:43","likeNum":0},{"msg":"朋友推荐的这部片子，看完之后觉得真的很棒！","phoneNumber":"静等一旧人","dataId":"ff8080815d9c29c6015da120be8f38ba","userPic":"","time":"2017-07-25 11:34:17","likeNum":3}]
         * totalPnum : 1
         */

        private int pnum;
        private int totalRecords;
        private int records;
        private int totalPnum;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * msg : 下面的说的假不假
             * phoneNumber : 18403415831
             * dataId : ff8080815de4a85a015df3e73f0449f2
             * userPic :
             * time : 2017-08-18 13:53:24
             * likeNum : 0
             */

            private String msg;
            private String phoneNumber;
            private String dataId;
            private String userPic;
            private String time;
            private int likeNum;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
