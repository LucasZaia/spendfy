import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityEndpoints {
 
    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
        "/user/login",
        "/user/add",
    };
}