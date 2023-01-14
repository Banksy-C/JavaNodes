package com.banksy.createModel.builder;

import java.util.ArrayList;

/**
 * 建造者模式 + 模版方法模式
 * @author banksy
 **/
public class BuilderPlus {
    public static void main(String[] args) {
        BuilderPlusDirector director = new BuilderPlusDirector();
        director.getBenzModelA().run();
        director.getBMWModelB().run();
    }
}

//导演类，负责安排顺序
class BuilderPlusDirector {
    private ArrayList<String> sequence = new ArrayList<>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();

    public BenzModel getBenzModelA() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("engineBoom");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }
    public BenzModel getBenzModelB() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BMWModel getBMWModelA() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("engineBoom");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();

    }
    public BMWModel getBMWModelB() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }
}

//抽象类，建造者
abstract class CarBuilder {
    //建造一个模型，传入顺序
    public abstract void setSequence(ArrayList<String> sequence);
    //根据上面的顺序可拿到模型
    public abstract CarModel getCarModel();
}
class BenzBuilder extends CarBuilder {
    private BenzModel benz = new BenzModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benz;
    }
}
class BMWBuilder extends CarBuilder {
    private BMWModel bmw = new BMWModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmw;
    }
}


//抽象类，模版方法模式
abstract class CarModel {
    private ArrayList<String> sequence = new ArrayList<>();
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineBoom();
    //模版模型
    public final void run() {
        for (int i = 0; i < this.sequence.size(); i++) {
            String actionName = this.sequence.get(i);
            if (actionName.equalsIgnoreCase("start")){//忽略大小写
                this.start();
            }
            if (actionName.equalsIgnoreCase("stop")){
                this.stop();
            }
            if (actionName.equalsIgnoreCase("alarm")){
                this.alarm();
            }
            if (actionName.equalsIgnoreCase("engineBoom")){
                this.engineBoom();
            }
        }
    }

    public final void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("奔驰发动......");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰熄火......");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰鸣笛......");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰引擎声......");
    }
}
class BMWModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("宝马发动......");
    }

    @Override
    protected void stop() {
        System.out.println("宝马熄火......");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马鸣笛......");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马引擎声......");
    }
}