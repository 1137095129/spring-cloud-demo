package org.wjf.springcloud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wjf.springcloud.api.Service;
import org.wjf.springcloud.entity.Info;
import org.wjf.springcloud.mapper.TestMapper1;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private TestMapper1 testMapper1;

	@Override
	public Integer createNewInfo(Info info) {
		return testMapper1.createNewInfo(info);
	}

	@Override
	public Info findInfoById(Integer id) {
		return testMapper1.findInfoById(id);
	}
}
