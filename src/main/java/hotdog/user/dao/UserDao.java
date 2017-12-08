
package hotdog.user.dao;

import hotdog.user.vo.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface UserDao {

	public int insertUser(UserVO userVO) throws Exception;
}
