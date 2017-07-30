package hotdog.user.dao;

import hotdog.user.ctrl.UserManagementVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userManagementDao")
public interface UserManagementDao {

	int insertUser(UserManagementVO userManagementVO);
}
