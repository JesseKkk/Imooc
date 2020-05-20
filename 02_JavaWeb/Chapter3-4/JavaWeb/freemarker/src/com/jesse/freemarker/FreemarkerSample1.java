package com.jesse.freemarker;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jesse.freemarker.entity.Computer;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class FreemarkerSample1 {

	public static void main(String[] args) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		// TODO Auto-generated method stub
		//1. 加载模板
		//创建核心配置对象
		Configuration config = new Configuration(Configuration.VERSION_2_3_29);
		//设置加载的目录
		config.setClassForTemplateLoading(FreemarkerSample1.class, "");
		//得到模板对象
		Template t = config.getTemplate("sample1.ftl");
		//2. 创建数据
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("site", "新浪");
		data.put("url", "http://www.sina.com");
		data.put("date", new Date());
		data.put("number", 837183.883217);
		Map info = new HashMap();
		info.put("cpu", "i5");
		Computer c1 = new Computer("1234567", "ThinkPad", 2, "李四", new Date(), 12900f, info);
		data.put("computer", c1);
		//3. 产生输出
		t.process(data, new OutputStreamWriter(System.out));
	}

}
