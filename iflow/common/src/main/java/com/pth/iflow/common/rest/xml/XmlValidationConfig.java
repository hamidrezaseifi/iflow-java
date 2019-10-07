package com.pth.iflow.common.rest.xml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.pth.iflow.common.rest.XmlRestConfig;

/**
 * The Interface MdmFullAppDefaultConfig.
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Import({ XmlRestConfig.class, XmlValidatingRequestFilter.class, XmlValidator.class })
public @interface XmlValidationConfig {

}
