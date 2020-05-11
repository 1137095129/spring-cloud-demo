package org.wjf.springcloudhystrixprovide01.service;

import org.wjf.springcloud.api.Service;
import org.wjf.springcloud.entity.Info;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@org.springframework.stereotype.Service
public class TestService implements Service {
	@Override
	public Integer createNewInfo(Info info) {
		return null;
	}

	@Override
	public Info findInfoById(Integer id) {
		Info info = new Info();
		info.setId(id);
		info.setInfo("info--->正常返回：当前线程名：" + Thread.currentThread().getName());
		info.setName("name--->" + id);
		return info;
	}

	@Override
	public Info findInfoTimeOutById(Integer id) {

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Info info = new Info();
		info.setId(id);
		info.setInfo("info--->正常返回：当前线程名：" + Thread.currentThread().getName());
		info.setName("name--->" + id);

		return info;
	}
}
