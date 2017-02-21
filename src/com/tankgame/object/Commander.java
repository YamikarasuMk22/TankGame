package com.tankgame.object;

import java.awt.image.BufferedImage;

public class Commander {

	/** 指揮官基本情報 **/
	// 指揮官ID
	private int ID;
	// 指揮官名
	private String name;
	// 指揮官説明文ID
	private int description;
	// 所属部隊ID
	private int divisionID;
	// 階級ID
	private int gradeID;

	/** 指揮官パラメータ **/
	// 能力IDリスト
	private int[] abilityIDs;
	// カリスマ
	private int charisma;
	// 統率
	private int leadership;
	// 名声
	private int fame;

	/** UI情報 **/
	// イメージ
	private BufferedImage image;
}
