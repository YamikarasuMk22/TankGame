package com.tankgame.objects;

public class UnitData {

	// ユニットID
    private int unitID;
	// ユニットタイプ
    private int unitType;
    // オブジェクトタイプ
    private int objectType;
    // ユニット名
    private String unitName;
    // ユニット説明文ID
    private String unitDescriptionID;

	/** ユニットパラメータ(絶対値) **/
    // 0:攻撃力 1:前面防御力 2:側面防御力 3:背面防御力 4:耐久力 5:機動性(移動範囲)
    private static int[] unitBaseParams;

//    // 攻撃力
//    private static int unitAttackPoint;
//    // 前面防御力
//    private static int unitFrontArmorPoint;
//    // 側面防御力
//    private static int unitSideArmorPoint;
//    // 背面防御力
//    private static int unitBackArmorPoint;
//    // 耐久力
//    private static int unitHitPoint;
//    // 機動性(移動範囲)
//    private static int unitMoveLenght;

    public int getUnitID() {
		return unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

	public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitDescriptionID() {
        return unitDescriptionID;
    }

    public void setUnitDescriptionID(String unitDescriptionID) {
        this.unitDescriptionID = unitDescriptionID;
    }

	public static int[] getUnitBaseParams() {
		return unitBaseParams;
	}

	public static void setUnitBaseParams(int[] unitBaseParams) {
		UnitData.unitBaseParams = unitBaseParams;
	}

//    public static int getUnitAttackPoint() {
//        return UnitParam.unitAttackPoint;
//    }
//
//    public static void setUnitAttackPoint(int unitAttackPoint) {
//    	UnitParam.unitAttackPoint = unitAttackPoint;
//    }
//
//    public static int getUnitFrontArmorPoint() {
//        return UnitParam.unitFrontArmorPoint;
//    }
//
//    public static void setUnitFrontArmorPoint(int unitFrontArmorPoint) {
//        UnitParam.unitFrontArmorPoint = unitFrontArmorPoint;
//    }
//
//    public static int getUnitSideArmorPoint() {
//        return UnitParam.unitSideArmorPoint;
//    }
//
//    public static void setUnitSideArmorPoint(int unitSideArmorPoint) {
//        UnitParam.unitSideArmorPoint = unitSideArmorPoint;
//    }
//
//    public static int getUnitBackArmorPoint() {
//        return UnitParam.unitBackArmorPoint;
//    }
//
//    public static void setUnitBackArmorPoint(int unitBackArmorPoint) {
//        UnitParam.unitBackArmorPoint = unitBackArmorPoint;
//    }
//
//    public static int getUnitHitPoint() {
//        return UnitParam.unitHitPoint;
//    }
//
//    public static void setUnitHitPoint(int unitHitPoint) {
//        UnitParam.unitHitPoint = unitHitPoint;
//    }
//
//    public static int getUnitMoveLenght() {
//        return UnitParam.unitMoveLenght;
//    }
//
//    public static void setUnitMoveLenght(int unitMoveLenght) {
//        UnitParam.unitMoveLenght = unitMoveLenght;
//    }

}
