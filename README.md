# DPP-Core

## 리포지토리 - Repository
```gradle
    maven {
        url "http://dpp.dpnw.site:8081/repository/maven-public/"
        allowInsecureProtocol = true
    }
```
## 디펜던시 - Dependencies
```gradle
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.18.2-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.18.1-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.17.1-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.16.5-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.15.2-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.14.4-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.13.2-SNAPSHOT'
```
## Spigot & CraftBukkit
```gradle
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.18.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.18.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.18'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.17.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.17'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.5'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.4'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.3'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.15.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.15.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.15'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.4'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.3'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.13.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.13.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.13'

compileOnly 'org.spigotmc:spigot-api:R0.1:1.18.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.18.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.18'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.17.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.17'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.5'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.4'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.3'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.15.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.15.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.15'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14.4'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14.3'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.13.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.13.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.13'
```
## API
### DInventory
```java
DInventory inv = new DInventory(null, "DInventory Test", 54, true, plugin);
ItemStack pane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
ItemStack prev = NBT.setStringTag(new ItemStack(Material.PINK_DYE), "prev", "true");
ItemMeta im = prev.getItemMeta();
im.setDisplayName("이전 페이지");
prev.setItemMeta(im);
ItemStack next = NBT.setStringTag(new ItemStack(Material.LIME_DYE), "next", "true");
im = next.getItemMeta();
im.setDisplayName("다음 페이지");
next.setItemMeta(im);
inv.setPageTools(new ItemStack[]{pane, pane, prev, pane, pane, pane, next, pane, pane});
inv.addPageContent(/*ItemStack[]*/);
inv.update();
Player#openInventory(inv);
```
### InventoryUtils
```java
Player p = Bukkit.getPlayer("DEAD_POOLIO_");
ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 10);
if(InventoryUtils.hasEnoughSpace(p.getInventory().getStorageContents(), item)) {
    p.getInventory().addItem(item);
}else{
    p.sendMessage("Inventory has not enough space.");
}
```
### ColorUtils
```java
String s = "&aTest String"
s = ColorUtils.applyColor(s);
String s2 = "<#FFFFFF>TestString"
s2 = ColorUtils.applyColor(s2);
```
