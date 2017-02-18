package com.tankgame.objects;

import java.awt.image.BufferedImage;
import java.util.Map;

import com.tankgame.common.Common;
import com.tankgame.thread.AnimationThread;
import com.tankgame.util.ImageUtil;

public class UnitDetail implements Common {

    /** ユニット基本情報 **/
	/** TODO cfg → unitObjオブジェクトにロード → 描画時はUnitオブジェクトに呼び出し？ **/
    // ユニットID
    private int ID;
    // ユニット基本情報
    private Unit unitObj;

    // 所属部隊ID
    private int divisionID;
    // 乗員IDリスト
    private int[] crewIDs;
    // 士気
    private int morale;
    // 練度
    private int duration;

    // 装備IDリスト
    // 0:砲身ID 1:前面装甲ID 2:側面装甲ID 3:背面装甲ID 4:エンジンID 5:履帯ID
    private int[] moduleIDs;
    // 弾頭IDリスト
    // 0:AP弾頭 1:HE弾頭
    // private int[] unitShellIDs;

    /** ユニットパラメータ(補正値) **/
    // 0:攻撃力 1:前面防御力 2:側面防御力 3:背面防御力 4:耐久力 5:機動性(移動範囲)
    private int[] params;

    /** ユニット状態情報 TODO オブジェクト分ける？ **/
    // 座標
    private int x, y; // 単位：マス
    private int px, py; // 単位：ピクセル
    // 向いている方向（LEFT,RIGHT,UP,DOWNのどれか）
    private int direction;
    // 移動中（スクロール中）か
    private boolean isMoving;
    // 移動中の場合の移動ピクセル数
    private int movingLength;
    // 移動方法
    private int moveType;

    /** UI情報 **/
    // ユニットイメージ(マップ描画用)
    private BufferedImage unitMapImage;
    // アニメーションカウンタ
    public static int count = 0;
    // アニメーション用スレッド
    private Thread threadAnime;
    // マップへの参照
    private Map map;

    // 最小
    public UnitDetail(Unit unitObj) {
        this.ID = unitObj.getID();
    }

    // 情報のみ
    public UnitDetail(Unit unitObj, int divisionID, int[] unitCrewIDs, int[] unitModuleIDs) {
    	this.ID = unitObj.getID();
        this.divisionID = divisionID;
        this.crewIDs = unitCrewIDs;
        this.moduleIDs = unitModuleIDs;
    }

    // フル
    public UnitDetail(Unit unitObj, int divisionID, int[] unitCrewIDs, int[] unitModuleIDs,
            int unitMorale, int unitDuration, int x, int y, int direction, int moveType, Map map) {
    	this.ID = unitObj.getID();
        this.divisionID = divisionID;
        this.crewIDs = unitCrewIDs;
        this.moduleIDs = unitModuleIDs;

        this.x = x;
        this.y = y;

        this.px = x * CS;
        this.py = y * CS;

        this.direction = direction;
        this.moveType = moveType;
        this.map = map;

        // 初回の呼び出しのみイメージをロード
        if (unitMapImage == null) {
            ImageUtil.loadImage();
        }

        // ユニットアニメーション用スレッド開始
        threadAnime = new Thread(new AnimationThread());
        threadAnime.start();
    }

    public int getUnitID() {
        return ID;
    }

    public void setUnitID(int unitID) {
        this.ID = unitID;
    }

    public int getUnitMorale() {
		return morale;
	}

	public void setUnitMorale(int unitMorale) {
		this.morale = unitMorale;
	}

	public int getUnitDuration() {
		return duration;
	}

	public void setUnitDuration(int unitDuration) {
		this.duration = unitDuration;
	}

	public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public int[] getUnitCrewIDs() {
        return crewIDs;
    }

    public void setUnitCrewIDs(int[] unitCrewIDs) {
        this.crewIDs = unitCrewIDs;
    }

    public Unit getUnitParam() {
		return unitObj;
	}

	public void setUnitParam(Unit unitObj) {
		this.unitObj = unitObj;
	}

	public int[] getUnitModuleIDs() {
        return moduleIDs;
    }

    public void setUnitModuleIDs(int[] unitModuleIDs) {
        this.moduleIDs = unitModuleIDs;
    }

    public int[] getUnitParams() {
		return params;
	}

	public void setUnitParams(int[] params) {
		this.params = params;
	}

	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean flag) {
        isMoving = flag;
        // 移動距離を初期化
        movingLength = 0;
    }

    public int getMovingLength() {
        return movingLength;
    }

    public int getMoveType() {
        return moveType;
    }
}
