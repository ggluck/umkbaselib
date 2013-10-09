package com.umk.base.vaadin;

import com.umk.base.utils.Utils;
import com.vaadin.ui.CustomComponent;

public class BaseCustomComponent extends CustomComponent implements IBeans{
	private static final long serialVersionUID = -84635365811846588L;
	protected CallBack callBack;
	
	public void setCallBack(CallBack callBack){
		this.callBack = callBack;
	}
	public interface CallBack{
		void onCallBack(int type,Object obj);
	}
	public <BEAN> BEAN $(Class<BEAN> clas) {
		return Utils.getBeans(clas);
	}
	
}
