package datastructures.rateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import static java.lang.System.currentTimeMillis;

public class RateLimiter {
	// <user, <ts, val>>. There can be multiple requests on a single millisecond
	private static Map<String, Map<Long, Integer>> userRequests = new HashMap<>();

	// MinHeap to remove the oldest entry. We're only concerned about last 3s
	private static Map<String, PriorityQueue<Long>> mapUserToTsHeap = new HashMap<>();

	static boolean shouldRateLimit(String userId) {
		long currentTimeinMillis = System.currentTimeMillis();

		if (userRequests.containsKey(userId)) {
			Map<Long, Integer> userRequests = RateLimiter.userRequests.get(userId);
			PriorityQueue<Long> minHeap = mapUserToTsHeap.get(userId);

			// Cleanup older timestamps. We only need last 3 seconds of data
			while (!minHeap.isEmpty() && (currentTimeMillis()-minHeap.peek()) > 3000 /*3s*/) {
				long tsToRemove = minHeap.poll();	// Remove from Heap
				userRequests.remove(tsToRemove);	// Remove from the user requests map
			}

			// Insert current one
			userRequests.put(currentTimeinMillis, userRequests.getOrDefault(currentTimeinMillis, 0) + 1);
			// userRequests.put(userId, requests);
			minHeap.offer(currentTimeinMillis);
			// mapUserToTsHeap.put(userId, minHeap);

			return shouldDeny(RateLimiter.userRequests.get(userId));
		}
		else {
			Map<Long, Integer> request = new HashMap<>();
			request.put(currentTimeinMillis, 1);
			userRequests.put(userId, request);

			PriorityQueue<Long> minHeap = new PriorityQueue<>((ts1, ts2) -> (int)(ts1 - ts2));
			minHeap.offer(currentTimeinMillis);
			mapUserToTsHeap.put(userId, minHeap);

			return false;
		}
	}

	static boolean shouldDeny(Map<Long, Integer> userRequests) {
		int totalRequests = 0;
		for (Entry<Long, Integer> entry : userRequests.entrySet()) {
			totalRequests += entry.getValue();
		}
		return totalRequests > 10;
	}

	public static void main(String[] args) {
	}
}
