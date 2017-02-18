package com.tankgame.objects;

public class Module {

	// モジュールID
    private int ID;
	// モジュールタイプ
    private int type;
    // モジュール名
    private String name;
    // モジュール説明文ID
    private String description;

	/** 装備品パラメータ(絶対値) **/
    // 0:攻撃力 1:前面防御力 2:側面防御力 3:背面防御力 4:耐久力 5:機動性(移動範囲)
    private int[] baseParams;
}
