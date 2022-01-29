package Class2.MapSetHash;


import java.util.*;

public class TopKFrequentWords {

    public String[] topKFrequent(String[] combo, int k) {
        HashMap<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < combo.length; i++) {
            String name = combo[i];
            int count = 0;
            if (counts.get(name) != null) {
                count = counts.get(name);
            }
            count++;
            counts.put(name, count);
        }

        PriorityQueue<HashMap.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (HashMap.Entry<String, Integer> entry: counts.entrySet()) {
            String key = entry.getKey();
            Integer count = entry.getValue();
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (count > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);

            }
        }


        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }

        return result;

    }



    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();

        String[] combo = {"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        int k = 5;
        String[] result = solution.topKFrequent(combo, k);
        System.out.println(Arrays.toString(result));
    }



}
// TC O (n + nlogk + klogk)
// SC O (n + k)