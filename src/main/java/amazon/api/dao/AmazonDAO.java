package amazon.api.dao;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import amazon.api.pojo.Book;
import amazon.api.pojo.IModel;

/**
 * Generic DAO
 * @author math
 *
 * @param <T extends IModel>
 */
public abstract class AmazonDAO<T extends IModel> {
	
	protected List<T> data;
	/**
	 * So child can be Singletons
	 */
	protected static AmazonDAO<? extends IModel> instance = null;
	
	/**
	 * Fetch One By Field
	 * @param field
	 * @param value
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	protected T fetchOneByField(String field, Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		for(T item : data){
			
			Field innerField = item.getClass().getDeclaredField(field);
			innerField.setAccessible(true);
			
			if(innerField.get(item) == value){
				return item;
			}
		}
		
		return null;
	}
	
	/**
	 * Fetch All By Field
	 * @param field
	 * @param value
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	protected List<T> fetchAllByField(String field, Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		List<T> result = new ArrayList<T>();
		for(T item : data){
			Field innerField = item.getClass().getDeclaredField(field);
			innerField.setAccessible(true);
			
			if(innerField.get(item) == value){
				result.add(item);
			}
		}
		
		return result;
	}
	
	protected void addItem(T item) {
		this.data.add(item);
	}
	
	protected boolean deleteByField(String field, String value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		int sizeBefore = data.size();
		
		for (int i = 0; i < data.size(); i++) {
			
			T item = data.get(i);
			
			Field innerField = item.getClass().getDeclaredField(field);
			innerField.setAccessible(true);
			
			if(innerField.get(item) == value){
				data.remove(item);
			}
			
		}
		
		for(T item : data){
			
			
		}
		
		return (sizeBefore != data.size());
	}
	
	/**
	 * Fetch All
	 * @return
	 */
	public List<T> fecthAll(){
		return data;
	}

	


}
