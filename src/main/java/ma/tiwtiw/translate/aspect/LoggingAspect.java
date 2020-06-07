package ma.tiwtiw.translate.aspect;

import lombok.extern.slf4j.Slf4j;
import ma.tiwtiw.core.controller.aspect.BaseLoggingAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect extends BaseLoggingAspect {

}