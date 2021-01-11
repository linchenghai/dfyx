package com.dfyx.crm.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 全局返回对象
 *
 * @param <T>
 */
@Getter
@Setter
public class ResponseObj<T> implements Serializable {
    protected static final long serialVersionUID = 170648828841730907L;
    protected int code;
    protected T data;
    protected boolean status;
    protected String msg;
    protected int count;

    public ResponseObj() {
        this.status = true;
        this.code = 0;
        this.msg = "";
    }

    public ResponseObj<T> error(String msg) {
        this.msg = msg;
        this.status = false;
        this.code = 500;
        return this;
    }

    public ResponseObj<T> success(T data) {
        this.status = true;
        this.code = 0;
        this.data = data;
        return this;
    }

	/*public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}*/
    
    
}
