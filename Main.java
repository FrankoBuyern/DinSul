import java.io.*;
import java.util.*;

public class Main {

    static long X;
    static long K;
    static ArrayList<Long> starts = new ArrayList<>();

    static long count(long time) {
        long res = 0;

        for (long start : starts) {
            if (time >= start) {
                res += (time - start) / X + 1;

                if (res >= K) {
                    return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        HashMap<Long, Long> minStart = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long t = Long.parseLong(st.nextToken());

            long r = t % X;

            minStart.merge(r, t, Math::min);
        }

        starts.addAll(minStart.values());

        long left = 0;
        long right = 1_000_000_000_000_000_000L;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (count(mid) >= K) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}