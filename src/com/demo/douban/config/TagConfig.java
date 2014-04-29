package com.demo.douban.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TagConfig
{
	public static List<String> categoryList;
	public static List<String> tagsList;
	public static HashMap<String, List<String>> tagsMap;
	
	private static String categorys[] = {"生活", "青春", "小说", "文学", "艺术","动漫", "旅游"};
	
	private static String lifeTags[] = {"购物", "理财", "养花", "家居装潢", "爱车一族", "实用法律"
			, "生活百科", "饮食文化", "茶", "家居与风水","饮食", "烹饪", "家常食谱", "餐饮指南"};
	private static String youthTags[] = {"校园", "爱情", "叛逆", "悬疑", "惊悚", "网络", "爆笑"
			, "魔幻", "奇幻"};
	private static String novelTags[] = {"世界名著", "外国小说", "中国古典小说", "中国现代小说"
			, "中国当代小说", "影视同期书", "历史小说", "外文原版书", "都市小说", "推理小说"};
	private static String literatureTags[] = {"文集", "纪实文学", "文学理论", "中国古诗词"
			, "中国现当代诗歌", "外国诗歌", "中国古代随笔", "中国现当代随笔", "外国随笔", "戏剧"
			, "民间文学"};
	private static String artTags[] = {"艺术理论", "人体艺术", "设计", "影视艺术", "建筑艺术", "戏曲"
			, "摄影", "美术", "乐谱"};
	private static String cartoonTags[] = {"动漫学堂", "大师画集", "名著绘图本", "幽默与漫画", "笑话"
			, "连环画","推理", "侦探", "冒险", "武侠", "生活", "科幻"};
	private static String travelTags[] = {"旅游随笔", "旅游地图", "自助游", "自然", "人文之旅", "民俗"
			, "旅游实用外语", "国家", "境内", "境外", "导游"};
	
	/**
	 * 随机产生标签
	 * @return tag
	 */
	public static String randomTag()
	{
		String tag = "";

		initData();
		
		String catgory = categorys[gengrateRandomNumber(categorys.length, 0)];
		
		tag = tagsMap.get(catgory).get(gengrateRandomNumber(tagsMap.get(catgory).size(), 0));
		
		return tag;
	}
	
	/**
	 * 初始化标签数据
	 */
	private static void initData()
	{
		tagsMap.put(categorys[0], parseArrayToList(lifeTags));
		tagsMap.put(categorys[1], parseArrayToList(youthTags));
		tagsMap.put(categorys[2], parseArrayToList(novelTags));
		tagsMap.put(categorys[3], parseArrayToList(literatureTags));
		tagsMap.put(categorys[4], parseArrayToList(artTags));
		tagsMap.put(categorys[5], parseArrayToList(cartoonTags));
		tagsMap.put(categorys[6], parseArrayToList(travelTags));
	}
	
	private static int gengrateRandomNumber(int max, int min)
	{
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}
	
	/**
	 * parse array to list
	 * @param array
	 * @return
	 */
	private static List<String> parseArrayToList(String[] array)
	{
		List<String> list = new ArrayList<String>();
		
		int arraySize = array.length;
		for(int i=0; i<= arraySize-1; i++)
		{
			list.add(array[i]);
		}
		
		return list;
	}
	
}
