package umc.study.exception.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import umc.study.common.RequestLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@RequiredArgsConstructor
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

        if (request.getClass().getName().contains("SecurityContextHolderAwareRequestWrapper"))
            return;

        // Request Body 캐싱+로깅
        if (request.getContentType() != null && request.getContentType().contains("application/json")) {
            RequestLogger.logging(request);
        }
    }
}

