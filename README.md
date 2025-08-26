# Player_Milk_Mod
Minecraft模组，可以接玩家的奶

## 版本
Minecraft 1.12.2 Forge

## 开发环境
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-%23000000?logo=intellijidea)
![Gradle](https://img.shields.io/badge/Gradle-4.7-%2302303A?logo=gradle&labelColor=%2302303A)
![java](https://img.shields.io/badge/java-8-8)

## 构建

Windows

```cmd
git clone --branch 1.12.2-forge https://github.com/mzyxsl/Player_Milk_Mod.git
cd Player_Milk_Mod
gradlew setupDecompWorkspace
gradlew build
```

Linux

```bash
git clone --branch 1.12.2-forge https://github.com/mzyxsl/Player_Milk_Mod.git
cd Player_Milk_Mod
chmod +x gradlew  # 首次执行需要给执行权限
./gradlew setupDecompWorkspace
./gradlew build
```
