package db.dao;

import db.model.Pojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseMapper {

	@SuppressWarnings("rawtypes")
	public List selectListByParam(@Param("pojo") Pojo pojo);

	public int selectCountByParam(@Param("pojo") Pojo pojo);

}
