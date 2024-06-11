package com.fje.abstractFactory;

import com.fje.composite.Container;
import com.fje.composite.Leaf;

/**
 * AbstractJsonFactory 接口使用了抽象工厂设计模式
 * 该接口定义了创建相关对象 Container 和 Leaf 的方法
 */
public interface AbstractJsonFactory {
    public abstract Container createContainer();

    public abstract Leaf createLeaf();
}
