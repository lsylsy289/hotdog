package hotdog.login.svc;

import java.util.Map;

public interface LoginService {

	public Map<String, Object> selectConfirm(String userId) throws Exception;

}