package hotdog.login.svc.impl;

import java.util.Map;

import hotdog.login.dao.LoginDao;
import hotdog.login.svc.LoginService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name = "loginDao")
	private LoginDao loginDao;
	
	@Override
	public Map<String, Object> selectConfirm(String userId) throws Exception {
		
		return loginDao.selectConfirm(userId);
	}
}
