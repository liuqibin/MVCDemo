package com.example.mymvc.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public class CangTouShiBean {


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"list":["春至一来朝，夏馀将宿草。秋还未肯疏，冬风吹草木。","春山有鸟声，夏牖竹稍风。秋暮瑶池宴，冬去冰须泮。","春至不知来，夏期秋未来。秋发小山枝，冬暖拾松枝。","春雷一声发，夏首荐枇杷。秋草不堪论，冬狩美秦正。","春冰弥轸虑，夏雨桑条绿。秋草不堪论，冬去更筹尽。","春残日更长，夏景恬且旷。秋草不堪论，冬暮久无乐。"]}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * list : ["春至一来朝，夏馀将宿草。秋还未肯疏，冬风吹草木。","春山有鸟声，夏牖竹稍风。秋暮瑶池宴，冬去冰须泮。","春至不知来，夏期秋未来。秋发小山枝，冬暖拾松枝。","春雷一声发，夏首荐枇杷。秋草不堪论，冬狩美秦正。","春冰弥轸虑，夏雨桑条绿。秋草不堪论，冬去更筹尽。","春残日更长，夏景恬且旷。秋草不堪论，冬暮久无乐。"]
         */

        private int ret_code;
        private List<String> list;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
