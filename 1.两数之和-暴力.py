class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = []
        for index_i, i in enumerate(nums):
             for index_j, j in enumerate(nums):
                if i + j == target and index_i < index_j:
                    res.append(index_i)
                    res.append(index_j)

        return res