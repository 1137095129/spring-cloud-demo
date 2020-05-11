package org.wjf.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.wjf.springcloud.entity.Info;

@Mapper
@Repository
public interface TestMapper1 {

	Integer createNewInfo(Info info);

	Info findInfoById(Integer id);
}
