package hotdog.user.svc.impl;

import hotdog.user.dao.UserDao;
import hotdog.user.svc.UserService;
import hotdog.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

	@Autowired UserDao userDao;
	
	@Override
	public int registUser(UserVO userVO) throws Exception {
		
		return userDao.insertUser(userVO);
	}

}
