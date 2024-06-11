package com.fje.factoryMethod;

import com.fje.Icon.Icon;
import com.fje.composite.Component;
import com.fje.composite.Container;
import com.fje.composite.Leaf;

import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
// import java.util.Stack;
import java.util.ArrayList;

/**
 * Node 类表示通过工厂方法模式创建的产品
 */
public class Node {
    protected Container containerPrototype;
    protected Leaf leafPrototype;
    protected Container rootContainer;

    public Node() {
        this.containerPrototype = null;
        this.leafPrototype = null;
        this.rootContainer = null;
    }

    // 设置容器原型
    public void setContainer(Container container) {
        this.containerPrototype = container;
    }

    // 设置叶子原型
    public void setLeaf(Leaf leaf) {
        this.leafPrototype = leaf;
    }

    // 加载 JSON 数据并构建树形结构，逻辑不正确
    public void load(JSONObject data, Icon icon) {
        rootContainer = containerPrototype.createInstance("root", 0, icon);
        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[] { rootContainer, data });

        while (!stack.isEmpty()) {
            Object[] current = stack.pop();
            Container currentContainer = (Container) current[0];
            JSONObject currentData = (JSONObject) current[1];

            Iterator<String> keys = currentData.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = currentData.get(key);
                if (value instanceof JSONObject) {
                    Container newContainer = containerPrototype.createInstance(key, currentContainer.getLevel() + 1,
                            icon);
                    currentContainer.add(newContainer);
                    stack.push(new Object[] { newContainer, (JSONObject) value });
                } else {
                    Leaf newLeaf = leafPrototype.createInstance(key, value.toString(), icon);
                    currentContainer.add(newLeaf);
                }
            }
        }
    }

    // 显示树形结构
    public void show() {
        List<Boolean> parentIsLast = new ArrayList<>();
        List<Component> children = rootContainer.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Component child = children.get(i);
            child.draw(rootContainer.getLevel() + 1, i == 0, i == children.size() - 1, parentIsLast);
        }
    }
}
