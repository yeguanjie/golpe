package com.golpesoft.erp.facade.common;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * @author yeguanjie
 *
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6888885870955941382L;

    /**
     * 接口调用状态-如果为true,则可以调用getResult,如果为false,则调用errorCode来获取出错信息
     */
    private boolean success;

    /**
     * 调用返回值-泛型
     */
    private T result;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMsg;

    /**
     * 默认构造方法
     */
    public Result() {
    }

    /**
     * 默认构造方法<p/>
     * 设置返回结果，则默认接口调用成功
     *
     * @param result 调用返回值
     */
    public Result(T result) {
        this.success = true;
        this.result = result;
    }

    /**
     * 构造方法，根据flag返回不同结果
     *
     * @param flag   接口调用状态
     * @param result 调用返回值
     */
    public Result(boolean flag, T result) {
        if (flag) {
            this.success = true;
            this.result = result;
        } else {
            this.success = false;
            this.errorCode = (String) result;
        }
    }

    /**
     * 构造方法，接口调用失败，设置错误描述
     *
     * @param errorCode 错误描述
     */
    public Result(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
    }

    /**
     * 构造方法，设置错误信息
     *
     * @param errorCode 错误码
     * @param errorMsg  错误描述
     */
    public Result(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        success = true;
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result response = (Result) o;

        return success == response.success
                && result.equals(response.result)
                && errorCode.equals(response.errorCode);

    }

    @Override
    public int hashCode() {
        int result1 = (success ? 1 : 0);
        result1 = 31 * result1 + result.hashCode();
        result1 = 31 * result1 + errorCode.hashCode();
        return result1;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("success", success)
                .add("result", result)
                .add("errorCode", errorCode)
                .add("errorMsg", errorMsg)
                .omitNullValues()
                .toString();
    }
}
