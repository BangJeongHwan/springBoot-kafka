package com.api.common.util;

import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jh.kim
 *
 */
public final class CommonGenerator {
	
	private static AtomicInteger aiSerialNumberKey = new AtomicInteger();
	
	private static Map<GeneratorKey, AtomicInteger> aiMap = new HashMap<GeneratorKey, AtomicInteger>();
	
	public enum GeneratorKey {
		RECV_AT,
		RECV_FT,
		RECV_MT,
		RECV_PUSH,
		RECV_EMAIL,
		
		SEND_AT,
		SEND_FT,
		@Deprecated
		SEND_MT,
		SEND_PUSH,
		SEND_EMAIL,
		SEND_SMT,
		SEND_LMT,
		SEND_MMT,
		SEND_IMT,
		
		@Deprecated
		RESEND_AT,
		RESEND_SMT,
		RESEND_LMT,
		RESEND_MMT,

		REPORT,
		REPORT_AT_REALTIME,
		REPORT_AT_PUSH,
		REPORT_FT,
		REPORT_KAKAO,
		REPORT_MT,
		REPORT_PUSH,
		TARGET,
		
		DB_AT,
		DB_AT_REALTIME,
		DB_AT_PUSH,
		DB_FT,
		DB_KAKAO,
		DB_MT,
		DB_PUSH,
		
		COMMON_LOG,
	}
	
	public static String REDIS_AT_MSGID_PREFIX = "ATM:";
	public static String REDIS_FT_MSGID_PREFIX = "FTM:";
	public static String REDIS_SM_MSGID_PREFIX = "SMM:";
	public static String REDIS_LM_MSGID_PREFIX = "LMM:";
	public static String REDIS_MM_MSGID_PREFIX = "MMM:";
	public static String REDIS_IM_MSGID_PREFIX = "IMM:";
	public static String REDIS_MM_FILENAME_PREFIX = "MMF:";
	public static String REDIS_PUSH_MSGID_PREFIX = "PSM:";
	public static String REDIS_KSKYB_MSGID_PREFIX = "KSKYB:";
	
	private static String REPORT_MQ_PREFIX = "CLIENT_REPORT_";
	
	public static String generateSerialNumber(String prefix, String serverName, String msgUid) {
		return new StringBuilder(prefix)
				.append(serverName).append("_")
				.append(DateTime.now().toString("ddHHmmssSSS"))
				.append((aiSerialNumberKey.incrementAndGet() % 900 + 100)).append("_")
				.append(msgUid).toString();
	}
	
	public static String reportMqDestination(String clientId) {
		return REPORT_MQ_PREFIX + clientId;
	}
	
	public static String getRoundRobinListValue(GeneratorKey key, List<String> list) {
		if (list == null || list.size() <= 0) {
			return null;
		}
		
		AtomicInteger ai = aiMap.get(key);
		if (ai == null) {
			ai = new AtomicInteger();
		}
		
		String value = list.get(ai.incrementAndGet() % list.size());
		aiMap.put(key, ai);
		
		return value;
	}
	
	public static int nextAiInteger(AtomicInteger ai, int min, int max) {
		if (ai.get() == max) {
			ai.set(min);
		}
		return ai.getAndIncrement();
	}
	
}
