package com.umk.base.utils;

import java.lang.reflect.Field;

import javax.validation.constraints.NotNull;

import ru.xpoft.vaadin.SpringApplicationContext;

import com.umk.base.exception.UException;
import com.umk.base.service.BaseService;
import com.vaadin.data.fieldgroup.Caption;

public class Utils {
	/**
	 * 根据Caption注解返回caption,不生成必填标识
	 * @param clazz
	 * @param fieldname
	 * @return 找不到则返回fieldname
	 */
	public static String getCaption(Class<?> clazz, String fieldname){
		return getCaption(clazz, fieldname, false);
	}
	
	/**
	 * 根据Caption注解返回caption
	 * @param clazz
	 * @param fieldname
	 * @param showRequiredSign 是否生成必填标识
	 * @return
	 */
	public static String getCaption(Class<?> clazz, String fieldname, boolean showRequiredSign){
		try {
			Field f = clazz.getDeclaredField(fieldname);
			String caption = getCaption(f,showRequiredSign);
			return caption == null ? fieldname : caption;
		} catch (Exception e1) {
			return fieldname;
		}
	}
	
	/**
	 * 获得Caption
	 * @param field
	 * @param showRequiredSign 是否生成必填标识(红*)
	 * @return
	 */
	public static  String getCaption(Field field, boolean showRequiredSign){
		Caption caption = field.getAnnotation(Caption.class);
		NotNull notNull = field.getAnnotation(NotNull.class);
		if(caption != null){
			String cap = caption.value();
			if(showRequiredSign && notNull != null){
				cap += "<font color=red>*</font>";
			}
			return cap;
		}else{
			return field.getName();
		}
	}
	/**
	 * 根据异常信息生成友好提示
	 * @param e
	 * @return
	 */
	public static String getPersistenceErrorMsg(javax.persistence.PersistenceException e){
		String msg = e.getMessage();
		if(msg == null){
			return null;
		}
		if(msg.contains("FOREIGN KEY")){
			msg = "该数据已被引用，禁止删除:"+e.getMessage();
		}else if(msg.contains("Unique")){
			msg ="关键字段数据重复\n"+e.getMessage();
		}
		return msg;
	}
	/**
	 * 获取Service
	 * @param clas
	 * @return
	 */
	public static <T> T getBeans(Class<T> clas){
		try{
			return (T) SpringApplicationContext.getApplicationContext().getBean(clas);
		}catch(Exception e){
			throw new UException("无法获取类型为"+clas.getName()+"的Bean.");
		}
	}
}
