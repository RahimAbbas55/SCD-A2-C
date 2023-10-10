import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3
{
    public static void mergeIntervals ( List<int[]> intervals)
    {
        if ( intervals == null || intervals.isEmpty() )
        {
            System.out.println("Array list empty.");
            return;
        }
        int count = 0;
        for ( int i = 1 ; i < intervals.size() ; i++)
        {
            int[] curr = intervals.get(count);
            int[] next = intervals.get(i);
            if ( curr[1] >= next[0])
            {
                curr[1] = Math.max(curr[1], next[1]);
            }
            else 
            {
                count++;
                intervals.set(count , next);
            }
        }
        intervals.subList(count + 1, intervals.size()).clear();
    }
    public static void main ( String [] args )
    {
        List<int []> intervals = new ArrayList<>();
        intervals.add(new int[]{1,3});
        intervals.add(new int[]{2,6});
        intervals.add(new int[]{8,10});
        intervals.add(new int[]{15,18});

        System.out.println("Before Merging!");
        for ( int[] interval : intervals)
        {
            System.out.println(Arrays.toString(interval));
        }
        System.out.println("After Merging!");
        mergeIntervals(intervals);
        for ( int[] interval : intervals)
        {
            System.out.println(Arrays.toString(interval));
        }
    }
}