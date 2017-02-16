package com.tanksister.objects;

import java.awt.image.BufferedImage;
import java.util.Map;

import com.tanksister.common.Common;
import com.tanksister.thread.AnimationThread;
import com.tanksister.util.ImageUtil;

public class Unit implements Common {

    /** ユニット基本情報 **/
    // ユニットID
    private int unitID;
    // ユニットタイプ
    private int unitType;
    // オブジェクトタイプ
    private int objectType;
    // 所属部隊ID
    private int divisionID;
    // 乗員IDリスト
    private int[] unitCrewIDs;
    // ユニット名
    private String unitName;
    // ユニット説明文ID
    private String unitDescriptionID;

    /** ユニット詳細情報 TODO 絶対値 + 補正値 **/
    // 士気
    private int unitMorale;
    // 練度
    private int unitDuration;
    // 攻撃力
    private int unitAttackPoint;
    // 前面防御力
    private int unitFrontArmorPoint;
    // 側面防御力
    private int unitSideArmorPoint;
    // 背面防御力
    private int unitBackArmorPoint;
    // 耐久力
    private int unitHitPoint;
    // 機動性(移動範囲)
    private int unitMoveLenght;

    /** ユニット装備情報 **/
    // 装備IDリスト
    // 0:砲身ID 1:前面装甲ID 2:側面装甲ID 3:背面装甲ID 4:エンジンID 5:履帯ID
    private int[] unitModuleIDs;
    // 弾頭IDリスト
    // 0:AP弾頭 1:HE弾頭
    // private int[] unitShellIDs;

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
    public Unit(int unitID) {
        this.unitID = unitID;
    }

    // 情報のみ
    public Unit(int unitID, int unitType, int objectType, int divisionID, int[] unitCrewIDs,
            String unitName, String unitDescriptionID, int[] unitModuleIDs) {
        this.unitID = unitID;
        this.unitType = unitType;
        this.objectType = objectType;
        this.divisionID = divisionID;
        this.unitCrewIDs = unitCrewIDs;
        this.unitName = unitName;
        this.unitDescriptionID = unitDescriptionID;
        this.unitModuleIDs = unitModuleIDs;
    }

    // フル
    public Unit(int unitID, int unitType, int objectType, int divisionID, int[] unitCrewIDs,
            String unitName, String unitDescriptionID, int[] unitModuleIDs,
            int unitMorale, int unitDuration, int unitAttackPoint, int unitHitPoint,
            int unitFrontArmorPoint, int unitSideArmorPoint, int unitBackArmorPoint, int unitMoveLenght,
            int x, int y, int direction, int moveType, Map map) {
        this.unitID = unitID;
        this.unitType = unitType;
        this.objectType = objectType;
        this.divisionID = divisionID;
        this.unitCrewIDs = unitCrewIDs;
        this.unitName = unitName;
        this.unitDescriptionID = unitDescriptionID;
        this.unitModuleIDs = unitModuleIDs;

        this.unitMorale = unitMorale;
        this.unitDuration = unitDuration;
        this.unitAttackPoint = unitAttackPoint;
        this.unitHitPoint = unitHitPoint;
        this.unitFrontArmorPoint = unitFrontArmorPoint;
        this.unitSideArmorPoint = unitSideArmorPoint;
        this.unitBackArmorPoint = unitBackArmorPoint;
        this.unitMoveLenght = unitMoveLenght;

        this.x = x;
        this.y = y;

        this.px = x * CS;
        this.py = y * CS;

        this.unitID = unitID;
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

    public int getUnitAttackPoint() {
        return unitAttackPoint;
    }

    public void setUnitAttackPoint(int unitAttackPoint) {
        this.unitAttackPoint = unitAttackPoint;
    }

    public int getUnitFrontArmorPoint() {
        return unitFrontArmorPoint;
    }

    public void setUnitFrontArmorPoint(int unitFrontArmorPoint) {
        this.unitFrontArmorPoint = unitFrontArmorPoint;
    }

    public int getUnitSideArmorPoint() {
        return unitSideArmorPoint;
    }

    public void setUnitSideArmorPoint(int unitSideArmorPoint) {
        this.unitSideArmorPoint = unitSideArmorPoint;
    }

    public int getUnitBackArmorPoint() {
        return unitBackArmorPoint;
    }

    public void setUnitBackArmorPoint(int unitBackArmorPoint) {
        this.unitBackArmorPoint = unitBackArmorPoint;
    }

    public int getUnitHitPoint() {
        return unitHitPoint;
    }

    public void setUnitHitPoint(int unitHitPoint) {
        this.unitHitPoint = unitHitPoint;
    }

    public int getUnitMoveLenght() {
        return unitMoveLenght;
    }

    public void setUnitMoveLenght(int unitMoveLenght) {
        this.unitMoveLenght = unitMoveLenght;
    }

    public int[] getUnitModuleIDs() {
        return unitModuleIDs;
    }

    public void setUnitModuleIDs(int[] unitModuleIDs) {
        this.unitModuleIDs = unitModuleIDs;
    }

    /**
     * 移動処理。
     *
     * @return 1マス移動が完了したらtrueを返す。移動中はfalseを返す。
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
