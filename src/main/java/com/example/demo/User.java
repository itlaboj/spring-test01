package com.example.demo;

public class User {
	//フィールド
	private int id; //ID番号
	private String name; //名前

	//コンストラクタ
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	//アクセッサ・メソッド（セッタ＆ゲッタ）
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
