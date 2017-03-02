package com.tankgame.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.tankgame.common.Common;
import com.tankgame.common.CommonParams;
import com.tankgame.fileio.FileIO;
import com.tankgame.object.Unit;

/**
 * Unitオブジェクトに対する処理を行うクラス
 *
 * @author YamikarasuMk22
 */
public class UnitUtil extends FileIO implements Common, CommonParams {
	/**
	 * assetファイル・cfgファイルを読込みUnitオブジェクトのリストを作成する<br>
	 *
	 * @return Unitオブジェクトリスト
	 */
	public List<Unit> loadUnitObjects() {
		Unit unit;
		List<Unit> units = new ArrayList<Unit>();
		HashMap<String, File> unitAssetAttr;
		HashMap<String, String> unitConfigAttr;

		unitAssetAttr = getAssetAttr(new File(UNIT_ASSET));

		for (File unitCfgFile : unitAssetAttr.values()) {
			unitConfigAttr = getConfigAttr(unitCfgFile);

			unit = createUnitObjectByAttr(unitConfigAttr);

			units.add(unit);
		}
		return units;
	}

	/**
	 * cfgファイルの属性を読込みUnitオブジェクトを作成する<br>
	 *
	 * @param configAttr cfgファイルの属性情報(HashMap)
	 * @return Unitオブジェクト
	 */
	public Unit createUnitObjectByAttr(HashMap<String, String> configAttr) {
		Unit unit = new Unit();
		HashMap<String, Integer> baseParams = new HashMap<String, Integer>();
		int ID = 0;

		for (Entry<String, String> readAttr : configAttr.entrySet()) {
			ID++;

			String key = readAttr.getKey();
			String value = readAttr.getValue();

			//基本情報
			unit.setID(ID);
			if (key.equals("Name")) {
				unit.setName(value);
				continue;
			}
			if (key.equals("Type")) {
				unit.setObjectType(Integer.parseInt(value));
				continue;
			}
			if (key.equals("UnitType")) {
				unit.setType(Integer.parseInt(value));
				continue;
			}
			if (key.equals("Description")) {
				unit.setDescription(value);
				continue;
			}

			//パラメータ
			for (int i = 0; i < ALL_PARAMS.length; i++) {
				if (key.equals(ALL_PARAMS[i])) {
					baseParams.put(key, Integer.parseInt(value));
					continue;
				}
			}
		}

		//パラメータ登録
		unit.setBaseParams(baseParams);

		return unit;
	}

	//ユニットタイプ・オブジェクトタイプから絶対攻撃力を取得 TODO

	//ユニットタイプ・オブジェクトタイプから絶対耐久力を取得 TODO

	//ユニットタイプ・オブジェクトタイプから絶対防御力を取得 TODO

	//ユニットタイプ・オブジェクトタイプから絶対機動性を取得 TODO

	//ユニットタイプ・オブジェクトタイプから各種絶対値を取得 TODO

	//乗員IDリストから練度を算出 TODO

	//乗員IDリストからユニット詳細情報を補正 TODO

	//装備IDリストからユニット詳細情報を補正 TODO

	//ユニット説明文IDから説明文を取得 TODO
}
