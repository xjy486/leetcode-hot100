class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 用于存储结果的集合（避免重复）
        result_indices = set()
        
        # 第一次遍历：记录每个值对应的索引（target - num 作为 key）
        value_to_index = {}
        for index, num in enumerate(nums):
            complement = target - num
            if complement not in value_to_index:
                value_to_index[complement] = index

        # 第二次遍历：查找当前值是否存在于 map 中，并且索引不同
        for index, num in enumerate(nums):
            if num in value_to_index and index != value_to_index[num]:
                result_indices.add(index)
                result_indices.add(value_to_index[num])
                break  # 找到一组即可返回，避免继续遍历浪费资源

        return list(result_indices)