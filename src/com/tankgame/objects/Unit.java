package com.tankgame.objects;

import java.awt.image.BufferedImage;
import java.util.Map;

import com.tankgame.common.Common;
import com.tankgame.thread.AnimationThread;
import com.tankgame.util.ImageUtil;

public class Unit implements Common {

    /** ユニット基本情報 **/
	/** TODO cfg → UnitDataオブジェクトにロード → 描画時はUnitオブジェクトに呼び出し？ **/
    // ユニットID
    private int unitID;
    // ユニット基本情報
    private UnitData unitData;

    // 所属部隊ID
    private int divisionID;
    // 乗員IDリスト
    private int[] unitCrewIDs;
    // 士気
    private int unitMorale;
    // 練度
    private int unitDuration;

    // 装備IDリスト
    // 0:砲身ID 1:前面装甲ID 2:側面装甲ID 3:背面装甲ID 4:エンジンID 5:履帯ID
    private int[] unitModuleIDs;
    // 弾頭IDリスト
    // 0:AP弾頭 1:HE弾頭
    // private int[] unitShellIDs;

    /** ユニットパラメータ(補正値) **/
    // 0:攻撃力 1:前面防御力 2:側面防御力 3:背面防御力 4:耐久力 5:機動性(移動範囲)
    private static int[] unitParams;

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
    // イメージ
    private BufferedImage unitImage;
    // アニメーションカウンタ
    public static int count = 0;
    // アニメーション用スレッド
    private Thread threadAnime;
    // マップへの参照
    private Map map;

    // 最小
    public Unit(UnitData unitData) {
        this.unitID = unitData.getUnitID();
    }

    // 情報のみ
    public Unit(UnitData unitData, int divisionID, int[] unitCrewIDs, int[] unitModuleIDs) {
    	this.unitID = unitData.getUnitID();
        this.divisionID = divisionID;
        this.unitCrewIDs = unitCrewIDs;
        this.unitModuleIDs = unitModuleIDs;
    }

    // フル
    public Unit(UnitData unitData, int divisionID, int[] unitCrewIDs, int[] unitModuleIDs,
            int unitMorale, int unitDuration, int x, int y, int direction, int moveType, Map map) {
    	this.unitID = unitData.getUnitID();
        this.divisionID = divisionID;
        this.unitCrewIDs = unitCrewIDs;
        this.unitModuleIDs = unitModuleIDs;

        this.x = x;
        this.y = y;

        this.px = x * CS;
        this.py = y * CS;

        this.direction = direction;
        this.moveType = moveType;
        this.map = map;

        // 初回の呼び出しのみイメージをロード
        if (unitImage == null) {
            ImageUtil.loadImage();
        }

        // ユニットアニメーション用スレッド開始
        threadAnime = new Thread(new AnimationThread());
        threadAnime.start();
    }

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public int getUnitMorale() {
		return unitMorale;
	}

	public void setUnitMorale(int unitMorale) {
		this.unitMorale = unitMorale;
	}

	public int getUnitDuration() {
		return unitDuration;
	}

	public void setUnitDuration(int unitDuration) {
		this.unitDuration = unitDuration;
	}

	public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public int[] getUnitCrewIDs() {
        return unitCrewIDs;
    }

    public void setUnitCrewIDs(int[] unitCrewIDs) {
        this.unitCrewIDs = unitCrewIDs;
    }

    public UnitData getUnitParam() {
		return unitData;
	}

	public void setUnitParam(UnitData unitParam) {
		this.unitData = unitParam;
	}

	public int[] getUnitModuleIDs() {
        return unitModuleIDs;
    }

    public void setUnitModuleIDs(int[] unitModuleIDs) {
        this.unitModuleIDs = unitModuleIDs;
    }

    public static int[] getUnitParams() {
		return unitParams;
	}

	public static void setUnitParams(int[] unitParams) {
		Unit.unitParams = unitParams;
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

    /**
     * 移動処理。
     *
     * @return 1マス移動が完了したらtrueを返す。移動中はfalseを返す。
     * TODO 操作系はクラス分けする
     */
    public boolean move() {
        switch (direction) {
        case LEFT:
            if (moveLeft()) {
                // 移動が完了した
                return true;
            }
            break;
        case RIGHT:
            if (moveRight()) {
                // 移動が完了した
                return true;
            }
            break;
        case UP:
            if (moveUp()) {
                // 移動が完了した
                return true;
            }
            break;
        case DOWN:
            if (moveDown()) {
                // 移動が完了した
                return true;
            }
            break;
        }

        // 移動が完了していない
        return false;
    }

    /**
     * 左へ移動する。
     *
     * @return 1マス移動が完了したらtrueを返す。移動中はfalseを返す。
     */
    private boolean moveLeft() {
        // 1マス先の座標
        int nextX = x - 1;
        int nextY = y;
        if (nextX < 0) {
            nextX = 0;
        }
        // // その場所に障害物がなければ移動を開始
        // if (!map.isHit(nextX, nextY)) {
        // // SPEEDピクセル分移動
        // px -= TankUnit.SPEED_PER_PX;
        // if (px < 0) {
        // px = 0;
        // }
        // // 移動距離を加算
        // movingLength += Unit.SPEED_PER_PX;
        // // 移動が1マス分を超えていたら
        // if (movingLength >= CS) {
        // // 移動する
        // x--;
        // px = x * CS;
        // // 移動が完了
        // isMoving = false;
        // return true;
        // }
        // } else {
        // isMoving = false;
        // // 元の位置に戻す
        // px = x * CS;
        // py = y * CS;
        // }

        return false;
    }

    /**
     * 右へ移動する。
     *
     * @return 1マス移動が完了したらtrueを返す。移動中はfalseを返す。
     */
    private boolean moveRight() {
        // 1マス先の座標
        int nextX = x + 1;
        int nextY = y;
        // if (nextX > map.getCol() - 1) {
        // nextX = map.getCol() - 1;
        // }
        // // その場所に障害物がなければ移動を開始
        // if (!map.isHit(nextX, nextY)) {
        // // SPEEDピクセル分移動
        // px += Unit.SPEED_PER_PX;
        // if (px > map.getWidth() - CS) {
        // px = map.getWidth() - CS;
        // }
        // // 移動距離を加算
        // movingLength += Unit.SPEED_PER_PX;
        // // 移動が1マス分を超えていたら
        // if (movingLength >= CS) {
        // // 移動する
        // x++;
        // px = x * CS;
        // // 移動が完了
        // isMoving = false;
        // return true;
        // }
        // } else {
        // isMoving = false;
        // px = x * CS;
        // py = y * CS;
        // }

        return false;
    }

    /**
     * 上へ移動する。
     *
     * @return 1マス移動が完了したらtrueを返す。移動中はfalseを返す。
     */
    private boolean moveUp() {
        // 1マス先の座標
        int nextX = x;
        int nextY = y - 1;
        if (nextY < 0) {
            nextY = 0;
        }
        // // その場所に障害物がなければ移動を開始
        // if (!map.isHit(nextX, nextY)) {
        // // SPEEDピクセル分移動
        // py -= Unit.SPEED_PER_PX;
        // if (py < 0)
        // py = 0;
        // // 移動距離を加算
        // movingLength += Unit.SPEED_PER_PX;
        // // 移動が1マス分を超えていたら
        // if (movingLength >= CS) {
        // // 移動する
        // y--;
        // py = y * CS;
        // // 移動が完了
        // isMoving = false;
        // return true;
        // }
        // } else {
        // isMoving = false;
        // px = x * CS;
        // py = y * CS;
        // }
        //
        return false;
    }

    /**
     * 下へ移動する。
     *
     * @return 1マス移動が完了したらtrueを返す。移動中はfalseを返す。
     */
    private boolean moveDown() {
        // 1マス先の座標
        int nextX = x;
        int nextY = y + 1;
        // if (nextY > map.getRow() - 1) {
        // nextY = map.getRow() - 1;
        // }
        // // その場所に障害物がなければ移動を開始
        // if (!map.isHit(nextX, nextY)) {
        // // SPEEDピクセル分移動
        // py += Unit.SPEED_PER_PX;
        // if (py > map.getHeight() - CS) {
        // py = map.getHeight() - CS;
        // }
        // // 移動距離を加算
        // movingLength += Unit.SPEED_PER_PX;
        // // 移動が1マス分を超えていたら
        // if (movingLength >= CS) {
        // // 移動する
        // y++;
        // py = y * CS;
        // // 移動が完了
        // isMoving = false;
        // return true;
        // }
        // } else {
        // isMoving = false;
        // px = x * CS;
        // py = y * CS;
        // }

        return false;
    }
}
