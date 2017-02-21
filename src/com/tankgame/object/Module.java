package com.tankgame.object;

import java.util.HashMap;

public class Module {

	// モジュールID
	private int ID;
	// モジュールタイプ
	private int type;
	// モジュール名
	private String name;
	// モジュール説明文ID
	private String description;

	// TODO 修理時間・破損フラグ(修理可/不可)

	/** ユニットパラメータ(絶対値) **/
	// Attack:攻撃力 FrontArmor:前面防御力 SideArmor:側面防御力 BackArmor:背面防御力 HitPoint:耐久力
	// AttackRange:射程範囲 MoveRange:移動範囲 ViewRange:視認範囲 StealthRange:視認性 SignalRange:通信範囲
	// CriticalRate:クリティカル率 AvoidRate:回避率 ShotPerAttack:砲撃回数/ターン
	private HashMap<String, Integer> baseParams;
}
