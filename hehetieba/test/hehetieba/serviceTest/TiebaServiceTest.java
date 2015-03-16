package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.Tieba;
import hehetieba.dto.TiebaDto;
import hehetieba.service.ITiebaService;

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
	public void testTiebaLoad() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer id=1;
		Tieba tieba = iTiebaService.getById(id);
		tieba.setUserTiebas(null);
		tieba.setTieTitles(null);
//		System.out.println(tieba.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tieba", tieba);
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testTiebaLoad2() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer id=1;
		Tieba tieba = iTiebaService.getById(id);
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
		Tieba tieba = iTiebaService.getById(id);
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
		Integer userId = 3;
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
	public void adaf() {
		System.out.printf("Math.round(12.0):%d%n",Math.round(12.0));
		System.out.printf("Math.round(12.5):%d%n",Math.round(12.5));
		System.out.printf("Math.round(-12.0):%d%n",Math.round(-12.0));
		System.out.printf("Math.round(-12.4):%d%n",Math.round(-12.4));
		System.out.printf("Math.round(-12.5):%d%n",Math.round(-12.5));
		System.out.printf("Math.round(-12.6):%d%n",Math.round(-12.6));
	}
}






















