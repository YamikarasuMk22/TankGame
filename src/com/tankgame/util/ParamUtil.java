package com.tankgame.util;

import java.util.HashMap;

import com.tankgame.common.CommonParams;
import com.tankgame.object.UnitDetail;

public class ParamUtil extends CommonParams {

	public HashMap<String, Integer> calculateParams(UnitDetail unit) {

		int[] moduleIDs;
		int[] crewIDs;

		moduleIDs = unit.getUnitModuleIDs();
		crewIDs = unit.getUnitCrewIDs();

		return null;
	}

	//指揮官階級から各種補正値を算出 TODO

	//乗員階級から各種補正値を算出 TODO

	//乗員士気から各種補正値を算出 TODO

	//能力IDリストから各種補正値を算出 TODO
}
