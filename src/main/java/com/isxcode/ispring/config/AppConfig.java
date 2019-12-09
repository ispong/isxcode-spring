package com.isxcode.ispring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

/**
 * 项目基础配置
 *
 * @author ispong
 * @version v0.1.0
 * @date 2019-11-14
 */
@EnableJpaRepositories(basePackages = {"com.isxcode.ispring.repositories"})
@EnableJpaAuditing
@EnableTransactionManagement
@Configuration
@EnableAspectJAutoProxy
@EnableScheduling
@ImportResource(locations = {"classpath:schema/**"})
public class AppConfig {

	/**
	 * 项目启动时执行
	 *
	 * @param appContext ApplicationContext
	 * @since 2019/10/17
	 */
	@Bean
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> Arrays.stream(appContext.getBeanDefinitionNames()).sorted().forEach(System.out::println);
	}

}
