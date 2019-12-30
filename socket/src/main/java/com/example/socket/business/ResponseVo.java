package com.example.socket.business;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

@ApiModel("返回结果")
public class ResponseVo<T> {
    public static final String EXCEPTION_ERROR_MESSAGE_PARAMETER_ERR = "参数错误";
    public static final int RESPONSE_CODE_PARAMETER_ERR = -9999;
    public static final String RESULT_STATUS_CODE = "code";
    public static final String RESULT_STATUS_MESSAGE = "message";
    public static final int INNER_EXCEPTION_CODE = -1000;
    public static final int NO_PERMISSIONS = -2;
    public static final int NOT_LOGIN = -999;
    public static final int NUMBER_ZERO = 0;
    public static final Integer RESPONSE_CODE_OK = 200;
    public static final Integer RESPONSE_CODE_ERROR = -1;
    @ApiModelProperty("响应状态 200成功 -1失败 -2 无操作权限 -999未登录 -1000内部错误 -9999参数错误")
    private Integer code;
    @ApiModelProperty("错误信息")
    private String message;
    @ApiModelProperty("返回内容")
    private T content;

    public ResponseVo() {
    }

    public ResponseVo(T t) {
        this.content = t;
    }

    public ResponseVo<T> ok(T content) {
        return this.ok(content, (String)null);
    }

    public ResponseVo<T> ok(T content, String message) {
        this.setCode(RESPONSE_CODE_OK);
        this.setMessage(StringUtils.isBlank(message) ? "操作成功。" : message);
        this.content = content;
        return this;
    }

    public ResponseVo<T> error(T content) {
        return this.error(content, (String)null);
    }

    public ResponseVo<T> error(T content, String msg) {
        this.setCode(RESPONSE_CODE_ERROR);
        this.setMessage(StringUtils.isBlank(msg) ? "操作失败。" : msg);
        this.content = content;
        return this;
    }

    public ResponseVo<T> error(T content, String msg, Integer errCode) {
        this.setCode(errCode);
        this.setMessage(StringUtils.isBlank(msg) ? "操作失败。" : msg);
        this.content = content;
        return this;
    }

    public ResponseVo<T> notLogin(T content, String msg) {
        this.setCode(-999);
        this.setMessage(StringUtils.isBlank(msg) ? "操作失败。" : msg);
        this.content = content;
        return this;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getContent() {
        return this.content;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseVo)) {
            return false;
        } else {
            ResponseVo<?> other = (ResponseVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseVo;
    }


    public String toString() {
        return "ResponseVo(code=" + this.getCode() + ", message=" + this.getMessage() + ", content=" + this.getContent() + ")";
    }
}

