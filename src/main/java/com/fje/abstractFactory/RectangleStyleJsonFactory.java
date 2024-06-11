package com.fje.abstractFactory;

import com.fje.Icon.Icon;
import com.fje.composite.Container;
import com.fje.composite.Leaf;
import com.fje.composite.RectangleStyleContainer;
import com.fje.composite.RectangleStyleLeaf;

/**
 * RectangleStyleJsonFactory 类实现了 AbstractJsonFactory 接口
 * 该类用于创建矩形风格的容器和叶子对象
 */
public class RectangleStyleJsonFactory implements AbstractJsonFactory {
    @Override
    public Container createContainer() {
        return new RectangleStyleContainer("prototype", 0, new Icon());
    }

    @Override
    public Leaf createLeaf() {
        return new RectangleStyleLeaf("prototype", "value", new Icon());
    }
}
