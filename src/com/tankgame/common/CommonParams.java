package com.tankgame.common;

/**
 * ゲーム内のHashMap型パラメータのKey値を定義するクラス
 *
 * @author YamikarasuMk22
 */
public interface CommonParams {
	// ユニットパラメータ
	// Attack:攻撃力 FrontArmor:前面防御力 SideArmor:側面防御力 BackArmor:背面防御力 HitPoint:耐久力
	// AttackRange:射程範囲 MoveRange:移動範囲 ViewRange:視認範囲 StealthRange:視認性 SignalRange:通信範囲
	// CriticalRate:クリティカル率 AvoidRate:回避率 ShotPerAttack:砲撃回数/ターン

	/**Attack:攻撃力<br>
	 * ValueはInteger型 */
	static String Attack = "Attack";

	/**FrontArmor:前面防御力<br>
	 * ValueはInteger型 */
	static String FrontArmor = "FrontArmor";

	/**SideArmor:側面防御力<br>
	 * ValueはInteger型 */
	static String SideArmor = "SideArmor";

	/**BackArmor:背面防御力<br>
	 * ValueはInteger型 */
	static String BackArmor = "BackArmor";

	/**HitPoint:耐久力<br>
	 * ValueはInteger型 */
	static String HitPoint = "HitPoint";

	/**AttackRange:射程範囲<br>
	 * ValueはInteger型<br>
	 * ユニットの射程範囲をタイル数単位で格納する */
	static String AttackRange = "AttackRange";

	/**MoveRange:移動範囲<br>
	 * ValueはInteger型<br>
	 * ユニットの移動範囲をタイル数単位で格納する */
	static String MoveRange = "MoveRange";

	/**ViewRange:視認範囲<br>
	 * ValueはInteger型<br>
	 * ユニットの視認範囲をタイル数単位で格納する */
	static String ViewRange = "ViewRange";

	/**StealthRange:視認性<br>
	 * ValueはInteger型<br>
	 * ユニットに対する視認性をタイル数単位で格納する */
	static String StealthRange = "StealthRange";

	/**SignalRange:通信範囲<br>
	 * ValueはInteger型<br>
	 * ユニットの通信範囲をタイル数単位で格納する */
	static String SignalRange = "SignalRange";

	/**CriticalRate:クリティカル率<br>
	 * ValueはInteger型<br>
	 * クリティカル率を％単位で格納する */
	static String CriticalRate = "CriticalRate";

	/** AvoidRate:回避率
	 * ValueはInteger型<br>
	 * 回避率を％単位で格納する */
	static String AvoidRate = "AvoidRate";

	/** ShotPerAttack:砲撃回数/ターン
	 * ValueはInteger型<br>
	 * 一度の攻撃で射撃する回数を格納する */
	static String ShotPerAttack = "ShotPerAttack";

	static String[] ALL_PARAMS = { Attack, FrontArmor, SideArmor, BackArmor, HitPoint, AttackRange, MoveRange,
			ViewRange, StealthRange, SignalRange, CriticalRate, AvoidRate, ShotPerAttack };
}
