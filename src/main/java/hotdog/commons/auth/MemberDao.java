package hotdog.commons.auth;

import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface MemberDao {

	public Map<String, Object> getUserById(String username) throws Exception;
}
