package com.tankgame.common;

public interface Common {

	// ユニットパラメータアセット
	public static final String UNIT_ASSET = "Unit/Unit.asset";
	// 装備品パラメータアセット
	public static final String MODULE_ASSET = "Module/Module.asset";
	// 指揮官パラメータアセット
	public static final String COMMANDER_ASSET = "Commander/Commander.asset";
	// イメージアセット
	public static final String IMAGE_ASSET = "Image/Image.asset";
	// サウンドアセット
	public static final String SOUND_ASSET = "Sound/Sound.asset";

	// 方向を表す定数
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;

	// チップセットのサイズ（単位：ピクセル）
	public static final int CS = 32;
}
