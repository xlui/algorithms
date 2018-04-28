package me.xlui.algo.Problem165;

public class Solution {
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int len1 = v1.length;
		int len2 = v2.length;
		int max = Math.max(len1, len2);
		for (int i = 0; i < max; i++) {
			int ver1, ver2;
			try {
				ver1 = Integer.parseInt(v1[i]);
			} catch (Exception e) {
				ver1 = 0;
			}
			try {
				ver2 = Integer.parseInt(v2[i]);
			} catch (Exception e) {
				ver2 = 0;
			}
			if (ver1 > ver2) {
				return 1;
			} else if (ver1 < ver2) {
				return -1;
			}
		}
		return 0;
	}
}
