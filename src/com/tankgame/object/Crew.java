package com.tankgame.object;

import java.awt.image.BufferedImage;

import com.tankgame.util.ImageUtil;

public class Crew {

	/** 乗員基本情報 **/
	// 乗員ID
	private int crewID;
	// 乗員名
	private String crewName;
	// 乗員説明文ID
	private int crewDescriptionID;
	// 役割ID
	private int crewJobID;
	// 階級ID
	private int crewGradeID;

	/** 乗員パラメータ **/
	// 練度1
	private int crewDuration1;
	// 練度2
	private int crewDuration2;
	// 練度3
	private int crewDuration3;
	// 練度4
	private int crewDuration4;
	// 練度5
	private int crewDuration5;

	/** UI情報 **/
	// イメージ
	private BufferedImage crewImage;

	// 最小
	public Crew(int crewID) {
		this.crewID = crewID;
	}

	// フル
	public Crew(int crewID, String crewName, int crewDescriptionID, int crewJobID, int crewGradeID, int crewDuration1,
			int crewDuration2, int crewDuration3, int crewDuration4, int crewDuration5, BufferedImage crewImage) {
		super();
		this.crewID = crewID;
		this.crewName = crewName;
		this.crewDescriptionID = crewDescriptionID;
		this.crewJobID = crewJobID;
		this.crewGradeID = crewGradeID;
		this.crewDuration1 = crewDuration1;
		this.crewDuration2 = crewDuration2;
		this.crewDuration3 = crewDuration3;
		this.crewDuration4 = crewDuration4;
		this.crewDuration5 = crewDuration5;

		// 初回の呼び出しのみイメージをロード
		if (crewImage == null) {
			crewImage = ImageUtil.loadImage();
		}
	}

	public int getCrewID() {
		return crewID;
	}

	public void setCrewID(int crewID) {
		this.crewID = crewID;
	}

	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public int getCrewDescriptionID() {
		return crewDescriptionID;
	}

	public void setCrewDescriptionID(int crewDescriptionID) {
		this.crewDescriptionID = crewDescriptionID;
	}

	public int getCrewJobID() {
		return crewJobID;
	}

	public void setCrewJobID(int crewJobID) {
		this.crewJobID = crewJobID;
	}

	public int getCrewGradeID() {
		return crewGradeID;
	}

	public void setCrewGradeID(int crewGradeID) {
		this.crewGradeID = crewGradeID;
	}

	public int getCrewDuration1() {
		return crewDuration1;
	}

	public void setCrewDuration1(int crewDuration1) {
		this.crewDuration1 = crewDuration1;
	}

	public int getCrewDuration2() {
		return crewDuration2;
	}

	public void setCrewDuration2(int crewDuration2) {
		this.crewDuration2 = crewDuration2;
	}

	public int getCrewDuration3() {
		return crewDuration3;
	}

	public void setCrewDuration3(int crewDuration3) {
		this.crewDuration3 = crewDuration3;
	}

	public int getCrewDuration4() {
		return crewDuration4;
	}

	public void setCrewDuration4(int crewDuration4) {
		this.crewDuration4 = crewDuration4;
	}

	public int getCrewDuration5() {
		return crewDuration5;
	}

	public void setCrewDuration5(int crewDuration5) {
		this.crewDuration5 = crewDuration5;
	}

	public BufferedImage getCrewImage() {
		return crewImage;
	}

	public void setCrewImage(BufferedImage crewImage) {
		this.crewImage = crewImage;
	}
}
