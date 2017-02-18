package com.tankgame.thread;

import com.tankgame.objects.UnitDetail;

public class AnimationThread extends Thread {

    public void run() {
        while (true) {
            // countを切り替える
            if (UnitDetail.count == 0) {
                UnitDetail.count = 1;
            } else if (UnitDetail.count == 1) {
                UnitDetail.count = 0;
            }

            // 300ミリ秒休止＝300ミリ秒おきにユニットの絵を切り替える
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
