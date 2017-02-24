package com.tankgame.util;

import com.tankgame.common.Common;
import com.tankgame.object.Commander;
import com.tankgame.object.Module;
import com.tankgame.object.Unit;
import com.tankgame.object.UnitDetail;

public class Util implements Common {

	public int switchByObject(Object obj) {
		int result = 0;

		if (obj instanceof Unit)
			return UNIT;
		if (obj instanceof UnitDetail)
			return UNIT_DETAIL;
		if (obj instanceof Module)
			return MODULE;
		if (obj instanceof Commander)
			return COMMANDER;

		return result;
	}
}
