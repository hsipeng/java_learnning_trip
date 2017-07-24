package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import product.Product;

public class testJson {
	@Test
	public void test01(){
		//1.将数组转换为json
		String[] arr = {"刘亦菲","杨过","小李飞刀"};
		System.out.println(Arrays.toString(arr));
		JSONArray jsonArray = JSONArray.fromObject(arr);
		System.out.println(jsonArray);
	}
	@Test
	public void test02(){
		//1.将LIST集合转换为json
		List<String> list = new ArrayList<String>();
		list.add("自行车");
		list.add("电动车");
		list.add("摩托车");
		System.out.println(list);
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray);
	}
	
	@Test
	public void test03(){
		//1.将Map集合转换为json
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("1", "周一");
		map.put("2", "周一");
		map.put("3", "周一");
		System.out.println(map);
		
		JSONArray jsonArray = JSONArray.fromObject(map);
		System.out.println(jsonArray);
	}
	
	@Test
	public void test04(){
		//2.将对象转换JSON
		Product product = new Product();
		product.setId(1);
		product.setName("iphone8");
		product.setPrice(8888);
		
		
		//JSON配置文件，转化配置规则
		JsonConfig jsonConfig = new JsonConfig();
		//排除属性值
		jsonConfig.setExcludes(new String[]{"addr"});
		System.out.println(product);
		
		JSONObject jsonObject = JSONObject.fromObject(product,jsonConfig);
		System.out.println(jsonObject);
	}
	
	@Test
	public void test05(){
		//将json串转换为对象
	String jString = "{'id':1,'name':'iphone8','price':8888}";
	JSONObject jsonObject = JSONObject.fromObject(jString);
	Product product = (Product) jsonObject.toBean(jsonObject,Product.class);
	System.out.println(product);
	}
}
