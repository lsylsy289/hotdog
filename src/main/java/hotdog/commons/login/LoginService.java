package hotdog.commons.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired private LoginDao loginDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetails userDetails = null;

		try {

			Map<String, Object> userMap =  loginDao.getUserById(username);

			if ( null == userMap ) {

				throw new UsernameNotFoundException("No user found with username" + username);
			}

			Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();

			roles.add(new SimpleGrantedAuthority("ROLE_USER"));

			userDetails = new User(userMap.get("USER_ID").toString(), userMap.get("PASSWD").toString(), roles);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return userDetails;
	}
}
