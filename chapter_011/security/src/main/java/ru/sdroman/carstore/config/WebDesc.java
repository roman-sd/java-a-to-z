package ru.sdroman.carstore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author sdroman
 * @since 08.2018
 */
public class WebDesc extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Root config class.
     *
     * @return Class[]
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRootConfig.class};
    }

    /**
     * Servlet config class.
     *
     * @return Class[]
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    /**
     * Mapping.
     *
     * @return String
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
