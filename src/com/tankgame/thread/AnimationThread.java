package com.tankgame.thread;

import com.tankgame.objects.Unit;

public class AnimationThread extends Thread {

    public void run() {
        while (true) {
            // countを切り替える
            if (Unit.count == 0) {
                Unit.count = 1;
            } else if (Unit.count == 1) {
                Unit.count = 0;
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
