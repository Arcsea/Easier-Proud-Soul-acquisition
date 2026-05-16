with open(r'D:\Code\Easier Proud Soul acquisition\src\main\java\org\examplea\easier_proud_soul_acquisition\Easier_proud_soul_acquisition.java', 'r', encoding='utf-8') as f:
    lines = f.readlines()

# 查找并移除onServerStarting方法上的@SubscribeEvent注解
for i, line in enumerate(lines):
    if 'public void onServerStarting(ServerStartingEvent event)' in line:
        # 检查前一行是否是@SubscribeEvent
        if i > 0 and '@SubscribeEvent' in lines[i-1]:
            lines[i-1] = '    // Server starting event - registered on Forge event bus\n'
        break

with open(r'D:\Code\Easier Proud Soul acquisition\src\main\java\org\examplea\easier_proud_soul_acquisition\Easier_proud_soul_acquisition.java', 'w', encoding='utf-8') as f:
    f.writelines(lines)

print("Fixed @SubscribeEvent annotation on onServerStarting method")