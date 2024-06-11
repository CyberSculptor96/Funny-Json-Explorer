package com.fje.factoryMethod;

import com.fje.composite.Container;
import com.fje.composite.Leaf;

/**
 * NodeFactory 类使用了工厂方法设计模式
 * 该类定义了一个抽象方法 createProduct，将 Node 对象的实例化推迟到子类
 */
public abstract class NodeFactory {
    public abstract Node createProduct(Container container, Leaf leaf);
}
