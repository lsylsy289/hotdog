package hotdog.user.svc.impl;

import hotdog.user.ctrl.UserManagementVO;
import hotdog.user.dao.UserManagementDao;
import hotdog.user.svc.UserManagementService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("userManagementService")
public class UserManagementServiceimpl implements UserManagementService {

	@Resource(name = "userManagementDao")
	private UserManagementDao userManagementDao;
	
	@Override
	public int insertUser(UserManagementVO userManagementVO) {
		
		return userManagementDao.insertUser(userManagementVO);
	}

}
