package com.jquery;

public class AddressBean {
	int num;
	String name;
	String addr;
	String phone;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr == null ? "" : addr.trim();
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone == null ? "" : phone.trim();
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
