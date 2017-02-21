package com.tankgame.object;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import com.tankgame.common.Common;
import com.tankgame.thread.AnimationThread;
import com.tankgame.util.ImageUtil;

public class UnitDetail implements Common {

	/** ユニット基本情報 **/
	/** TODO cfg → Unitオブジェクトにロード → 描画時はUnitDetailオブジェクトに呼び出し？ **/
	// 描画ユニットID
	private int drawID;
	// ユニットID
	private int ID;
	// ユニットタイプ
	private int type;
	// オブジェクトタイプ
	private int objectType;
	// ユニット名
	private String name;
	// 所属部隊ID
	private int divisionID;
	// 乗員IDリスト
	private int[] crewIDs;
	// 士気
	private int morale;
	// 練度
	private int duration;

	// TODO 行動不能フラグ

	// 装備IDリスト
	// 0:砲身ID 1:前面装甲ID 2:側面装甲ID 3:背面装甲ID 4:エンジンID 5:履帯ID
	private int[] moduleIDs;
	// 弾頭IDリスト
	// 0:AP弾頭 1:HE弾頭
	// private int[] unitShellIDs;

	/** ユニットパラメータ(計算値) **/
	// Attack:攻撃力 FrontArmor:前面防御力 SideArmor:側面防御力 BackArmor:背面防御力 HitPoint:耐久力
	// AttackRange:射程範囲 MoveRange:移動範囲 ViewRange:視認範囲 StealthRange:視認性 SignalRange:通信範囲
	// CriticalRate:クリティカル率 AvoidRate:回避率 AttackPerTurn:砲撃回数/ターン
	private HashMap<String, Integer> params;

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
	public UnitDetail(Unit unitObj, int divisionID, int[] unitCrewIDs, int[] unitModuleIDs, int unitMorale,
			int unitDuration, int x, int y, int direction, int moveType, Map map) {
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

	public int getDrawID() {
		return drawID;
	}

	public void setDrawID(int drawID) {
		this.drawID = drawID;
	}

	public int getUnitID() {
		return ID;
	}

	public void setUnitID(int unitID) {
		this.ID = unitID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public void setName(String name) {
		this.name = name;
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

	public int[] getUnitModuleIDs() {
		return moduleIDs;
	}

	public void setUnitModuleIDs(int[] unitModuleIDs) {
		this.moduleIDs = unitModuleIDs;
	}

	public HashMap<String, Integer> getUnitParams() {
		return params;
	}

	public void setUnitParams(HashMap<String, Integer> params) {
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
