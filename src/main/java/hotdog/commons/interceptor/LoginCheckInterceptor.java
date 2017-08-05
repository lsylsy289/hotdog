package hotdog.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 로그인 권한을 체크 하는 인터셉터
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);

    /**
     * preHandle 오버라이드
     * @param request 요청 ServletRequest
     * @param response 응답 ServletResponse
     * @param handler Object
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if( request.getSession().getAttribute("loginId") == null ) {
            // log
            logger.debug("[접근권한 없음(로그인 필요)] ==> [{}]", request.getRequestURI());

            response.sendRedirect("/login.do");
            
            return false;
        }
        
        return true;
    }
}
