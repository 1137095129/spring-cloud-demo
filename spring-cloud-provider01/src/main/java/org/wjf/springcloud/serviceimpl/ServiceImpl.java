package org.wjf.springcloud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wjf.springcloud.api.Service;
import org.wjf.springcloud.entity.Info;
import org.wjf.springcloud.mapper.TestMapper;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private TestMapper testMapper;

	@Override
	public Integer createNewInfo(Info info) {
		return testMapper.createNewInfo(info);
	}

	@Override
	public Info findInfoById(Integer id) {
		return testMapper.findInfoById(id);
	}

	@Override
	public Info findInfoTimeOutById(Integer id) {
		return null;
	}
}
