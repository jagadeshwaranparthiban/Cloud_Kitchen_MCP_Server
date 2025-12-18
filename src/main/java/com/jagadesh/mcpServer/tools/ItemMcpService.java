package com.jagadesh.mcpServer.tools;

import com.jagadesh.mcpServer.model.Item;
import com.jagadesh.mcpServer.model.ItemCategory;
import com.jagadesh.mcpServer.repository.ItemRepo;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemMcpService {
    private ItemRepo itemRepo;

    public ItemMcpService(ItemRepo itemRepo){
        this.itemRepo=itemRepo;
    }

    @Tool(
        name="GetAllItems",
        description="Retrieve a list of all items available in the inventory."
    )
    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }

    @Tool(
        name="GetItemByName",
        description="Fetch details of a specific item by its name."
    )
    public Item getItemByName(@ToolParam String name){
        return itemRepo.findByItemName(name).orElse(null);
    }

    @Tool(
        name="AddNewItem",
        description="Add a new item to the inventory. If the item already exists, an exception is thrown."
    )
    public Item addItem(@ToolParam Item item){
        Optional<Item> existingItem = itemRepo.findByItemName(item.getItemName());
        if(existingItem.isPresent()){
            throw new IllegalArgumentException("Item with name " + item.getItemName() + " already exists.");
        }
        return itemRepo.save(item);
    }

    @Tool(
        name="GetItemsByCategory",
        description="Retrieve items based on their category."
    )
    public List<Item> getItemByCategory(@ToolParam ItemCategory category){
        return itemRepo.findByCategory(String.valueOf(category));
    }
}
