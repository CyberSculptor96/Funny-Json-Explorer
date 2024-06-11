package com.fje.factoryMethod;

import com.fje.builder.Builder;
import com.fje.composite.Container;
import com.fje.composite.Leaf;

/**
 * ConcreteNodeFactory 类使用了工厂方法设计模式
 * 该类实现了抽象方法 createProduct，使用建造者模式创建具体的 Node 对象
 */
public class ConcreteNodeFactory extends NodeFactory {
    @Override
    public Node createProduct(Container container, Leaf leaf) {
        Builder builder = new Builder();
        builder.buildContainer(container)
                .buildLeaf(leaf);

        return builder.getResult();
    }
}
