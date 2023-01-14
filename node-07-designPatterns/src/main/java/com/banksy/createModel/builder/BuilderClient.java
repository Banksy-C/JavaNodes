package com.banksy.createModel.builder;

/**
 * 建造者模式：
 * Separate the construction of a complex object from its representation so that the same construction process can create different representations.
 * 又叫生成器模式；将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以构建不同的表示
 *
 * 优点：封装性【不必须知道每一个具体的模型内部是如何实现的】；
 *      建造者独立、容易扩展；
 *      便于控制细节风险【具体的建造者是独立的， 因此可以对建造过程逐步细化，而不会对其他的模块产生任何影响】；
 * 适用场景：相同方法，不同执行顺序，产生不同事件结果；
 *          多个部件或零件， 都可以装配到一个对象中， 但是产生的运行结果又不相同；
 *          产品类非常复杂， 或者产品类中的调用顺序不同产生了不同的效能；
 *
 * 注意：建造者模式关注的是顺序，这是和工厂模式最大的不同
 *
 * @author banksy
 **/
public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.getProduct();
        product.doSomething();
    }
}

//导演类：起到封装的作用，避免高层模块深入到建造者内部的实现类
class Director {
    private AbstractBuilder concreteBuilder = new ConcreteBuilder();
    public Product getProduct() {
        concreteBuilder.setPart();
        return concreteBuilder.buildProduct();
    }
}

//抽象建造者
abstract class AbstractBuilder {
    //设置产品的不同部分，以获得不同的产品
    public abstract void setPart();
    //建造产品
    public abstract Product buildProduct();
}

//具体建造者
class ConcreteBuilder extends AbstractBuilder {
    private Product product = new Product();

    @Override
    public void setPart() {

    }

    @Override
    public Product buildProduct() {
        return product;
    }
}

//产品类
class Product {
    public void doSomething() {
        System.out.println("产品类......");
    }
}
