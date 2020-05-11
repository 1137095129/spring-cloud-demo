package org.wjf.springcloud.api;

import org.wjf.springcloud.entity.Info;

public interface Service {
	Integer createNewInfo(Info info);

	Info findInfoById(Integer id);

	Info findInfoTimeOutById(Integer id);
}
