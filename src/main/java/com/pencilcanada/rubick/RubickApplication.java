package com.pencilcanada.rubick;

import com.mongodb.connection.SslSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import javax.annotation.PreDestroy;

@SpringBootApplication
public class RubickApplication {
	EventLoopGroup eventLoopGroup = new NioEventLoopGroup();  // make sure application shuts this down

	public static void main(String[] args) {
		SpringApplication.run(RubickApplication.class, args);
	}

	@Bean
	public MongoClientSettingsBuilderCustomizer sslCustomizer() {
		return clientSettingsBuilder -> clientSettingsBuilder
				.sslSettings(SslSettings.builder()
						.enabled(true)
						.invalidHostNameAllowed(true)
						.build())
				.streamFactoryFactory(NettyStreamFactoryFactory.builder()
						.eventLoopGroup(eventLoopGroup).build());
	}

	@PreDestroy
	public void shutDownEventLoopGroup() {
		eventLoopGroup.shutdownGracefully();
	}
}
