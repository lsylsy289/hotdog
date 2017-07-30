package hotdog.login.dao;

import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("loginDao")
public interface LoginDao {

	public Map<String, Object> selectConfirm(String userId) throws Exception;
}
