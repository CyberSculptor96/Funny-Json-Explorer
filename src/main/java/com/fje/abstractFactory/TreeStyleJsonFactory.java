package com.fje.abstractFactory;

import com.fje.Icon.Icon;
import com.fje.composite.Container;
import com.fje.composite.Leaf;
import com.fje.composite.TreeStyleContainer;
import com.fje.composite.TreeStyleLeaf;

/**
 * TreeStyleJsonFactory 类实现了 AbstractJsonFactory 接口
 * 该类用于创建树形风格的容器和叶子对象
 */
public class TreeStyleJsonFactory implements AbstractJsonFactory {
    @Override
    public Container createContainer() {
        return new TreeStyleContainer("prototype", 0, new Icon());
    }

    @Override
    public Leaf createLeaf() {
        return new TreeStyleLeaf("prototype", "value", new Icon());
    }
}
