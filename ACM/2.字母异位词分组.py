import sys
from collections import defaultdict
def group_anagrams(strs):
    groups = defaultdict(list)
    for s in strs:
        key = ''.join(sorted(s))
        groups[key].append(s)
    return list(groups.values())

if __name__ == "__main__":
    # 读取输入，第一行是整数n，第二行是n个字符串，以空格分隔
    n = int(sys.stdin.readline().strip())
    strs = sys.stdin.readline().split()
    
    result = group_anagrams(strs)
    for group in result:
        print(' '.join(group))