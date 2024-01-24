package umc.study.exception.advice;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CachingRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Multipart Type 이면 Skip
        if (isMultipartRequest(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        ContentCachingRequestWrapper wrappingRequest = new ContentCachingRequestWrapper(request);
        filterChain.doFilter(wrappingRequest, response);
    }

    private boolean isMultipartRequest(HttpServletRequest request) {
        return request.getContentType() != null && request.getContentType().startsWith("multipart");
    }
}
