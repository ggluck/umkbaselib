package com.umk.base;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.vaadin.server.VaadinSession;

/**
 * 
 */
public class VaadinMessageSource extends ru.xpoft.vaadin.VaadinMessageSource
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9216234130505383L;
	@Autowired
    private transient MessageSource messageSource;

    public String getMessage(String code)
    {
        Locale locale = getLocale();
        return messageSource.getMessage(code, null, locale);
    }

    public String getMessage(String code, String defaultMessage)
    {
        Locale locale = getLocale();
        return messageSource.getMessage(code, null, defaultMessage, locale);
    }

    public String getMessage(String code, Object[] args)
    {
        Locale locale = getLocale();
        return messageSource.getMessage(code, args, locale);
    }
    
    private Locale getLocale(){
    	if(VaadinSession.getCurrent() != null){
    		return VaadinSession.getCurrent().getLocale();
    	}else {
    		return Locale.getDefault();
    	}
    }
}
