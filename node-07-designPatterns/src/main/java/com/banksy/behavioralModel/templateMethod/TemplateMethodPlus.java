package com.banksy.behavioralModel.templateMethod;

/**
 * @author banksy
 **/
public class TemplateMethodPlus {
    public static void main(String[] args) {
        HummerH1Model h1 = new HummerH1Model();
        h1.setAlarmFlag(false);
        h1.run();
    }
}


abstract class HummerModel {
    //发动
    protected abstract void start();
    //熄火
    protected abstract void stop();
    //鸣笛
    protected abstract void alarm();
    //引擎声
    protected abstract void engineBoom();
    final public void run() {
        //发动汽车
        this.start();
        //引擎声
        this.engineBoom();
        //是否鸣笛
        if (this.isAlarm()) {
            this.alarm();
        }
        //熄火
        this.stop();
    }
    //钩子方法，默认喇叭是响的
    protected boolean isAlarm() {
        return true;
    }

}

class HummerH1Model extends HummerModel {
    private boolean alarmFlag = true; //喇叭响
    @Override
    protected void start() {
        System.out.println("悍马H1发动......");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H1熄火......");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H1鸣笛......");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马H1引擎声......");
    }

    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    public void setAlarmFlag(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
}

class HummerH2Model extends HummerModel {
    @Override
    protected void start() {
        System.out.println("悍马H2发动......");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H2熄火......");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H2鸣笛......");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马H2引擎声......");
    }
    protected boolean isAlarm() {
        return false;
    }

}


