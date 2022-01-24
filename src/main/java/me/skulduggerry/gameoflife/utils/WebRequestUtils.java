package me.skulduggerry.gameoflife.utils;

import static lombok.AccessLevel.PRIVATE;
import static org.thymeleaf.util.Validate.notNull;

import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.util.StringUtils;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class WebRequestUtils {

    /**
     * <p>Returns the path of the request if possible; otherwise {@code null}.</p>
     *
     * @param webRequest the {@link WebRequest} from which the path will be extracted if possible
     * @return the path of the request or {@code null} if extracting the path was not possible
     * @throws NullPointerException if webRequest is {@code null}
     * @since 1.0.0
     */
    public static String extractPath(WebRequest webRequest) {
        notNull(webRequest, "webRequest");
        ServletWebRequest swr = (ServletWebRequest) webRequest;
        String description = swr.getDescription(false);
        return StringUtils.substringAfter(description, "uri=");
    }
}
