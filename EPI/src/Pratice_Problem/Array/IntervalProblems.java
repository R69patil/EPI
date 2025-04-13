package Pratice_Problem.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class IntervalProblems {
    public static void main(String[] args) {
        // Test cases for Merge Intervals
        System.out.println("==== Merge Intervals Test ====");
        int[][] mergeInput = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Input: " + Arrays.deepToString(mergeInput));
        int[][] mergeOutput = mergeIntervals(mergeInput);
        System.out.println("Output: " + Arrays.deepToString(mergeOutput));
        System.out.println();

        // Test cases for Insert Interval
        System.out.println("==== Insert Interval Test ====");
        int[][] insertInput = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println("Input intervals: " + Arrays.deepToString(insertInput));
        System.out.println("New interval: " + Arrays.toString(newInterval));
        int[][] insertOutput = insertInterval(insertInput, newInterval);
        System.out.println("Output: " + Arrays.deepToString(insertOutput));
        System.out.println();

        // Test cases for Meeting Rooms II
        System.out.println("==== Meeting Rooms II Test ====");
        int[][] meetingsInput = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Input: " + Arrays.deepToString(meetingsInput));
        int rooms = minMeetingRooms(meetingsInput);
        System.out.println("Minimum rooms required: " + rooms);
        System.out.println();

        // Test cases for Interval List Intersections
        System.out.println("==== Interval List Intersections Test ====");
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println("First list: " + Arrays.deepToString(firstList));
        System.out.println("Second list: " + Arrays.deepToString(secondList));
        int[][] intersections = intervalIntersection(firstList, secondList);
        System.out.println("Intersections: " + Arrays.deepToString(intersections));
        System.out.println();

        // Test cases for Non-overlapping Intervals
        System.out.println("==== Non-overlapping Intervals Test ====");
        int[][] eraseInput = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Input: " + Arrays.deepToString(eraseInput));
        int minRemoval = eraseOverlapIntervals(eraseInput);
        System.out.println("Minimum intervals to remove: " + minRemoval);
    }

    // 1. Merge Intervals
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        
        System.out.println("Merge Intervals Iteration:");
        System.out.println("- Start with first interval: " + Arrays.toString(currentInterval));
        
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            System.out.println("- Processing interval: " + Arrays.toString(interval));
            
            // If current interval overlaps with the last interval in result
            if (interval[0] <= currentInterval[1]) {
                System.out.println("  Overlaps! Merging intervals");
                // Merge them by updating the end time of the last interval
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
                System.out.println("  Updated last interval to: " + Arrays.toString(currentInterval));
            } else {
                System.out.println("  No overlap. Adding as new interval");
                // No overlap, add current interval to result
                currentInterval = interval;
                result.add(currentInterval);
            }
            
            System.out.println("  Current result: " + listToString(result));
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    // 2. Insert Interval
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        
        System.out.println("Insert Interval Iteration:");
        
        // Add all intervals that come before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            System.out.println("- Interval " + Arrays.toString(intervals[i]) + " comes before new interval");
            result.add(intervals[i]);
            i++;
        }
        
        System.out.println("- Adding intervals that don't overlap with new interval: " + listToString(result));
        
        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            System.out.println("- Merging with interval " + Arrays.toString(intervals[i]));
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            System.out.println("  Updated new interval: " + Arrays.toString(newInterval));
            i++;
        }
        
        // Add the merged interval
        result.add(newInterval);
        System.out.println("- After adding merged interval: " + listToString(result));
        
        // Add all intervals that come after newInterval
        while (i < n) {
            System.out.println("- Adding remaining interval: " + Arrays.toString(intervals[i]));
            result.add(intervals[i]);
            i++;
        }
        
        System.out.println("- Final result: " + listToString(result));
        
        return result.toArray(new int[result.size()][]);
    }
    
    // 3. Meeting Rooms II
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        System.out.println("Meeting Rooms II Iteration:");
        System.out.println("- Sorted meetings: " + Arrays.deepToString(intervals));
        
        // Min heap to track earliest ending meeting
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add the end time of the first meeting
        minHeap.add(intervals[0][1]);
        System.out.println("- Added first meeting end time: " + intervals[0][1]);
        System.out.println("  Current heap: " + minHeap);
        
        // Process the rest of the meetings
        for (int i = 1; i < intervals.length; i++) {
            System.out.println("- Processing meeting: " + Arrays.toString(intervals[i]));
            
            // If the current meeting starts after the earliest ending meeting,
            // we can reuse that room. Remove the earliest ending meeting.
            if (intervals[i][0] >= minHeap.peek()) {
                int removed = minHeap.poll();
                System.out.println("  Meeting starts after earliest ending (" + removed + "), reusing room");
            } else {
                System.out.println("  Need a new room");
            }
            
            // Add the end time of the current meeting
            minHeap.add(intervals[i][1]);
            System.out.println("  Added end time: " + intervals[i][1]);
            System.out.println("  Current heap: " + minHeap);
        }
        
        // The size of the heap is the number of rooms required
        System.out.println("- Final heap size (rooms needed): " + minHeap.size());
        return minHeap.size();
    }
    
    // 4. Interval List Intersections
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        
        System.out.println("Interval List Intersections Iteration:");
        
        while (i < firstList.length && j < secondList.length) {
            System.out.println("- Comparing intervals: " + Arrays.toString(firstList[i]) 
                             + " and " + Arrays.toString(secondList[j]));
            
            // Find the overlap
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            // If there is an overlap, add it to result
            if (start <= end) {
                result.add(new int[]{start, end});
                System.out.println("  Found intersection: [" + start + ", " + end + "]");
            } else {
                System.out.println("  No intersection");
            }
            
            // Move pointer of the interval that ends earlier
            if (firstList[i][1] < secondList[j][1]) {
                System.out.println("  Moving first list pointer");
                i++;
            } else {
                System.out.println("  Moving second list pointer");
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    // 5. Non-overlapping Intervals
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        System.out.println("Non-overlapping Intervals Iteration:");
        System.out.println("- Sorted by end time: " + Arrays.deepToString(intervals));
        
        int count = 0;
        int end = intervals[0][1];
        
        System.out.println("- Start with interval: " + Arrays.toString(intervals[0]));
        System.out.println("  Current end time: " + end);
        
        for (int i = 1; i < intervals.length; i++) {
            System.out.println("- Processing interval: " + Arrays.toString(intervals[i]));
            
            // If current interval overlaps with previous interval
            if (intervals[i][0] < end) {
                // Remove the current interval
                count++;
                System.out.println("  Overlap detected! Removing this interval");
                System.out.println("  Count of removed intervals: " + count);
            } else {
                // Update end time
                end = intervals[i][1];
                System.out.println("  No overlap. Keeping this interval");
                System.out.println("  Updated end time: " + end);
            }
        }
        
        return count;
    }
    
    // Helper method to print list of intervals
    private static String listToString(List<int[]> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            int[] interval = list.get(i);
            sb.append("[").append(interval[0]).append(", ").append(interval[1]).append("]");
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}