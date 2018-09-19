package com.hcmony.utils;

/**
 * @author hcmony
 * @create 2014-12-05 下午8:32
 */
public enum CodeIdEnum {

    /**
     * 成功
     */
    Success {
        @Override
        public String getName() {
            return "成功";
        }

        @Override
        public int getValue() {
            return 1;
        }
    },

    /**
     * 未登录
     */
    NotLoggedIn {
        @Override
        public String getName() {
            return "未登录";
        }

        @Override
        public int getValue() {
            return -1;
        }
    },
    /**
     * 参数格式错误
     */
    ParameterMalformed {
        @Override
        public String getName() {
            return "参数格式错误";
        }

        @Override
        public int getValue() {
            return -2;
        }
    },
    /**
     * 服务端错误
     */
    ServerError {
        @Override
        public String getName() {
            return "服务端错误";
        }

        @Override
        public int getValue() {
            return -3;
        }
    },
    /**
     * 用户名或密码错误
     */
    UserNameOrPwdError {
        @Override
        public String getName() {
            return "用户名或密码错误";
        }

        @Override
        public int getValue() {
            return -4;
        }
    },
    /**
     * 参数解析错误
     */
    AnalysisError {
        @Override
        public String getName() {
            return "参数解析错误";
        }

        @Override
        public int getValue() {
            return -5;
        }
    };
    public abstract String getName();


    public abstract int getValue();

}
