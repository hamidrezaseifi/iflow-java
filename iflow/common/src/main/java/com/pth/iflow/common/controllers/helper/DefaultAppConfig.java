package com.pth.iflow.common.controllers.helper;

import org.springframework.context.annotation.Configuration;
import com.pth.iflow.common.rest.xml.XmlValidationConfig;

/**
 * A config to declare all beans and other components that should start for each of the modules as a single one-stop-shop. However, more
 * elaborate configs that entail several aspects and beans should be externalized into their own config and imported here .
 */
@Configuration
@FullAppConfig
@XmlValidationConfig
public class DefaultAppConfig {

}
