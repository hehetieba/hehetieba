package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.Tieba;
import hehetieba.dto.TiebaDto;
import hehetieba.service.ITiebaService;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TiebaServiceTest extends SpringInit {
	@Test
	public void testTiebaById() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer id=1;
		Tieba tieba = iTiebaService.getTiebaById(id);
//		System.out.println(tieba.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tieba", tieba);
		Gson gson = new GsonBuilder()
		.setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }
	     })
	    .serializeNulls()
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testTiebaLoad2() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer id=1;
		Tieba tieba = iTiebaService.getTiebaById(id);
//		tieba.setUserTiebas(null);
//		tieba.setTieTitles(null);
//		System.out.println(tieba.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tieba", tieba);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {

	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }

	        /**
	          * Custom field exclusion goes here
	          */
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    /**
	      * Use serializeNulls method if you want To serialize null values 
	      * By default, Gson does not serialize null values
	      */
	    .serializeNulls()
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testTiebaDtoLoadByHql() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer id=1;
		TiebaDto tiebaDto = iTiebaService.getDtoById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tiebaDto", tiebaDto);
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testTiebaList() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer index = 1;
		Integer size = 1;
		Pager<Tieba> pager = iTiebaService.list(index, size);
//		System.out.println(pager);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {

	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }

	        /**
	          * Custom field exclusion goes here
	          */
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    /**
	      * Use serializeNulls method if you want To serialize null values 
	      * By default, Gson does not serialize null values
	      */
	    .serializeNulls()
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testFindByTiebaName() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer index = 1;
		Integer size = 2;
		String tiebaName = "中文";
		Pager<Tieba> pager = iTiebaService.findByTiebaName(index, size, tiebaName);
//		System.out.println(pager);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {

	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }

	        /**
	          * Custom field exclusion goes here
	          */
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    /**
	      * Use serializeNulls method if you want To serialize null values 
	      * By default, Gson does not serialize null values
	      */
	    .serializeNulls()
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testGetById() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer id = 1;
		Tieba tieba = iTiebaService.getTiebaById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tieba", tieba);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {

	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }

	        /**
	          * Custom field exclusion goes here
	          */
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    /**
	      * Use serializeNulls method if you want To serialize null values 
	      * By default, Gson does not serialize null values
	      */
	    .serializeNulls()
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testListFavoriteTiebas() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer userId = 1;
		List<Tieba> listTiebas = iTiebaService.listFavoriteTiebas(userId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("FavoriteTiebas", listTiebas);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {

	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }

	        /**
	          * Custom field exclusion goes here
	          */
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    /**
	      * Use serializeNulls method if you want To serialize null values 
	      * By default, Gson does not serialize null values
	      */
	    .serializeNulls()
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testChangeIntroduction() {
		// TODO Auto-generated method stub
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer tiebaId = 1;
		String introduction = "修改后的贴吧信息";
		iTiebaService.changeIntroduction(tiebaId, introduction);
		System.out.println("修改完成");
	}
	
	@Test
	public void testUploadHeadImg() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer tiebaId = 1;
		File headImg = new File("C:\\Users\\Administrator\\Desktop\\asd.txt");
		String ext = ".txt";
		iTiebaService.uploadHeadImg(tiebaId, headImg, ext);
		
		System.out.println("上传完毕");
	}
	
	@Test
	public void testUploadBgImg() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer tiebaId = 1;
		File bgImg = new File("C:\\Users\\Administrator\\Desktop\\asd.txt");
		String ext = ".txt";
		iTiebaService.uploadBgImg(tiebaId, bgImg, ext);
		
		System.out.println("上传完毕");
	}
	
	@Test
	public void testEnableTieba() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer tiebaId = 1;
		iTiebaService.enableTieba(tiebaId);
		
		System.out.println("已经恢复该贴吧");
	}
	
	@Test
	public void testDisableTieba() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer tiebaId = 1;
		iTiebaService.disableTieba(tiebaId);
		
		System.out.println("已经禁用该贴吧");
	}
	
	@Test
	public void testChangeMessage() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer tiebaId = 2;
		String intruduction = "修改";
		File[] files = new File[]{new File("C:\\Users\\Administrator\\Desktop\\asd.txt"),new File("C:\\Users\\Administrator\\Desktop\\qwe.txt")};
		String[] filesFileName = new String[]{new String(".txt"),new String(".txt")};
		iTiebaService.changeMessage(tiebaId, intruduction, files, filesFileName);
		
		System.out.println("已修改贴吧信息");
	}
	
}






















