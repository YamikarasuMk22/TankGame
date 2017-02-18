package com.tankgame.objects;

import java.awt.image.BufferedImage;

public class Unit {

	// ユニットID
    private int ID;
	// ユニットタイプ
    private int type;
    // オブジェクトタイプ
    private int objectType;
    // ユニット名
    private String name;
    // ユニット説明文ID
    private String description;

    //TODO 走行性・視認距離・視認性・通信範囲・口径・射程距離・重量・クリティカル率・跳弾率・砲撃回数/ターン
    //TODO パラメータはKey,Valueで管理する？

	/** ユニットパラメータ(絶対値) **/
    // 0:攻撃力 1:前面防御力 2:側面防御力 3:背面防御力 4:耐久力 5:機動性(移動範囲)
    private int[] baseParams;

    /** UI情報 **/
    // ユニットイメージ
    private BufferedImage image;

    public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getType() {
        return type;
    }

    public void setType(int Type) {
        this.type = Type;
    }

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

	public int[] getBaseParams() {
		return baseParams;
	}

	public void setBaseParams(int[] BaseParams) {
		this.baseParams = BaseParams;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage Image) {
		this.image = Image;
	}
}
