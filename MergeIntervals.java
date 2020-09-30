class Solution {
    
    class Interval implements Comparable<Interval>{
        int start, end;
        
        Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Interval interval)
        {
            return this.end - interval.end;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        List<Interval> allIntervals = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++)
            allIntervals.add(new Interval(intervals[i][0], intervals[i][1]));
        Collections.sort(allIntervals);
        List<Interval> mergedIntervals = new ArrayList<>();
        
        for(int j = allIntervals.size() -1; j > 0; j--)
        {
            if(checkMerge(allIntervals.get(j-1), allIntervals.get(j)))
            {
                int low = Math.min(allIntervals.get(j).start, allIntervals.get(j-1).start);
                int high = Math.max(allIntervals.get(j).end, allIntervals.get(j-1).end);
                allIntervals.get(j-1).start = low;
                allIntervals.get(j-1).end = high;
            }else
            {
                mergedIntervals.add(allIntervals.get(j));
            }
        }
        
        mergedIntervals.add(allIntervals.get(0));
        
        
        int[][] merged = new int[mergedIntervals.size()][2];
        int n = mergedIntervals.size();
        for(int i = 0; i < merged.length; i++)
        {
            merged[i][0] = mergedIntervals.get(n - 1-i).start;
            merged[i][1] = mergedIntervals.get(n-1-i).end;
        }
        
        return merged;
    }
    
    public boolean checkMerge(Interval i1, Interval i2)
    {
        return i1.end >= i2.start;
    }
}