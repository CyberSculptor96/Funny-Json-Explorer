package com.fje.builder;

import com.fje.composite.Container;
import com.fje.composite.Leaf;
import com.fje.factoryMethod.Node;

/**
 * Builder 类使用了建造者模式
 * 该类负责分步构建 Node 对象
 */
public class Builder {
    private Node product;

    public Builder() {
        product = new Node();
    }

    // buildContainer 方法用于设置 Node 的容器部分
    public Builder buildContainer(Container container) {
        product.setContainer(container);
        return this;
    }

    // buildLeaf 方法用于设置 Node 的叶子部分
    public Builder buildLeaf(Leaf leaf) {
        product.setLeaf(leaf);
        return this;
    }

    // getResult 方法用于返回构建的最终产品 Node
    public Node getResult() {
        return this.product;
    }
}
