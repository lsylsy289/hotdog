package hotdog.commons.login;

import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface LoginDao {

    public Map<String, Object> getUserById(String username) throws Exception;
}
