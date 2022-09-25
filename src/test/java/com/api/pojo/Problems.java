package com.api.pojo;

import com.google.gson.Gson;

public final class Problems {
	private int id;
    private String remark;
	
    public Problems(int id, String remark) {
		super();
		this.id = id;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "problems [id=" + id + ", remark=" + remark + "]";
	}

	public String toJson() {
    	Problems c = new Problems(id, remark);
    	Gson g = new Gson();
    	return g.toJson(c);
	}
}
