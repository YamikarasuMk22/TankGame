package com.tankgame.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tankgame.common.Common;
import com.tankgame.object.Commander;
import com.tankgame.object.Module;
import com.tankgame.object.Unit;

//TODO assetは各フォルダの直下に移動する

/**
 * 物理ファイルのI/Oを行うクラス
 *
 * @author YamikarasuMk22
 */
public class FileIO implements Common {
	/**
	 * assetファイルに定義された属性の読み込みを行う<br>
	 * File="assetファイルパス"<br>
	 * の記述をHashMap(cfgファイル名, cfgファイルオブジェクト)にして返す
	 *
	 * @param asset 読み込むassetファイル
	 * @return Key:ファイル名 Value:ファイルオブジェクト
	 */
	public HashMap<String, File> getAssetAttr(File asset) {

		HashMap<String, File> assetAttr = new HashMap<String, File>();

		//「属性名="属性値"」の正規表現
		String AttrRegex = "(FILE|File|file) *= *\"(^[0-9a-zA-Z]+$)\"";

		try {
			String strReadText = "";
			BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(asset), "UTF-8"));

			while ((strReadText = read.readLine()) != null) {
				Pattern p = Pattern.compile(AttrRegex);
				Matcher m = p.matcher(strReadText);

				if (m.find()) {
					File cfgFile = new File(m.group(1));

					assetAttr.put(cfgFile.getName(), cfgFile);
				}
			}
			read.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return assetAttr;
	}

	/**
	 * configファイルに定義された属性の読み込みを行う<br>
	 * File="cfgファイルパス"<br>
	 * の記述をHashMap(cfgファイル名, cfgファイルオブジェクト)にして返す
	 *
	 * @param config 読み込むconfigファイル
	 * @return Key:属性名 Value:属性値
	 */
	public HashMap<String, File> getConfigAttr(File config) {

		HashMap<String, File> configAttr = new HashMap<String, File>();

		//「属性名="属性値"」の正規表現
		String AttrRegex = "(^[0-9a-zA-Z]+$) *= *\"(^[0-9a-zA-Z]+$)\"";

		try {
			String strReadText = "";
			BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(config), "UTF-8"));

			while ((strReadText = read.readLine()) != null) {
				Pattern p = Pattern.compile(AttrRegex);
				Matcher m = p.matcher(strReadText);

				if (m.find()) {
					File cfgFile = new File(m.group(1));

					configAttr.put(cfgFile.getName(), cfgFile);
				}
			}
			read.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return configAttr;
	}

	/**
	 * オブジェクトの型を判断してgetAssetAttrを実行
	 *
	 * @param obj paramが設定されているいずれかのオブジェクト
	 * @return Key:属性名 Value:属性値
	 */
	public HashMap<String, File> getAssetAttrByObj(Object obj) {
		if (obj instanceof Unit)
			return getAssetAttr(new File(UNIT_ASSET));
		if (obj instanceof Module)
			return getAssetAttr(new File(MODULE_ASSET));
		if (obj instanceof Commander)
			return getAssetAttr(new File(COMMANDER_ASSET));

		return null;
	}
}
