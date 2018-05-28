package com.golpesoft.erp.process.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author yeguanjie
 * @date 2017/7/20
 */
@Slf4j
public class PropertyUtil extends PropertyPlaceholderConfigurer implements ApplicationContextAware {

    private String host;
    private String port;
    private String projCode;
    private String profile;
    private String modules;
    private String ignoreProps;

    public PropertyUtil(String host, String port, String projCode, String profile, String modules) {
        this.host = host;
        this.port = port;
        this.projCode = projCode;
        this.profile = profile;
        this.modules = modules;
    }

    public PropertyUtil(String host, String port, String projCode, String profile, String modules, String ignoreProps) {
        this.host = host;
        this.port = port;
        this.projCode = projCode;
        this.profile = profile;
        this.modules = modules;
        this.ignoreProps = ignoreProps;
    }


    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
                                     Properties props) {
        DefaultListableBeanFactory springFactory = null;
        if (applicationContext instanceof AbstractRefreshableApplicationContext) {
            AbstractRefreshableApplicationContext springContext = (AbstractRefreshableApplicationContext) applicationContext;
            if (!(springContext.getBeanFactory() instanceof DefaultListableBeanFactory)) {
                log.error("Dynamic get property from SuperDiamond set to spring property. No suitable bean factory! The current factory class is {}", springContext.getBeanFactory().getClass());
                throw new BeanNotOfRequiredTypeException("applicationContext", DefaultListableBeanFactory.class, springContext.getBeanFactory().getClass());
            }
            springFactory = (DefaultListableBeanFactory) springContext.getAutowireCapableBeanFactory();
        } else if (applicationContext instanceof GenericApplicationContext) {
            GenericApplicationContext springContext = (GenericApplicationContext) applicationContext;
            springFactory = springContext.getDefaultListableBeanFactory();
        } else {
            log.error("Dynamic get property from SuperDiamond set to spring property. No suitable application applicationContext! The current applicationContext class is {}",
                    applicationContext.getClass());
            throw new BeanNotOfRequiredTypeException("applicationContext", DefaultListableBeanFactory.class, applicationContext.getAutowireCapableBeanFactory().getClass());
        }
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition("com.github.diamond.client.PropertiesConfigurationFactoryBean");
        String beanKey = "propertiesConfigurationFactoryBean";
        beanDefinitionBuilder.getBeanDefinition().setAttribute("id", beanKey);
        String _host = props.getProperty(host);
        Integer _port = Integer.valueOf(props.getProperty(port));
        String _projCode = props.getProperty(projCode);
        String _profile = props.getProperty(profile);
        String _modules = props.getProperty(modules);
        Map<String, String> _ignoreMap = new HashMap<String, String>();
        if (StringUtils.isNotBlank(ignoreProps)) {
            String _ignoreProperties = props.getProperty(ignoreProps);
            if (StringUtils.isNotBlank(_ignoreProperties)) {
                String[] list = _ignoreProperties.split(",");
                if (null != list && list.length != 0) {
                    for (String v : list) {
                        _ignoreMap.put(v, v);
                    }
                }
            }
        }
        log.info("super diamond start param host：{}，port：{}, projCode：{}, profile：{}, modules：{}", _host, _port, _projCode, _profile, _modules);
        beanDefinitionBuilder.addConstructorArgValue(_host);
        beanDefinitionBuilder.addConstructorArgValue(_port);
        beanDefinitionBuilder.addConstructorArgValue(_projCode);
        beanDefinitionBuilder.addConstructorArgValue(_profile);
        beanDefinitionBuilder.addConstructorArgValue(_modules);
        springFactory.registerBeanDefinition(beanKey, beanDefinitionBuilder.getBeanDefinition());
        Properties new_prop = springFactory.getBean(beanKey, Properties.class);
        log.debug("============= get property config from super diamond start =============");
        for (String key : new_prop.stringPropertyNames()) {
            Object old = props.get(key);
            if (null == _ignoreMap.get(key)) {
                log.debug("key:{}，\t value:{}", String.format("%-29s", key.toString()), new_prop.get(key));
            }
            if (null != old && !old.equals(new_prop.get(key))) {
                continue;
            }
            props.put(key, new_prop.get(key));
        }
        log.debug("============= get property config from super diamond end =============");
        super.processProperties(beanFactoryToProcess, props);
    }

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PropertyUtil.applicationContext = applicationContext;
    }
}