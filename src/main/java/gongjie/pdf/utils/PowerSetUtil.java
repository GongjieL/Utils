public class PowerSetUtil {
    /**
     * @param originalList 求真子集
     * @param allList
     * @return
     */
    static List<List<Integer>> getSubsets(List<Integer> originalList,List<List<Integer>> allList) {
        for (int i = 0; i < originalList.size(); i++) {//这个就是结束的标志
            Integer remove = originalList.remove(i);
            //去除一个元素
            List<Integer> newList = new ArrayList<>();
            newList.addAll(originalList);
            //判断去重
            if(!allList.contains(newList)){
                allList.add(newList);
            }
            getSubsets(originalList,allList);
            //将去除的元素添加回来,以删除下一个index处的元素
            originalList.add(i, remove);
        }
        allList.sort((a1,a2)->{
            return Integer.valueOf(a2.size()).compareTo(Integer.valueOf(a1.size()));
        });
        return allList;
    }
}
