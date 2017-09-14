package com.vension.flexbox;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/14.
 */

public class FlexTagInfo implements Serializable {
	private int id;
	private String name;
	private boolean isSelected;


	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean selected) {
		isSelected = selected;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FlexTagInfo() {
	}

}
