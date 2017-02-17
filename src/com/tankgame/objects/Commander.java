package com.tankgame.objects;

import java.awt.image.BufferedImage;

public class Commander {

	/** 指揮官基本情報 **/
	// 指揮官ID
    private int commanderID;
    // 指揮官名
    private String commanderName;
    // 指揮官説明文ID
    private int commanderDescriptionID;
    // 階級ID
    private int commanderGradeID;

    /** 指揮官パラメータ **/
    // 能力IDリスト
    private int[] commanderAbilityIDs;
    // カリスマ
    private int commanderCharisma;
    // 統率
    private int commanderLeadership;
    // 名声
    private int commanderFame;

    /** UI情報 **/
    // イメージ
    private BufferedImage commanderImage;
}
