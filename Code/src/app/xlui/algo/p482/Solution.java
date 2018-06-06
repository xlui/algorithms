package app.xlui.algo.p482;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
	public String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder(Arrays.stream(S.split("-"))
				.parallel()
				.map(String::toUpperCase)
				.collect(Collectors.joining())
		);
		for (int i = sb.length() - K; i > 0; i -= K) {
			sb.insert(i, "-");
		}
		return sb.toString();
	}

	public String licenseKeyFormatting2(String S, int K) {
		int len = S.length();
		StringBuilder sb = new StringBuilder(len + len / K);
		for (int i = len - 1, j = 0; i >= 0; i--) {
			char c = S.charAt(i);
			if (c == '-') {
				continue;
			} else if (c > 96) {
				c -= 32;
			}
			if (j++ % K == 0) {
				sb.append('-');
			}
			sb.append(c);
		}
		return sb.length() == 0 ? "" : sb.deleteCharAt(0).reverse().toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.licenseKeyFormatting2("5F3Z-2e-9-w", 4));
		System.out.println(solution.licenseKeyFormatting2("2-5g-3-J", 2));
	}
}
