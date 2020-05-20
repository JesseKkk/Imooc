package com.jesse.freemarker;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jesse.freemarker.entity.Computer;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class FreemarkerSample3 {

	public static void main(String[] args) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		// TODO Auto-generated method stub
		//1. 加载模板
		//创建核心配置对象
		Configuration config = new Configuration(Configuration.VERSION_2_3_29);
		//设置加载的目录
		config.setClassForTemplateLoading(FreemarkerSample3.class, "");
		//得到模板对象
		Template t = config.getTemplate("sample3.ftl");
		//2. 创建数据
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("name", "jackson");
		data.put("brand", "bmw");
		data.put("words", "first blood");
		data.put("n", 37981.83);
		data.put("date", new Date());
		List<Computer> computers = new ArrayList<>();
		computers.add(new Computer("1234567", "ThinkPad", 2, null, new Date(), 12900f, new HashMap()));
		computers.add(new Computer("1234367", "HP XXX", 1, "李四", new Date(), 13900f, new HashMap()));
		computers.add(new Computer("1234767", "DELL XXX", 3, "张三", new Date(), 11900f, new HashMap()));
		computers.add(new Computer("1234967", "ACER XXX", 1, "王五", new Date(), 12500f, new HashMap()));
		computers.add(new Computer("1234867", "MSI XXX", 2, "赵六", new Date(), 12930f, new HashMap()));
		data.put("computers", computers);
		//3. 产生输出
		t.process(data, new OutputStreamWriter(System.out));
	}

}
