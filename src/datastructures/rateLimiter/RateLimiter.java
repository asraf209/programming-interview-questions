package datastructures.rateLimiter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RateLimiter {
	// <user, <time-in-minutes, count>>
	private static Map<String, Map<Long, Integer>> requestsPerUser = new HashMap<>();

	public static boolean shouldRateLimit(String userId) {
		long currentTimeInMinutes = System.currentTimeMillis()/(1000*60);

		if (requestsPerUser.containsKey(userId)) {
			// Cleanup entries more than an hour old
			Map<Long, Integer> requestsByMinute = requestsPerUser.get(userId);
			for (long eachMinute : requestsByMinute.keySet()) {
				if ((currentTimeInMinutes - eachMinute) > 60) {
					requestsByMinute.remove(eachMinute);
					continue;
				}

				break;
			}

			// Deny if more than 5 requests per Minute
			if (requestsByMinute.containsKey(currentTimeInMinutes) && requestsByMinute.get(currentTimeInMinutes) >= 5) {
				return true;
			}

			// Deny if more than 200 requests per hour
			int requestsPerHour = 0;
			for (long eachMinute : requestsByMinute.keySet()) {
				requestsPerHour += requestsByMinute.get(eachMinute);
			}

			if (requestsPerHour > 200)	return true;

			requestsByMinute.put(currentTimeInMinutes, requestsByMinute.getOrDefault(currentTimeInMinutes, 0) + 1);
		}
		else {
			// User doesn't exist
			Map<Long, Integer> requestsByMinute = new LinkedHashMap<>();
			requestsByMinute.put(currentTimeInMinutes, 1);
			requestsPerUser.put(userId, requestsByMinute);
		}

		return false;
	}

	public static void main(String[] args) {
	}
}
