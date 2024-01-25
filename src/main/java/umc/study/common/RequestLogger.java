package umc.study.common;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@UtilityClass
public class RequestLogger {

    public static void logging(HttpServletRequest req) {
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append(getLoggingStructure());
        logBuilder.append(getRequestURI(req)).append("\n");
        logBuilder.append("[Request Headers]").append("\n").append(parsingHeaders(req)).append("\n");
        logBuilder.append("[Request Body]").append("\n").append(parsingBody(req)).append("\n");
        log.info(logBuilder.toString());
    }

    public static String getLoggingStructure() {
        return "\n" + "This is Requested Information." + "\n";
    }

    private static String getRequestURI(HttpServletRequest request) {
        String httpMethod = "[HTTP Method] " + request.getMethod();
        String requestURI = "[Request URI] " + request.getRequestURI();

        return httpMethod + "\n" + requestURI;
    }

    private static Map<String, Object> parsingHeaders(HttpServletRequest request) {
        Map<String, Object> headerMap = new HashMap<>();

        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            headerMap.put(headerName, request.getHeader(headerName));
        }
        return headerMap;
    }

    private static String parsingBody(HttpServletRequest request) {
        ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper) request;

        if (request != null) {
            byte[] buf = cachingRequest.getContentAsByteArray();
            if (buf.length > 0) {
                try {
                    return new String(buf, 0, buf.length, cachingRequest.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    return " Unsupported Encoding ";
                }
            }
        }
        return "EMPTY BODY ";
    }
}
