package com.jagadesh.mcpServer;

import com.jagadesh.mcpServer.tools.ItemMcpService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpServerApplication.class, args);
	}

    @Bean
    public List<ToolCallback> itemToolCallBack(ItemMcpService itemMcpService) {
        return List.of(ToolCallbacks.from(itemMcpService));
    }
}
