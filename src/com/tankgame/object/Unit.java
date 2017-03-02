package com.tankgame.object;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Unitオブジェクト (cfgファイルベース)
 *
 * @author YamikarasuMk22
 */
public class Unit {

	/**ユニットID */
	private int ID;
	/**ユニットタイプ */
	private int type;
	/**オブジェクトタイプ */
	private int objectType;
	/**ユニット名 */
	private String name;
	/**ユニット説明文 */
	private String description;

	/** ユニットパラメータ(絶対値) **/
	// Attack:攻撃力 FrontArmor:前面防御力 SideArmor:側面防御力 BackArmor:背面防御力 HitPoint:耐久力
	// AttackRange:射程範囲 MoveRange:移動範囲 ViewRange:視認範囲 StealthRange:視認性 SignalRange:通信範囲
	// CriticalRate:クリティカル率 AvoidRate:回避率 ShotPerAttack:砲撃回数/ターン
	private HashMap<String, Integer> baseParams;

	/** UI情報 **/
	// ユニットイメージ
	private BufferedImage image;

	/**ユニットID Getter<br>
	 * cfgファイル読み取り順(連番) */
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	/**ユニットタイプ Getter<br>
	 * LightTank:	軽戦車	int:0<br>
	 * MediumTank:	中戦車	int:1<br>
	 * HeavyTank:	重戦車	int:2 */
	public int getType() {
		return type;
	}

	/**ユニットタイプ Setter<br>
	 * LightTank:	軽戦車	int:0<br>
	 * MediumTank:	中戦車	int:1<br>
	 * HeavyTank:	重戦車	int:2 */
	public void setType(int Type) {
		this.type = Type;
	}

	/**オブジェクトタイプ Getter<br>
	 * TankUnit:		戦車ユニット			int:0<br>
	 * HQUnit:			指揮所(拠点)ユニット	int:1<br>
	 * RadarUnit:		レーダーユニット		int:2<br>
	 * MaintenanceUnit:	整備場ユニット			int:3 */
	public int getObjectType() {
		return objectType;
	}

	/**オブジェクトタイプ Setter<br>
	 * TankUnit:		戦車ユニット			int:0<br>
	 * HQUnit:			指揮所(拠点)ユニット	int:1<br>
	 * RadarUnit:		レーダーユニット		int:2<br>
	 * MaintenanceUnit:	整備場ユニット			int:3 */
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

	/** ユニットパラメータ(絶対値) Getter Keyは以下の通り<br>
	 *  Attack:攻撃力 FrontArmor:前面防御力 SideArmor:側面防御力 BackArmor:背面防御力 HitPoint:耐久力<br>
	 *  AttackRange:射程範囲 MoveRange:移動範囲 ViewRange:視認範囲 StealthRange:視認性 SignalRange:通信範囲<br>
	 *  CriticalRate:クリティカル率 AvoidRate:回避率 ShotPerAttack:砲撃回数/ターン */
	public HashMap<String, Integer> getBaseParams() {
		return baseParams;
	}

	/** ユニットパラメータ(絶対値) Setter Keyは以下の通り<br>
	 *  Attack:攻撃力 FrontArmor:前面防御力 SideArmor:側面防御力 BackArmor:背面防御力 HitPoint:耐久力<br>
	 *  AttackRange:射程範囲 MoveRange:移動範囲 ViewRange:視認範囲 StealthRange:視認性 SignalRange:通信範囲<br>
	 *  CriticalRate:クリティカル率 AvoidRate:回避率 ShotPerAttack:砲撃回数/ターン */
	public void setBaseParams(HashMap<String, Integer> BaseParams) {
		this.baseParams = BaseParams;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage Image) {
		this.image = Image;
	}
}
