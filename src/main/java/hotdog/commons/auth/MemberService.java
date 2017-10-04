package hotdog.commons.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MemberService implements UserDetailsService {

	@Autowired MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("로드유저 진입!!!");
		
		UserDetails userDetails = null;
		
		try {
			
			Map<String, Object> userMap =  memberDao.getUserById(username);
		
			if ( null == userMap ) {
				
				throw new UsernameNotFoundException("No user found with username" + username);                                                                                    
			}
			
			Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
			
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			userDetails = new User(userMap.get("USER_ID").toString(), userMap.get("PASSWD").toString(), roles);
		
		} catch (Exception e) {
		}
		
		return userDetails;
	}
}
