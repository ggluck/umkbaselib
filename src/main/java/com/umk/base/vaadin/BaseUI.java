package com.umk.base.vaadin;

import com.umk.base.utils.Utils;
import com.vaadin.ui.UI;

public abstract class BaseUI extends UI implements IBeans{
	private static final long serialVersionUID = -2362765178454815589L;

	public <BEAN> BEAN $(Class<BEAN> clas) {
		return Utils.getBeans(clas);
	}

}
