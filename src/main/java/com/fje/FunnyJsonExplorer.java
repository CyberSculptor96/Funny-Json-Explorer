package com.fje;

import com.fje.Icon.Icon;
import com.fje.abstractFactory.AbstractJsonFactory;
import com.fje.abstractFactory.RectangleStyleJsonFactory;
import com.fje.abstractFactory.TreeStyleJsonFactory;
import com.fje.composite.Container;
import com.fje.composite.Leaf;
import com.fje.factoryMethod.ConcreteNodeFactory;
import com.fje.factoryMethod.Node;
import com.fje.factoryMethod.NodeFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.cli.*;

import org.json.JSONObject;

public class FunnyJsonExplorer {

    public static void main(String[] args) {
        // 创建命令行解析器
        Options options = new Options();

        Option fileOption = new Option("f", "file", true, "The JSON file that you wanna input");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        Option styleOption = new Option("s", "style", true, "The style that you wanna show");
        styleOption.setRequired(true);
        options.addOption(styleOption);

        Option iconOption = new Option("i", "icon", true, "The icon family that you wanna show");
        iconOption.setRequired(true);
        options.addOption(iconOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
            return;
        }

        // 获取命令行参数
        String filePath = cmd.getOptionValue("file");
        String style = cmd.getOptionValue("style");
        String iconName = cmd.getOptionValue("icon");

        AbstractJsonFactory factory = null;

        JSONObject data = null;
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)), "UTF-8");
            data = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 创建抽象工厂
        if (style.equalsIgnoreCase("tree")) {
            factory = new TreeStyleJsonFactory();
        } else {
            factory = new RectangleStyleJsonFactory();
        }

        // 使用抽象工厂创建 Container 和 Leaf
        Container container = factory.createContainer();
        Leaf leaf = factory.createLeaf();

        Icon icon = new Icon(iconName);

        // 使用工厂方法和建造者模式生成 Node 产品，由 Container 和 Leaf 组成
        NodeFactory productFactory = new ConcreteNodeFactory();
        Node product = productFactory.createProduct(container, leaf);

        // 结合配置文件加载 JSON 文件，并进行可视化
        product.load(data, icon);
        product.show();
    }
}
