package com.umk.base.vaadin;

import com.umk.base.service.BaseService;
@Deprecated
/**
 * This class has deprecated.
 * @author gx
 *
 */
public interface IService {
	 <T extends BaseService<?>> T $(Class<T> t);
}
