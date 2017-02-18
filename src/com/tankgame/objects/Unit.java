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
    private String descriptionID;

	/** ユニットパラメータ(絶対値) **/
    // 0:攻撃力 1:前面防御力 2:側面防御力 3:背面防御力 4:耐久力 5:機動性(移動範囲)
    private int[] baseParams;

    /** UI情報 **/
    // ユニットイメージ
    private BufferedImage image;

//    // 攻撃力
//    private static int AttackPoint;
//    // 前面防御力
//    private static int FrontArmorPoint;
//    // 側面防御力
//    private static int SideArmorPoint;
//    // 背面防御力
//    private static int BackArmorPoint;
//    // 耐久力
//    private static int HitPoint;
//    // 機動性(移動範囲)
//    private static int MoveLenght;

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

    public String getDescriptionID() {
        return descriptionID;
    }

    public void setDescriptionID(String DescriptionID) {
        this.descriptionID = DescriptionID;
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

//    public static int getAttackPoint() {
//        return Param.AttackPoint;
//    }
//
//    public static void setAttackPoint(int AttackPoint) {
//    	Param.AttackPoint = AttackPoint;
//    }
//
//    public static int getFrontArmorPoint() {
//        return Param.FrontArmorPoint;
//    }
//
//    public static void setFrontArmorPoint(int FrontArmorPoint) {
//        Param.FrontArmorPoint = FrontArmorPoint;
//    }
//
//    public static int getSideArmorPoint() {
//        return Param.SideArmorPoint;
//    }
//
//    public static void setSideArmorPoint(int SideArmorPoint) {
//        Param.SideArmorPoint = SideArmorPoint;
//    }
//
//    public static int getBackArmorPoint() {
//        return Param.BackArmorPoint;
//    }
//
//    public static void setBackArmorPoint(int BackArmorPoint) {
//        Param.BackArmorPoint = BackArmorPoint;
//    }
//
//    public static int getHitPoint() {
//        return Param.HitPoint;
//    }
//
//    public static void setHitPoint(int HitPoint) {
//        Param.HitPoint = HitPoint;
//    }
//
//    public static int getMoveLenght() {
//        return Param.MoveLenght;
//    }
//
//    public static void setMoveLenght(int MoveLenght) {
//        Param.MoveLenght = MoveLenght;
//    }

}
