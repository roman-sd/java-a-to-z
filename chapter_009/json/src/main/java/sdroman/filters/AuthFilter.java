package sdroman.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sdroman
 * @since 04.2018
 */
public class AuthFilter implements Filter {

    /**
     * Init.
     *
     * @param filterConfig FilterConfig
     * @throws ServletException exception
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Filter.
     *
     * @param servletRequest  ServletRequest
     * @param servletResponse ServletResponse
     * @param filterChain     FilterChain
     * @throws IOException      exception
     * @throws ServletException exception
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getRequestURI().contains("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("curUser") == null) {
                response.sendRedirect(String.format("%s/login", request.getContextPath()));
                return;
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * Destroy.
     */
    @Override
    public void destroy() {
    }
}
